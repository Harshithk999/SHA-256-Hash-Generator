package com.example.sha256hash;

import org.springframework.web.bind.annotation.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@RestController
@RequestMapping("/api")
public class SHA256HashController {

    @PostMapping("/generateHash")
    public String generateHash(@RequestBody String text) {
        try {
            return generateSHA256Hash(text);
        } catch (NoSuchAlgorithmException e) {
            return "Error: SHA-256 Algorithm not found.";
        }
    }

    public static String generateSHA256Hash(String input) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] encodedHash = digest.digest(input.getBytes());
        return bytesToHex(encodedHash);
    }

    private static String bytesToHex(byte[] bytes) {
        StringBuilder hexString = new StringBuilder(2 * bytes.length);
        for (byte b : bytes) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }
}
