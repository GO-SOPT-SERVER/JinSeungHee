package sopt.org.secondAssignment.article.service.dto;

import java.time.LocalDateTime;
import lombok.Getter;
import sopt.org.secondAssignment.article.domain.Article;

@Getter
public class ArticleResponseDto {
    private String title;
    private String content;
    private LocalDateTime createdAt;

    public ArticleResponseDto(
            Article article
    ) {
        title = article.getTitle();
        content = article.getContent();
        createdAt = article.getCreatedAt();
    }
}
