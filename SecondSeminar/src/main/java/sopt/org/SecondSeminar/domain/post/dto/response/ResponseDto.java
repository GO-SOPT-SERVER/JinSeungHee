package sopt.org.SecondSeminar.domain.post.dto.response;

import java.time.LocalDateTime;
import lombok.ToString;
import sopt.org.SecondSeminar.domain.post.Post;

@ToString
public class ResponseDto {
    private Long id;
    private String title;
    private String content;
    private LocalDateTime createdAt;

    public ResponseDto(
            Post post
    ) {
        id = post.getId();
        title = post.getTitle();
        content = post.getContent();
        createdAt = post.getCreatedAt();
    }
}
