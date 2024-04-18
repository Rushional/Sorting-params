package com.rushional.sort_params.services.facades;

import java.util.Map;

public interface ParamsFacade {

    String paramsMapToHashedString(Map<String, String> paramsMap);
}
