package vn.khoapd.kis.shared.exception;

import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import vn.khoapd.kis.shared.enums.ECommonErrorCode;

@Slf4j
@RequiredArgsConstructor
@Getter
public class CustomRuntimeException extends RuntimeException {

    private final HttpStatus status;
    private final String code;
    private final String message;

    public CustomRuntimeException( ECommonErrorCode errorCode) {
        super(errorCode.getMessage());

        this.status = HttpStatus.valueOf(errorCode.getStatusCode());
        this.code = errorCode.getCode();
        this.message = errorCode.getMessage();
    }
}
