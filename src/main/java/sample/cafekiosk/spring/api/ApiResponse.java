package sample.cafekiosk.spring.api;

import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.OK;

public record ApiResponse<T>(
    int code,
    HttpStatus status,
    String message,
    T data
) {
    public static <T> ApiResponse<T> ok(T data) {
        return ApiResponse.of(OK, data);
    }

    public static <T> ApiResponse<T> of(HttpStatus httpStatus, String message, T data) {
        return new ApiResponse<>(httpStatus, message, data);
    }

    public static <T> ApiResponse<T> of(HttpStatus httpStatus, T data) {
        return new ApiResponse<>(httpStatus, httpStatus.name(), data);
    }

    public ApiResponse(HttpStatus httpStatus, String message, T data) {
        this(httpStatus.value(), httpStatus, message, data);
    }
}
