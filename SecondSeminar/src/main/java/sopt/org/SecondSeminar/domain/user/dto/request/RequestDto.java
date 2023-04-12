package sopt.org.SecondSeminar.domain.user.dto.request;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class RequestDto {
    private String gender;

    private String name;

    private String contact;

    private int age;
}
