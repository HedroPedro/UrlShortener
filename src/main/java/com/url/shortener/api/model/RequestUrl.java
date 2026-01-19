package com.url.shortener.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RequestUrl {
    private String fullUrl;
}
