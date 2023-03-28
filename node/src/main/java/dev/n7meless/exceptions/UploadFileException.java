package dev.n7meless.exceptions;

public class UploadFileException extends RuntimeException {
    public UploadFileException(String message, Throwable causer) {
        super(message, causer);
    }

    public UploadFileException(String message) {
        super(message);
    }

    public UploadFileException(Throwable cause) {
        super(cause);
    }
}
