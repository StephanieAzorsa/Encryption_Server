package com.encryption.digitalhouse.service;

public interface EncryptService {
    String encryptMessage(String message);
    String decryptMessage(String message);
}
