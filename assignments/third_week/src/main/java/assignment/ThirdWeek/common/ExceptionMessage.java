package assignment.ThirdWeek.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ExceptionMessage {
    DATA_NOT_FOUND("요청하신 데이터를 찾을 수 없습니다."),
    USER_NOT_FOUND("존재하지 않는 회원입니다.");

    private final String message;
}
