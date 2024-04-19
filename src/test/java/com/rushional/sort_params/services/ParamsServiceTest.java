package com.rushional.sort_params.services;

import com.rushional.sort_params.services.impl.EncodingServiceImpl;
import com.rushional.sort_params.services.impl.ParamsServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ParamsServiceTest {

    @InjectMocks
    private ParamsServiceImpl paramsService;

    @Test
    void paramsMapToString() {
        // given
        Map<String, String> paramsMap = new HashMap<>();
        paramsMap.put("name1", "value1");
        paramsMap.put("cabbage", "POTATO");
        // when
        String resultString = paramsService.paramsMapToString(paramsMap);
        // then
        assertEquals("cabbage=POTATO&name1=value1", resultString);
    }
}