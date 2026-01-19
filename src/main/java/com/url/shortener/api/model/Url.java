package com.url.shortener.api.model;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.time.Instant;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Document
@NoArgsConstructor
@AllArgsConstructor
public class Url {
    private final static int EXPIRATION_DAYS = 10;
    @MongoId
    private String id;
    private String url;
    private LocalDateTime createdAt;
    @Indexed(name = "ttl_index", expireAfter = "0s")
    private Instant expireAt;

    public Url(String id, String url) {
        this.id = id;
        this.url = url;
        createdAt = LocalDateTime.now();
        expireAt = Instant.now().plus(EXPIRATION_DAYS, ChronoUnit.DAYS);
    }
}
