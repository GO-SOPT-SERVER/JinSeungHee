package assignment.ThirdWeek.common.controller;

import assignment.ThirdWeek.common.dto.ApiResponse;
import assignment.ThirdWeek.exception.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class ExceptionController {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ApiResponse> handleNotFoundException(NotFoundException e) {
        log.error("handleNotFoundException", e);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ApiResponse.fail(e.getMessage()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        log.error("handleMethodArgumentNotValidException", e);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ApiResponse.fail(e.getMessage()));
    }
}
