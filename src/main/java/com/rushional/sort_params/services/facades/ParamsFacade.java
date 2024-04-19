package com.rushional.sort_params.services.facades;

import com.rushional.sort_params.dtos.OperationResponse;
import com.rushional.sort_params.exceptions.InternalErrorException;

import java.util.Map;

public interface ParamsFacade {

    OperationResponse paramsMapToHashedString(Map<String, String> paramsMap) throws InternalErrorException;
}
