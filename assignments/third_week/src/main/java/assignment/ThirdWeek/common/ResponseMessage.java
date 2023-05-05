package assignment.ThirdWeek.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ResponseMessage {
    SUCCESS_SAVE_MESSAGE("정상적으로 저장되었습니다."),
    SUCCESS_GET_MESSAGE("정상적으로 저장되었습니다.");

    private final String message;
}
