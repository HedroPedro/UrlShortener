package com.url.shortener.api.service;

import java.security.SecureRandom;
import java.security.Security;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.url.shortener.api.exception.UrlNotFoundException;
import com.url.shortener.api.model.Url;
import com.url.shortener.api.repository.UrlRepository;

import io.seruco.encoding.base62.Base62;

@Service
public class UrlService {
    private final static String PREFIX = "{sha256}";

    @Autowired
    private Base62 base62;

    @Autowired
    private UrlRepository repository;

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private SecureRandom secureRandom;

    public Url createUrl(String fullUrl) {
        String encodedUrl;
        String id;
        StringBuilder builder = new StringBuilder();
        encodedUrl = PREFIX + fullUrl;
        encodedUrl = encoder.encode(encodedUrl);
        byte base62Result[] = base62.encode(encodedUrl.getBytes());
        encodedUrl = base62Result.toString();
        do {
            for(int i = 0; i < 8; i++) {
                int index = secureRandom.nextInt(0, encodedUrl.length());
                builder.append(base62Result[index]);
            }
            id = builder.toString();
        } while (repository.existsById(id));
        Url url = new Url(encodedUrl, id);
        return url;
    }

    public String getUrl(String id) {
        return repository.findById(id).orElseThrow(() -> new UrlNotFoundException(id)).getUrl();
    }
}
