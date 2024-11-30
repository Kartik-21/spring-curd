package com.kartik.exception;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.io.IOException;

@ControllerAdvice
public class GlobalExceptionHandlerController {

//    @ExceptionHandler(CustomException.class)
//    public ResponseEntity<?> handleException(CustomException ex){
//        return new ResponseEntity<>(ex.getMessage(),ex.getStatus());
//    }

    @ExceptionHandler(CustomException.class)
    public void handleException(HttpServletResponse res, CustomException ex) throws IOException {
        res.setStatus(ex.getStatus().value());

        res.sendError(ex.getStatus().value(), ex.getMessage());
    }
}
