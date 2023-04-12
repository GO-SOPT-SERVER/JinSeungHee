package sopt.org.SecondSeminar.domain.post;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Post {
    private Long id;
    private String title;
    private String content;
    private LocalDateTime createdAt;

    public Post(
            String title,
            String content
    ) {
        this.title = title;
        this.content = content;
        this.createdAt = LocalDateTime.now();
    }
}
