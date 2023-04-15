package sopt.org.secondAssignment.article.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sopt.org.secondAssignment.article.domain.Article;
import sopt.org.secondAssignment.article.domain.ArticleRepository;
import sopt.org.secondAssignment.article.service.dto.ArticleRequestDto;
import sopt.org.secondAssignment.article.service.dto.ArticleResponseDto;

@Service
@RequiredArgsConstructor
@Transactional
public class ArticleServiceImpl implements ArticleService {
    private final ArticleRepository articleRepository;

    @Override
    public void register(final ArticleRequestDto requestDto) {
        articleRepository.save(requestDto.toEntity());
    }

    @Override
    @Transactional(readOnly = true)
    public ArticleResponseDto getArticle(final Long articleId) {
        Article article = articleRepository.findById(articleId).orElseThrow(IllegalArgumentException::new);
        return new ArticleResponseDto(article);
    }

    @Override
    public void updateArticle(final Long articleId, ArticleRequestDto requestDto) {
        Article article = articleRepository.findById(articleId).orElseThrow(IllegalArgumentException::new);
        article.update(requestDto.toEntity());
    }

    @Override
    public void deleteArticle(final Long articleId) {
        Article article = articleRepository.findById(articleId).orElseThrow(IllegalArgumentException::new);
        articleRepository.delete(article);
    }
}
