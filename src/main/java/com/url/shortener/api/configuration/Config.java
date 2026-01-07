package com.url.shortener.api.configuration;

import java.time.Duration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.github.bucket4j.Bandwidth;
import io.github.bucket4j.Bucket;
import io.seruco.encoding.base62.Base62;

@Configuration
public class Config {
    @Bean
    public Base62 getBase62() {
        return Base62.createInstance();
    }

    @Bean
    public Bucket getBucket() {
        Bandwidth limit = Bandwidth
            .builder()
            .capacity(20)
            .refillGreedy(20, Duration.ofMinutes(1L)).build();

            return Bucket.builder().addLimit(limit).build();
    }
}
