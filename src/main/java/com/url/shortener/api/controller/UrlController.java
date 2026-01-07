package com.url.shortener.api.controller;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.url.shortener.api.exception.UrlKeyNotFoundException;
import com.url.shortener.api.model.Url;
import com.url.shortener.api.service.UrlService;

import io.github.bucket4j.Bucket;

@RestController
@RequestMapping(path = "/api/v0/url")
@CrossOrigin(origins = "*")
public class UrlController {
    @Autowired
    private UrlService urlService;

    @Autowired
    private Bucket bucket;

    @PostMapping
    public ResponseEntity<Url> createUrl(@RequestBody Map<String, String> req) {
        if (!bucket.tryConsume(1))
            return new ResponseEntity<>(HttpStatus.TOO_MANY_REQUESTS);

        String fullUrl = Optional.of(req.get("url"))
            .orElseThrow(() -> new UrlKeyNotFoundException());

        Url url = urlService.createUrl(fullUrl);
        return new ResponseEntity<>(url, HttpStatus.CREATED);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<String> getUrlById(@PathVariable String id) {
        if (!bucket.tryConsume(1))
            return new ResponseEntity<>(HttpStatus.TOO_MANY_REQUESTS);
        String url = urlService.getUrl(id);
        return new ResponseEntity<String>(url, HttpStatus.MOVED_PERMANENTLY);
    }


}
