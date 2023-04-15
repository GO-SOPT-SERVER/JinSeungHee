package sopt.org.secondAssignment.article.service;

import sopt.org.secondAssignment.article.service.dto.ArticleRequestDto;
import sopt.org.secondAssignment.article.service.dto.ArticleResponseDto;

public interface ArticleService {
    void register(ArticleRequestDto requestDto);

    ArticleResponseDto getArticle(Long articleId);

    void updateArticle(Long articleId, ArticleRequestDto requestDto);
}
