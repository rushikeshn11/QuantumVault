package com.quantumvault.loans.exception;

import com.quantumvault.loans.dto.ErrorResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(LoanAlreadyExists.class)
    public ResponseEntity<ErrorResponseDto> handleLoansAlreadExists(LoanAlreadyExists ex, WebRequest webRequest) {
        {
            ErrorResponseDto errorResponseDTO = new ErrorResponseDto(
                    HttpStatus.BAD_REQUEST,
                    webRequest.getDescription(false),
                    ex.getMessage(),
                    LocalDateTime.now()
            );
            return new ResponseEntity<>(errorResponseDTO, HttpStatus.BAD_REQUEST);
        }

    }
}
