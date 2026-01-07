package com.url.shortener.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.url.shortener.api.model.Url;
import com.url.shortener.api.service.UrlService;

@RestController
@RequestMapping(path = "/url")
@CrossOrigin(origins = "*")
public class UrlController {
    @Autowired
    private UrlService urlService;    

    @PostMapping
    public ResponseEntity<Url> createUrl(@RequestBody String fullUrl) {
        Url url = urlService.createUrl(fullUrl);
        return new ResponseEntity<>(url, HttpStatus.CREATED);
    } 

    @GetMapping(path = "/{id}")
    public ResponseEntity<String> getUrlById(@PathVariable String id) {
        String url = urlService.getUrl(id);
        return new ResponseEntity<String>(url, HttpStatus.MOVED_PERMANENTLY);
    }


}
