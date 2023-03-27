package dev.n7meless.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;
@Component
public class TelegramBot extends TelegramLongPollingBot {
    @Value("${telegram.bot.name}")
    private String botName;
    @Value("${telegram.bot.token}")
    private String botToken;
    @Override
    public String getBotToken() {
        return botToken;
    }

    @Override
    public void onUpdateReceived(Update update) {
        var message = update.getMessage();
        System.out.println(message.getText());
    }

    @Override
    public String getBotUsername() {
        return botName;
    }
}
