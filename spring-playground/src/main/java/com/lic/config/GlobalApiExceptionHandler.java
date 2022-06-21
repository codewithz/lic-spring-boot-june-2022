package com.lic.config;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalApiExceptionHandler {

    @ExceptionHandler(value={ResponseStatusException.class})
    public ResponseEntity<ApiExceptionPayload>
    handleApiException(ResponseStatusException exception, WebRequest request){
        String path=request.getDescription(false).replace("uri=","");

//        1. Create a Payload with exception details

        ApiExceptionPayload payload=new ApiExceptionPayload(
                exception.getMessage(),
                exception.getStatus().value(),
                String.valueOf(exception.getStatus()),
                false,
                true,
                LocalDateTime.now(),
                path
        );
//        2.Return response entity
        ResponseEntity<ApiExceptionPayload> response=new ResponseEntity<>(payload, exception.getStatus());

        return response;
    }
}
