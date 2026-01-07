package com.url.shortener.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
public class UrlKeyNotFoundException extends RuntimeException{
    public UrlKeyNotFoundException() {
        super("Expected \"{url: <some_url>}\"");
    }
}
