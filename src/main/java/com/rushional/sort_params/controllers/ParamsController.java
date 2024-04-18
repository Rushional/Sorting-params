package com.rushional.sort_params.controllers;

import com.rushional.sort_params.dtos.OperationResultDto;
import com.rushional.sort_params.exceptions.InternalErrorException;
import com.rushional.sort_params.services.facades.ParamsFacade;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@AllArgsConstructor
public class ParamsController {

    private final ParamsFacade paramsFacade;

    @GetMapping("/params")
//    TODO: remove exception from signature, make proper exception handling
    public OperationResultDto sortParams(@RequestParam Map<String,String> allRequestParams) throws InternalErrorException {
        return paramsFacade.paramsMapToHashedString(allRequestParams);
    }
}