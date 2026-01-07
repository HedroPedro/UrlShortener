package com.url.shortener.api.model;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.time.Instant;

import org.junit.jupiter.api.Test;

public class UrlTests {
    
    @Test
    public void testExpirationDateDifferentThanToday() {
        Url url = new Url("aaaa", "url");
        assertNotEquals(Instant.now(), url.getExpireAt());
    }
}
