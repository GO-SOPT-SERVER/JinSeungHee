package assignment.ThirdWeek.common.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
public class ApiResponse {

    private boolean success;
    private String message;
    private Object data;

    public static ApiResponse success(String message, Object data) {
        return new ApiResponse(true, message, data);
    }

    public static ApiResponse success(String message) {
        return new ApiResponse(true, message, null);
    }

    public static ApiResponse fail(String message) {
        return new ApiResponse(false, message, null);
    }
}
