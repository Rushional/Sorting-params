package com.rushional.sort_params.services.facades.impl;

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
    public String paramsMapToHashedString(Map<String, String> paramsMap) {
        return paramsService.hashParamsString(paramsService.paramsMapToString(paramsMap));
    }
}
