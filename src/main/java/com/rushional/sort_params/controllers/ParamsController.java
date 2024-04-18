package com.rushional.sort_params.controllers;

import com.rushional.sort_params.dtos.OperationResultDto;
import com.rushional.sort_params.exceptions.InternalErrorException;
import com.rushional.sort_params.services.facades.ParamsFacade;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@AllArgsConstructor
public class ParamsController {

    private final ParamsFacade paramsFacade;

    @GetMapping("/params/{operationId}")
//    TODO: remove exception from signature, make proper exception handling
    public OperationResultDto sortParams(@PathVariable("operationId") Long operationId,
                                         @RequestParam Map<String,String> allRequestParams)
            throws InternalErrorException {
//        TODO: remove this
        System.out.println(operationId);
        return paramsFacade.paramsMapToHashedString(allRequestParams);
    }
}