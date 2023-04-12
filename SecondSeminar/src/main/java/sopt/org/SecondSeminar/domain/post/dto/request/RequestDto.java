package sopt.org.SecondSeminar.domain.post.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class RequestDto {
    private String title;
    private String content;
}