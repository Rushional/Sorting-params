package com.rushional.sort_params.services.facades.impl;

import com.rushional.sort_params.dtos.OperationResultDto;
import com.rushional.sort_params.enums.OperationStatus;
import com.rushional.sort_params.services.ParamsService;
import com.rushional.sort_params.services.facades.ParamsFacade;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@AllArgsConstructor
public class ParamsFacadeImpl implements ParamsFacade {

    private final ParamsService paramsService;

    @Override
    public OperationResultDto paramsMapToHashedString(Map<String, String> paramsMap) {
        String hashedString = paramsService.hashParamsString(paramsService.paramsMapToString(paramsMap));
        return OperationResultDto.builder()
                .operationStatus(OperationStatus.SUCCESS.toString())
                .hashedSortedParams(hashedString)
                .build();
    }
}
