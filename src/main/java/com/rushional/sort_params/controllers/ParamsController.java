package com.rushional.sort_params.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ParamsController {

    @PostMapping("/params")
    public String sortParams() {
        return "I'm totally a hash of a JSON of sorted param name-value pairs. Like, totally.";
    }
}