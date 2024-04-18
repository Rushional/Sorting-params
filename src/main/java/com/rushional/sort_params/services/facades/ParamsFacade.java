package com.rushional.sort_params.services.facades;

import com.rushional.sort_params.dtos.OperationResultDto;

import java.util.Map;

public interface ParamsFacade {

    OperationResultDto paramsMapToHashedString(Map<String, String> paramsMap);
}
