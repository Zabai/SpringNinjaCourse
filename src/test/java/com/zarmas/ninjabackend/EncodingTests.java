package com.zarmas.ninjabackend;

import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class EncodingTests {
    @Test
    public void encode_text() {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String rawPassword = "user";
        String password = passwordEncoder.encode(rawPassword);
        System.out.println(
                "Raw password: '" + rawPassword + "'\n" +
                "Encoded password: '" + password + "'"
        );
    }
}
