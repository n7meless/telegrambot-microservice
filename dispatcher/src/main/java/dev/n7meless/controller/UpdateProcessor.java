package dev.n7meless.controller;

import dev.n7meless.service.UpdateProducer;
import dev.n7meless.utils.MessageUtils;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

import static dev.n7meless.RabbitQueue.*;

@Log4j
@Component
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UpdateProcessor {
    TelegramBot telegramBot;
    final MessageUtils messageUtils;
    final UpdateProducer updateProducer;

    public void registerBot(TelegramBot telegramBot) {
        this.telegramBot = telegramBot;
    }

    public void processUpdate(Update update) {
        if (update == null) {
            log.error("update is null");
            return;
        }

        if (update.getMessage() != null) {
            distributeMessagesBYType(update);
        } else {
            log.error("Receiver unsupported message type " + update);
        }
    }

    private void distributeMessagesBYType(Update update) {
        var message = update.getMessage();
        if (message.hasText()) {
            processTextMessage(update);
        } else if (message.hasDocument()) {
            processDocumentMessage(update);
        } else if (message.hasPhoto()) {
            processPhotoMessage(update);
        } else {
            setUnsupportedMessageTypeView(update);
        }
    }

    private void setUnsupportedMessageTypeView(Update update) {
        var sendMessage = messageUtils.generateSendMessageWIthText(update,
                "Неподдерживаемый тип сообщения!");
        setView(sendMessage);
    }

    public void setView(SendMessage sendMessage) {
        telegramBot.sendAnswerMessage(sendMessage);
    }

    private void setFileIsReceivedView(Update update) {
        var sendMessage = messageUtils.generateSendMessageWIthText(update,
                "Файл получен! Обрабатывается...");
        setView(sendMessage);
    }

    private void processTextMessage(Update update) {
        updateProducer.produce(TEXT_MESSAGE_UPDATE, update);
    }

    private void processDocumentMessage(Update update) {
        updateProducer.produce(DOC_MESSAGE_UPDATE, update);
        setFileIsReceivedView(update);
    }

    private void processPhotoMessage(Update update) {
        updateProducer.produce(PHOTO_MESSAGE_UPDATE, update);
        setFileIsReceivedView(update);
    }
}
