package sopt.org.secondAssignment.article.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sopt.org.secondAssignment.article.domain.ArticleRepository;
import sopt.org.secondAssignment.article.service.dto.ArticleRequestDto;

@Service
@RequiredArgsConstructor
public class ArticleServiceImpl implements ArticleService {
    private final ArticleRepository articleRepository;

    @Override
    public void register(final ArticleRequestDto requestDto) {
        articleRepository.save(requestDto.toEntity());
    }
}
