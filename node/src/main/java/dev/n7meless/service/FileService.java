package dev.n7meless.service;

import dev.n7meless.entity.AppDocument;
import dev.n7meless.entity.AppPhoto;
import org.telegram.telegrambots.meta.api.objects.Message;

public interface FileService {
    AppDocument processDoc(Message externalMessage);

    AppPhoto processPhoto(Message externalMessage);

}
