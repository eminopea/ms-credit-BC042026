package com.template.ms_credit.handler;

import com.template.ms_credit.application.exception.BusinessException;
import com.template.ms_credit.infrastructure.adapters.input.dto.ExceptionDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    public Mono<ResponseEntity<ExceptionDTO>> handleCustomerException(
            BusinessException ex) {
        return Mono.just(
                ResponseEntity
                        .status(HttpStatus.BAD_REQUEST)
                        .body(ExceptionDTO.builder()
                                .timestamp(LocalDateTime.now())
                                .status(HttpStatus.BAD_REQUEST)
                                .error("CUSTOMER_ERROR")
                                .message(ex.getMessage())
                                .build()
                        )
        );
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public Mono<ResponseEntity<ExceptionDTO>> handleIllegalException(
            IllegalArgumentException ex) {
        return Mono.just(
                ResponseEntity
                        .status(HttpStatus.BAD_REQUEST)
                        .body(ExceptionDTO.builder()
                                .timestamp(LocalDateTime.now())
                                .status(HttpStatus.BAD_REQUEST)
                                .error("ILLEGAL_ERROR")
                                .message(ex.getMessage())
                                .build()
                        )
        );
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Mono<ResponseEntity<ExceptionDTO>> handleMethodArgumentNotValidException(
            MethodArgumentNotValidException ex) {
        return Mono.just(
                ResponseEntity
                        .status(HttpStatus.BAD_REQUEST)
                        .body(ExceptionDTO.builder()
                                .timestamp(LocalDateTime.now())
                                .status(HttpStatus.BAD_REQUEST)
                                .error("VALIDATION_ERROR")
                                .message("Datos de entrada inválidos")
                                .build()
                        )
        );
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public Mono<ResponseEntity<ExceptionDTO>> handleHttpMessageNotReadableException(
            HttpMessageNotReadableException ex) {

        return Mono.just(
                ResponseEntity
                        .status(HttpStatus.BAD_REQUEST)
                        .body(ExceptionDTO.builder()
                                .timestamp(LocalDateTime.now())
                                .status(HttpStatus.BAD_REQUEST)
                                .error("PARSE_ERROR")
                                .message("Error al parsear la solicitud, formato inválido")
                                .build()
                        )
        );
    }
}
