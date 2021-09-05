package ru.fr.quest.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class QuizNotFoundException extends RuntimeException{
    public QuizNotFoundException() {
    }

    public QuizNotFoundException(String message) {
        super(message);
    }

    public QuizNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public QuizNotFoundException(Throwable cause) {
        super(cause);
    }
}
