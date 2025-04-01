package vn.khoapd.kis.shared.dto;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseBuilder {

    public static <T> ResponseEntity<ApiResponseDto<T>> success(T data) {
        return new ResponseEntity<>(ApiResponseDto.success(data), HttpStatus.OK);
    }

    public static <T> ResponseEntity<ApiResponseDto<T>> success(T data, String message) {
        return new ResponseEntity<>(ApiResponseDto.success(data, message), HttpStatus.OK);
    }


    public static <T> ResponseEntity<ApiResponseDto<T>> created(T data) {
        return new ResponseEntity<>(ApiResponseDto.success(data), HttpStatus.CREATED);
    }

    public static <T> ResponseEntity<ApiResponseDto<T>> created(T data, String message) {
        return new ResponseEntity<>(ApiResponseDto.success(data,message), HttpStatus.CREATED);
    }
}
