package br.com.rodrigoeduque.gerenciadorMultas.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class ApiHandlerException extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {

        BindingResult bindingResult = ex.getBindingResult();
        List<Object> erros = new ArrayList<>();

        bindingResult.getFieldErrors().stream().forEach(x -> {
            Map<String, Object> map = new HashMap<>();
            map.put("field", x.getField());
            map.put("message", x.getDefaultMessage());
            erros.add(map);
        });

        DefaultApiMessageError defaultApiMessageError = new DefaultApiMessageError(ex.getStatusCode(), erros);

        return new ResponseEntity<>(defaultApiMessageError, status);
    }
}
