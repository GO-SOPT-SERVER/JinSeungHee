package assignment.ThirdWeek.post.service.dto;

import assignment.ThirdWeek.post.domain.Post;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PostResponseDto {
    private String title;
    private String content;
    private LocalDateTime createdAt;

    public static PostResponseDto of(Post post) {
        return new PostResponseDto(post.getTitle(), post.getContent(), post.getCreatedAt());
    }
}
