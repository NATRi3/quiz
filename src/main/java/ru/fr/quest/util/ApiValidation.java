package ru.fr.quest.util;

import org.slf4j.Logger;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import ru.fr.quest.exception.ValidationException;

import javax.validation.ConstraintViolationException;
import java.util.*;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class ApiValidation {
    private ApiValidation() {
    }

    public static Supplier<ValidationException> validationExceptionSupplier(String message) {
        return () -> new ValidationException(message);
    }

    public static void requireNotNull(Object o) {
        requireNotNull(o, "Null pointer exception during processing");
    }

    public static void requireNotNull(Object... o) {
        Arrays.stream(o).forEach(ApiValidation::requireNotNull);
    }

    public static void requireNotNull(Object o, String errorMessage) {
        if (o == null)
            throw validationExceptionSupplier(errorMessage).get();
    }


    public static void requireEquality(Object a, Object b) {
        requireNotNull(a);
        if (!a.equals(b)) {
            throw validationExceptionSupplier("Required equality").get();
        }
    }

    public static void requireEquality(Object a, Object b, String errorMessage) {
        requireNotNull(a);
        if (!a.equals(b)) {
            throw validationExceptionSupplier(errorMessage).get();
        }
    }


    public static void requireTrue(boolean val) {
        requireTrue(val, "Required TRUE");
    }

    public static void requireTrue(boolean val, String message) {
        if (!val)
            throw validationExceptionSupplier(message).get();
    }


    public static void requireFalse(boolean val) {
        requireFalse(val, "Required FALSE");
    }

    public static void requireFalse(boolean val, String message) {
        if (val)
            throw validationExceptionSupplier(message).get();
    }

    public static void requireFalse(boolean val, Logger logger, String message) {
        if (val) {
            logger.warn(message);
            throw validationExceptionSupplier(message).get();
        }
    }
}
