package com.fastmarket.fastmarket.exceptions;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionHandler {

    /*
     * // 🔹 Exceções que geram 404
     * 
     * @ExceptionHandler(EntityNotFoundException.class)
     * 
     * @ResponseStatus(HttpStatus.NOT_FOUND)
     */
    @ExceptionHandler(Exception.class)
    public Object handleNotFoundException(EntityNotFoundException ex, HttpServletRequest request, Model model) {

        Object statusAttr = request.getAttribute("javax.servlet.error.status_code");
        int statusCode = statusAttr != null ? Integer.parseInt(statusAttr.toString()) : 500;

        String path = request.getRequestURI();

        /* boolean isRoutePath = path.startsWith("/acesso"); */

        boolean isApi = path.startsWith("/api") || path.startsWith("/{id}") ||
                (request.getHeader("Accept") != null && request.getHeader("Accept").contains("application/json"));

        if (isApi) {
            // Retorna JSON para API
            Map<String, Object> body = new HashMap<>();
            body.put("timestamp", LocalDateTime.now().toString());
            body.put("status", statusCode);
            body.put("error", HttpStatus.valueOf(statusCode).getReasonPhrase());
            body.put("message", ex.getMessage());
            body.put("path", path);

            return new ResponseEntity<>(body, HttpStatus.valueOf(statusCode));
        }

        // Caso seja rota web → retorna template Thymeleaf
        model.addAttribute("status", statusCode);
        model.addAttribute("error", HttpStatus.valueOf(statusCode).getReasonPhrase());
        model.addAttribute("message", ex.getMessage());
        model.addAttribute("timestamp", LocalDateTime.now());
        model.addAttribute("path", path);

        switch (statusCode) {
            case 400:
                return new ModelAndView("error/400", model.asMap());
            case 404:
                return new ModelAndView("error/404", model.asMap());
            case 403:
                return new ModelAndView("error/403", model.asMap());
            case 500:
                return new ModelAndView("error/500", model.asMap());
            default:
                return new ModelAndView("error/error", model.asMap());
        }

        /*
         * if (isRoutePath) {
         * // Caso contrário (rota web), retorna página HTML
         * model.addAttribute("path", path);
         * model.addAttribute("status", 404);
         * model.addAttribute("error", "Not Found");
         * model.addAttribute("message", ex.getMessage());
         * model.addAttribute("timestamp", LocalDateTime.now());
         * 
         * return new ModelAndView("/error/404", model.asMap());
         * }
         * 
         * Map<String, Object> body = new HashMap<>();
         * body.put("timestamp", LocalDateTime.now().toString());
         * body.put("status", 404);
         * body.put("error", "Not Found");
         * body.put("message", ex.getMessage());
         * body.put("path", path);
         * 
         * return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
         * 
         * }
         */
    }
}
