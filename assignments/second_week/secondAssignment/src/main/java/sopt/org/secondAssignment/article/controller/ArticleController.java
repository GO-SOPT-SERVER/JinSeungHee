package sopt.org.secondAssignment.article.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sopt.org.secondAssignment.article.service.ArticleService;
import sopt.org.secondAssignment.article.service.dto.ArticleRequestDto;
import sopt.org.secondAssignment.article.service.dto.ArticleResponseDto;

@RestController
@RequiredArgsConstructor
@RequestMapping("/article")
public class ArticleController {
    private final ArticleService articleService;

    @PostMapping
    public ResponseEntity<String> register(
            @RequestBody ArticleRequestDto requestDto
    ) {
        articleService.register(requestDto);
        return ResponseEntity.ok("정상적으로 저장되었습니다.");
    }

    @GetMapping("/{articleId}")
    public ResponseEntity<ArticleResponseDto> getArticle(
            @PathVariable final Long articleId
    ) {
        return ResponseEntity.ok(articleService.getArticle(articleId));
    }

    @PutMapping("/{articleId}")
    public ResponseEntity<String> updateArticle(@PathVariable final Long articleId,
                                                @RequestBody ArticleRequestDto requestDto) {
        articleService.updateArticle(articleId, requestDto);
        return ResponseEntity.ok("정상적으로 수정되었습니다.");
    }

    @DeleteMapping("/{articleId}")
    public ResponseEntity<String> deleteArticle(@PathVariable final Long articleId) {
        articleService.deleteArticle(articleId);
        return ResponseEntity.ok("정상적으로 삭제되었습니다.");
    }
}
