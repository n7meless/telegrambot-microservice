package dev.n7meless.service;

import dev.n7meless.entity.AppDocument;
import dev.n7meless.entity.AppPhoto;
import dev.n7meless.service.enums.LinkType;
import org.telegram.telegrambots.meta.api.objects.Message;

public interface FileService {
    AppDocument processDoc(Message externalMessage);

    AppPhoto processPhoto(Message externalMessage);

    String generateLink(Long docId, LinkType linkType);

}
