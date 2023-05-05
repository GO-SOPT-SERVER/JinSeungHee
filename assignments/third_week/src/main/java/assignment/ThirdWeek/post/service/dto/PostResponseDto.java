package assignment.ThirdWeek.post.service.dto;

import assignment.ThirdWeek.post.domain.Post;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostResponseDto {
    private String title;
    private String content;
    private LocalDateTime createdAt;

    public PostResponseDto(
            Post post
    ) {
        this.title = post.getTitle();
        this.content = post.getContent();
        this.createdAt = post.getCreatedAt();
    }
}
