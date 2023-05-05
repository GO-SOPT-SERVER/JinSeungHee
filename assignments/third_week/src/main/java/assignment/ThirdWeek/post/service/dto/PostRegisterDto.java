package assignment.ThirdWeek.post.service.dto;

import assignment.ThirdWeek.post.domain.Post;
import assignment.ThirdWeek.user.domain.User;
import lombok.Getter;

@Getter
public class PostRegisterDto {
    private Long userId;
    private String title;
    private String content;

    public Post toEntity(User user) {
        return Post.builder()
                .user(user)
                .title(title)
                .content(content)
                .build();
    }
}
