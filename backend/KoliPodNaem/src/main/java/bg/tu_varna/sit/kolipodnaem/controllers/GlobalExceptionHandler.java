package bg.tu_varna.sit.kolipodnaem.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.sql.SQLException;

@ControllerAdvice
public class GlobalExceptionHandler {
    private class ErrorMessage {
        private String message;

        public ErrorMessage(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }
    @ExceptionHandler(SQLException.class)
    public ResponseEntity<ErrorMessage> handleResourceNotFound(SQLException ex) {
        return ResponseEntity.status(409).body(new ErrorMessage(ex.getMessage()));
    }

}
