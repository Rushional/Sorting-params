package com.rushional.sort_params.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class ParamsController {

    @PostMapping("/params")
    public String sortParams(@RequestParam Map<String,String> allRequestParams) {
        return allRequestParams.keySet().stream()
                .map(key -> key + "=" + allRequestParams.get(key))
                .collect(Collectors.joining(", ", "{", "}"));
    }
}