package assignment.ThirdWeek.user.service.dto;

import assignment.ThirdWeek.user.domain.User;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class UserRegisterDto {
    @NotNull
    @Email
    private final String email;
    @Pattern(
            regexp = "(?=.*[0-9])(?=.*[a-zA-Z])(?=.*\\W)(?=\\S+$).{8,20}",
            message = "비밀번호는 영문 대,소문자와 숫자, 특수기호가 적어도 1개 이상씩 포함된 8자 ~ 20자의 비밀번호여야 합니다."
    )
    @NotNull
    private final String password;

    public User toEntity() {
        return User.builder().email(email).password(password).build();
    }
}
