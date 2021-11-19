package com.lkefalas.samplemoviedatabase.exception;

import com.lkefalas.samplemoviedatabase.base.AbstractLogComponent;
import com.lkefalas.samplemoviedatabase.transfer.ApiError;
import com.lkefalas.samplemoviedatabase.transfer.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.nio.file.AccessDeniedException;
import java.util.NoSuchElementException;
import java.util.Set;

/**
 * This class is responsible for handling all errors, exceptions in a wider sense, that can be thrown while handling the
 * incoming request.
 */
@RestControllerAdvice
public class CustomizedExceptionHandler extends AbstractLogComponent {
    @ExceptionHandler(NoHandlerFoundException.class)
    public final ResponseEntity<ApiResponse<?>> handleNoHandlerFoundException(final Exception ex, final WebRequest request) {
        String msg = "Unsupported request.";
        return exceptionHandler(ex,HttpStatus.NOT_IMPLEMENTED,request,msg);
    }
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ApiResponse<?>> handleAllExceptions(final Exception ex, final WebRequest request) {
        String msg = "Unexpected exception occurred.";
        return exceptionHandler(ex,HttpStatus.INTERNAL_SERVER_ERROR,request,msg);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public final ResponseEntity<ApiResponse<?>> handleConstraintViolationException(final ConstraintViolationException  ex, final WebRequest request) {
        String msg = "Validation error";
        return exceptionHandler(ex,HttpStatus.BAD_REQUEST,request,msg, ex.getConstraintViolations());
    }

    @ExceptionHandler(AccessDeniedException.class)
    public final ResponseEntity<ApiResponse<?>> handleAccessDenials(final Exception ex, final WebRequest request) {
        String msg = "Access denied due to lack of authorization privileges.";
        return exceptionHandler(ex,HttpStatus.FORBIDDEN,request,msg);
    }

    @ExceptionHandler(NoSuchElementException.class)
    public final ResponseEntity<ApiResponse<?>> handleNonExistence(final NoSuchElementException ex,
                                                                   final WebRequest request) {
        String msg = "Reference to a non-existent object.";
        return exceptionHandler(ex,HttpStatus.NOT_FOUND,request,msg);
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    protected ResponseEntity<ApiResponse<?>> handleMissingServletRequestParameter(
            final MissingServletRequestParameterException ex, final WebRequest request) {
        String msg = "There was a parameter missing from incoming request";
        return exceptionHandler(ex,HttpStatus.BAD_REQUEST,request,msg);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<ApiResponse<?>> handleMethodArgumentNotValid(final MethodArgumentNotValidException ex,
                                                                          final WebRequest request) {
        String msg = "Method argument is invalid.";
        return exceptionHandler(ex,HttpStatus.BAD_REQUEST,request,msg);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<ApiResponse<?>> handleMethodArgumentTypeMismatch(final MethodArgumentTypeMismatchException ex,
                                                                           final WebRequest request) {
        String msg = "Method argument, although matched, is of wrong type.";
        return exceptionHandler(ex,HttpStatus.BAD_REQUEST,request,msg);
    }

    public ResponseEntity<ApiResponse<?>> exceptionHandler(final Exception ex, final HttpStatus status, final WebRequest request, String customMessage) {
        logger.error(customMessage, ex);
        return new ResponseEntity<>(
                ApiResponse.builder().apiError(getApiError(ex, status, request)).build(),
                status);
    }

    public ResponseEntity<ApiResponse<?>> exceptionHandler(final Exception ex, final HttpStatus status, final WebRequest request, String message, Set<ConstraintViolation<?>> constraintViolation) {

        return new ResponseEntity<>(
                ApiResponse.builder().apiError(getApiError(ex, status, request, constraintViolation, message)).build(),
                status);
    }

    private ApiError getApiError(final Exception ex, final HttpStatus status, final WebRequest request) {
        String path = request.getDescription(false);
        if (path.indexOf("uri=") == 0) {
            path = StringUtils.replace(path, "uri=", "");
        }
        return new ApiError(status.value(), ex.getMessage(), path);
    }

    private ApiError getApiError(final Exception ex, final HttpStatus status, final WebRequest request,
                                 Set<ConstraintViolation<?>> subErrors, String message) {
        String path = request.getDescription(false);
        if (path.indexOf("uri=") == 0) {
            path = StringUtils.replace(path, "uri=", "");
        }
        ApiError apiError = new ApiError(status.value(), message, path);
        apiError.addValidationErrors(subErrors);

        return apiError;
    }
}
