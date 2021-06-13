package az.mycompany.turboservice.controller;

import feign.FeignException;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@RestController
@ControllerAdvice
public class FeignExceptionHandler {
    @ExceptionHandler(FeignException.BadRequest.class)
    public Map<String, Object> handleFeignStatusException(FeignException e, HttpServletResponse response) {
        response.setStatus(e.status());
        return new JSONObject(e.contentUTF8()).toMap();
    }
}
