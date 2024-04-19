package com.rushional.sort_params.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ParamsControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Value("${constants.sort-params-operation-number}")
    private String sortParamsOperationNumber;

    @Value("${constants.params-hashing-header-token}")
    private String tokenHeader;

    private final String PARAMS_PATH = "/params";

    @Test
    void sortParamsSucceeds() throws Exception {
        mockMvc.perform(get(PARAMS_PATH + "/" + sortParamsOperationNumber)
                        .header("Token", tokenHeader)
                        .param("permanent", "fire")
                        .param("cold_frost", "on_the_pyre")
                        .param("fruit", "never_expires"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value("success"))
                .andExpect(jsonPath("$.result[*].signature").exists())
                .andExpect(jsonPath("$.result[0].signature")
                        .value("cc4db159524f610573c3840c8008bf43de6f40b73954ea68078ce87a8616dc0c"));
    }
}