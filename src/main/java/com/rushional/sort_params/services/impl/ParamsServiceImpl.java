package com.rushional.sort_params.services.impl;

import com.rushional.sort_params.services.ParamsService;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ParamsServiceImpl implements ParamsService {
    @Override
    public String paramsMapToString(Map<String, String> paramsMap) {
        return paramsMap.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(entry -> entry.getKey() + "=" + entry.getValue())
                .collect(Collectors.joining("&"));
    }

    @Override
    public String hashParamsString(String paramsString) {
//        TODO: add Hmac SHA256 hashing
        return paramsString;
    }
}
