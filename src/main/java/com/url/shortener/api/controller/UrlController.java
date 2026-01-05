package com.url.shortener.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.url.shortener.api.service.UrlService;

@Controller
@RequestMapping(path = "/url")
@CrossOrigin()
public class UrlController {
    @Autowired
    private UrlService urlService;    

    @GetMapping(path = "/{id}")
    public ResponseEntity<String> getUrlById(@PathVariable String id) {
        String url = urlService.getUrl(id);
        return new ResponseEntity<String>(url, HttpStatus.MOVED_PERMANENTLY);
    }


}
