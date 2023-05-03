package sopt.org.ThirdSeminar.controller.dto.response;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class UserResponseDto {
    private Long userId;
    private String nickname;

    // UserResponseDto 를 생성하는 메서드
    public static UserResponseDto of(Long userId, String nickname) {
        return new UserResponseDto(userId, nickname);
    }
}
