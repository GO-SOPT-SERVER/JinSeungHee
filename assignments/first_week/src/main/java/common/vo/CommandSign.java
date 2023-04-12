package common.vo;

import java.util.Arrays;
import java.util.Objects;
import java.util.function.Predicate;

public enum CommandSign {
    MEMBER_REGISTER_SIGN(1, "회원가입을 선택하셨습니다."),
    ACCOUNT_REGISTER_SIGN(2, "계좌 개설을 선택하셨습니다."),
    ACCOUNT_VIEW_SIGN(3, "계좌 거래 조회를 선택하셨습니다.");

    private int signNumber;
    private String message;

    CommandSign(int signNumber, String message) {
        this.signNumber = signNumber;
        this.message = message;
    }

    public int getSignNumber() {
        return signNumber;
    }

    public String getMessage() {
        return message;
    }

    private static CommandSign find(Predicate<CommandSign> predicate) {
        return Arrays.stream(values()).filter(predicate).findAny().orElseThrow(IllegalArgumentException::new);
    }

    public static CommandSign findCommandSignWithSignNumber(int signNumber) {
        return find(e -> Objects.equals(e.signNumber, signNumber));
    }
}
