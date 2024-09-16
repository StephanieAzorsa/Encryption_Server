package com.encryption.digitalhouse.controller;

import com.encryption.digitalhouse.service.EncryptServiceImpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/encryption")
public class EncryptController {

    private final EncryptServiceImpl encryptService;

    public EncryptController(EncryptServiceImpl encryptService) {
        this.encryptService = encryptService;
    }

    @PostMapping("/encrypt")
    public String encriptar(@RequestBody String mensaje) {
        return encryptService.encryptMessage(mensaje);
    }

    @PostMapping("/decrypt")
    public String desencriptar(@RequestBody String mensaje) {
        return encryptService.decryptMessage(mensaje);
    }
}
