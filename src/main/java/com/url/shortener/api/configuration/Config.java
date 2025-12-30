package com.url.shortener.api.configuration;

import java.security.SecureRandom;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import io.seruco.encoding.base62.Base62;

@Configuration
public class Config {
    @Bean
    public Base62 getBase62() {
        return Base62.createInstance();
    }

    @Bean
    public PasswordEncoder getEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Bean
    public SecureRandom getSecureRandom() {
        return new SecureRandom();
    }
}
