package com.rushional.sort_params.services.facades.impl;

import com.rushional.sort_params.dtos.OperationResultDto;
import com.rushional.sort_params.enums.OperationStatus;
import com.rushional.sort_params.exceptions.InternalErrorException;
import com.rushional.sort_params.services.EncodingService;
import com.rushional.sort_params.services.ParamsService;
import com.rushional.sort_params.services.facades.ParamsFacade;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@Slf4j
@AllArgsConstructor
public class ParamsFacadeImpl implements ParamsFacade {

    private final ParamsService paramsService;
    private final EncodingService encodingService;

    @Override
    public OperationResultDto paramsMapToHashedString(Map<String, String> paramsMap) throws InternalErrorException {
        String sortedParamsString = paramsService.paramsMapToString(paramsMap);
        String hashedString;
        try {
            hashedString = encodingService.hashParamsString(sortedParamsString);
        } catch (Exception e) {
            log.error("Hashing failed", e);
            throw new InternalErrorException("Hashing failed");
        }
        return OperationResultDto.builder()
                .operationStatus(OperationStatus.SUCCESS.toString())
                .hashedSortedParams(hashedString)
                .build();
    }
}
