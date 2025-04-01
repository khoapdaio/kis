package vn.khoapd.kis.shared.exception;

import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import vn.khoapd.kis.shared.dto.ErrorResponseDto;

import java.util.List;
import java.util.UUID;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    private static final String ERROR_LOG_FORMAT = "Error: ID: {}, URI: {}, ErrorCode: {}, Message: {}";
    private static final String INVALID_REQUEST_INFORMATION_MESSAGE = "Request information is not valid";

    @ExceptionHandler({CustomRuntimeException.class, RuntimeException.class})
    public ResponseEntity<ErrorResponseDto> handleCustomException(RuntimeException exx, WebRequest request) {
        HttpStatus status;

        if (exx instanceof CustomRuntimeException ex) {
            return buildErrorResponse(ex.getStatus(), ex.getMessage(), null, ex, request, ex.getCode());
        } else {
            if (exx instanceof BadRequestException) {
                status = HttpStatus.BAD_REQUEST;
            } else if (exx instanceof NotFoundException) {
                status = HttpStatus.NOT_FOUND;
            } else if (exx instanceof InternalServerException) {
                status = HttpStatus.INTERNAL_SERVER_ERROR;
            } else {
                status = HttpStatus.NOT_IMPLEMENTED;
            }
            return buildErrorResponse(status, exx.getMessage(), null, exx, request, status.toString());
        }


    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ErrorResponseDto> handleBadRequestException(BadRequestException ex, WebRequest request) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        return buildErrorResponse(status, ex.getMessage(), null, ex, request, status.toString());
    }


    @ExceptionHandler({ConstraintViolationException.class})
    public ResponseEntity<ErrorResponseDto> handleConstraintViolation(ConstraintViolationException ex) {
        HttpStatus status = HttpStatus.BAD_REQUEST;

        List<String> errors = ex.getConstraintViolations().stream()
                .map(violation -> String.format("%s %s: %s",
                        violation.getRootBeanClass().getName(),
                        violation.getPropertyPath().toString(),
                        violation.getMessage()))
                .toList();

        return buildErrorResponse(status, INVALID_REQUEST_INFORMATION_MESSAGE, errors, ex, null, "0");
    }

//    @ExceptionHandler({MethodArgumentNotValidException.class})
//    public ResponseEntity<ErrorResponseDto> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, WebRequest request) {
//        HttpStatus status = HttpStatus.BAD_REQUEST;
//
//        List<String> errors = ex.getAllErrors().stream()
//                .map(error -> {
//                    if (error instanceof FieldError fieldError) {
//                        return fieldError.getField() + " " + fieldError.getDefaultMessage();
//                    }
//                    return error.getDefaultMessage();
//                }).toList();
//
//
//        return buildErrorResponse(status, INVALID_REQUEST_INFORMATION_MESSAGE, errors, ex, request, "0");
//    }


    private String getServletPath(WebRequest webRequest) {
        ServletWebRequest servletRequest = (ServletWebRequest) webRequest;
        return servletRequest.getRequest().getServletPath();
    }

    private ResponseEntity<ErrorResponseDto> buildErrorResponse(HttpStatus status, String message, List<String> errors,
                                                                Exception ex, WebRequest request, String errorCode) {
        String id = UUID.randomUUID().toString();

        ErrorResponseDto errorVm = ErrorResponseDto.builder()
                .id(id)
                .code(errorCode)
                .cause(status.getReasonPhrase())
                .message(message)
                .details(errors == null ? ex.getStackTrace() : errors)
                .build();

        if (request != null) {
            log.error(ERROR_LOG_FORMAT, id, this.getServletPath(request), status, message);
        }
//        log.error("[{}]: [{}]", id, KhoapdCustomUtil.getStackTrace(ex.getCause()));
        return ResponseEntity.status(status).body(errorVm);
    }
}
