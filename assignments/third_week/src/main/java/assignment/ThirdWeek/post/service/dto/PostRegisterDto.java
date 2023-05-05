package assignment.ThirdWeek.post.service.dto;

import assignment.ThirdWeek.post.domain.Post;
import assignment.ThirdWeek.user.domain.User;
import javax.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class PostRegisterDto {
    @NotNull
    private Long userId;
    @NotNull
    private String title;
    @NotNull
    private String content;

    public Post toEntity(User user) {
        return Post.builder()
                .user(user)
                .title(title)
                .content(content)
                .build();
    }
}
