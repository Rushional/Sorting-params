package com.rushional.sort_params.services;

import com.rushional.sort_params.services.impl.EncodingServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class EncodingServiceTest {

    @InjectMocks
    private EncodingServiceImpl encodingService;

    @Test
    void hashParamsSucceeds() throws Exception {
        // given
        String stringToBeHashed = "name=value";
            String secretKey = "secret key";
        // when
        String hash = "";
        hash = encodingService.hashString(stringToBeHashed, secretKey);
        // then
        assertEquals("9a3c5c64e0fb33b90fa0bd91658760b7c69d4e2de72563a116ad8e012c135e54", hash);
    }

}