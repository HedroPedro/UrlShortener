package com.url.shortener.api.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.seruco.encoding.base62.Base62;

@Configuration
public class Config {
    @Bean
    public Base62 getBase62() {
        return Base62.createInstance();
    }
}
