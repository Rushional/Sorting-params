package com.rushional.sort_params.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class ParamsController {

    @GetMapping("/params")
    public ResponseEntity<String> sortParams(@RequestParam Map<String,String> allRequestParams) {
        String sortedString = allRequestParams.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(entry -> entry.getKey() + "=" + entry.getValue())
                .collect(Collectors.joining("&"));
        return ResponseEntity.ok(sortedString);
    }
}