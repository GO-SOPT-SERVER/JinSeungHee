package assignment.ThirdWeek.post.ui;

import assignment.ThirdWeek.post.service.PostService;
import assignment.ThirdWeek.post.service.dto.PostRegisterDto;
import assignment.ThirdWeek.post.service.dto.PostResponseDto;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/post")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody @Valid PostRegisterDto postRegisterDto) {
        postService.register(postRegisterDto);
        return ResponseEntity.ok("등록이 완료되었습니다.");
    }

    @GetMapping("/{postId}")
    public ResponseEntity<PostResponseDto> get(@PathVariable final Long postId) {
        PostResponseDto responseDto = postService.get(postId);
        return ResponseEntity.ok(responseDto);
    }
}
