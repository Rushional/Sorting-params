package com.rushional.sort_params.exception_handling;

import com.rushional.sort_params.dtos.ErrorResponse;
import com.rushional.sort_params.exceptions.InternalErrorException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class ControllerAdvisor {

    @ExceptionHandler({AuthenticationException.class})
    private ResponseEntity<ErrorResponse> getAuthenticationErrorResponse(Exception ex) {
        return createErrorResponse(HttpStatus.FORBIDDEN, ex, ex.getMessage());
    }

    @ExceptionHandler({InternalErrorException.class})
    private ResponseEntity<ErrorResponse> getInternalErrorResponse(Exception ex) {
        return createErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, ex, ex.getMessage());
    }

    private ResponseEntity<ErrorResponse> createErrorResponse(HttpStatus status, Exception ex,
                                                              String message) {
        return new ResponseEntity<>(ErrorResponse.builder()
                .timestamp(LocalDateTime.now())
                .status(status.value())
                .message(message)
                .build(),
                status);
    }
}
