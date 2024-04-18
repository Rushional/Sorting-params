package com.rushional.sort_params.controllers;

import com.rushional.sort_params.services.facades.ParamsFacade;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@AllArgsConstructor
public class ParamsController {

    private final ParamsFacade paramsFacade;

    @GetMapping("/params")
    public ResponseEntity<String> sortParams(@RequestParam Map<String,String> allRequestParams) {
        return ResponseEntity.ok(paramsFacade.paramsMapToHashedString(allRequestParams));
    }
}