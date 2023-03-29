package dev.n7meless.service;

import dev.n7meless.dto.MailParams;

public interface MailSenderService {
    void send(MailParams mailParams);
}