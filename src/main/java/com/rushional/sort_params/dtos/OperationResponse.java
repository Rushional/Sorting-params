package com.rushional.sort_params.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class OperationResponse {
    @JsonProperty("status")
    private String operationStatus;
    @JsonProperty("result")
    private List<OperationResultDto> resultsList;
}
