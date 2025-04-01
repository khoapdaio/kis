package vn.khoapd.kis.shared.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import vn.khoapd.kis.shared.enums.EStatus;

import java.io.Serial;
import java.io.Serializable;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponseDto<T> implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private String status;

    private String message;


    private transient T data;

    public static <T> ApiResponseDto<T> success(T data) {
        return ApiResponseDto.<T>builder()
                .status(EStatus.SUCCESS.getValueEnum())
                .data(data)
                .build();
    }

    public static <T> ApiResponseDto<T> success(T data, String message) {
        return ApiResponseDto.<T>builder()
                .status(EStatus.SUCCESS.getValueEnum())
                .data(data)
                .message(message)
                .build();
    }

}
