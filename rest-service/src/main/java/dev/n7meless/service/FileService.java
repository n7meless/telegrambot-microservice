package dev.n7meless.service;

import dev.n7meless.entity.AppDocument;
import dev.n7meless.entity.AppPhoto;

public interface FileService {
    AppDocument getDocument(String id);

    AppPhoto getPhoto(String id);
}
