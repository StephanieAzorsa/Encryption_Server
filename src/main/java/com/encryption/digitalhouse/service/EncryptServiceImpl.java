package com.encryption.digitalhouse.service;

import org.springframework.stereotype.Service;

@Service
public class EncryptServiceImpl implements EncryptService {

    /**
     * Encrypts the entire message by splitting it into words, applying the
     * encryption process to each word, and reassembling the result.
     *
     * @param message the message to encrypt.
     * @return the encrypted message.
     */
    @Override
    public String encryptMessage(String message) {
        String[] words = message.split("\\s+");
        StringBuilder result = new StringBuilder();
        for (String word : words) {
            result.append(encryptWord(word)).append(" ");
        }
        return result.toString().trim();
    }

    /**
     * Decrypts the entire message by splitting it into words, applying the
     * decryption process to each word, and reassembling the result.
     *
     * @param message the encrypted message to decrypt.
     * @return the decrypted message.
     */
    @Override
    public String decryptMessage(String message) {
        String[] words = message.split("\\s+");
        StringBuilder result = new StringBuilder();
        for (String word : words) {
            result.append(decryptWord(word)).append(" ");
        }
        return result.toString().trim();
    }

    private String encryptWord(String word) {
        String reversed = reverseWord(word);                // Step 1: Reverse the word
        String shifted = circularShift(reversed);           // Step 2: Apply letter shift
        return modularTransformation(shifted);              // Step 3: Perform modular shift
    }

    private String decryptWord(String word) {
        String revertedModular = reverseModularTransformation(word);  // Step 1: Undo modular transformation
        String revertedShifted = reverseCircularShift(revertedModular); // Step 2: Undo circular shift
        return reverseWord(revertedShifted);                           // Step 3: Reverse the word
    }

    private String reverseWord(String word) {
        return new StringBuilder(word).reverse().toString();
    }

    private String circularShift(String word) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (Character.isLetter(c)) {
                int shift = (i % 2 == 0) ? -7 : 5;  // Even positions: shift back 7, Odd positions: shift forward 5
                char base = Character.isUpperCase(c) ? 'A' : 'a';  // Determine if a letter is uppercase or lowercase
                c = (char) (((c - base + shift + 26) % 26) + base);  // Apply shift with alphabet wrapping
            }
            result.append(c);
        }
        return result.toString();
    }

    private String reverseCircularShift(String word) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (Character.isLetter(c)) {
                int shift = (i % 2 == 0) ? 7 : -5;  // Reverse the shift: even positions forward 7, odd positions back 5
                char base = Character.isUpperCase(c) ? 'A' : 'a';
                c = (char) (((c - base + shift + 26) % 26) + base);  // Apply reverse shift with alphabet wrapping
            }
            result.append(c);
        }
        return result.toString();
    }

    private String modularTransformation(String word) {
        if (word.length() <= 2) {
            return word;
        }
        // Move last 2 characters to the front, shifting the rest of the word
        return word.substring(word.length() - 2) + word.substring(0, word.length() - 2);
    }

    private String reverseModularTransformation(String word) {
        if (word.length() <= 2) {
            return word;
        }
        // Move the first 2 characters to the end, shifting the rest of the word back
        return word.substring(2) + word.substring(0, 2);
    }
}