package sopt.org.secondAssignment.article.service.dto;

import java.time.LocalDateTime;
import lombok.Getter;
import sopt.org.secondAssignment.article.domain.Article;

@Getter
public class ArticleRequestDto {
    private String title;
    private String content;

    public Article toEntity() {
        return Article.builder()
                .title(title)
                .content(content)
                .createdAt(LocalDateTime.now())
                .build();
    }
}
