package com.rushional.sort_params.services;

import java.util.Map;

public interface ParamsService {

    String paramsMapToString(Map<String, String> paramsMap);

    String hashParamsString(String paramsString);

}
