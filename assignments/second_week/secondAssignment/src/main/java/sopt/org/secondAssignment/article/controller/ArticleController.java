package sopt.org.secondAssignment.article.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sopt.org.secondAssignment.article.service.ArticleService;
import sopt.org.secondAssignment.article.service.dto.ArticleRequestDto;

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
}
