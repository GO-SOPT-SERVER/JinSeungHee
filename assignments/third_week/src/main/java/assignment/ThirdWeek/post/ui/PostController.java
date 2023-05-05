package assignment.ThirdWeek.post.ui;

import static assignment.ThirdWeek.common.ResponseMessage.SUCCESS_GET_MESSAGE;
import static assignment.ThirdWeek.common.ResponseMessage.SUCCESS_SAVE_MESSAGE;

import assignment.ThirdWeek.common.dto.ApiResponse;
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
    public ResponseEntity<ApiResponse> register(@RequestBody @Valid PostRegisterDto postRegisterDto) {
        postService.register(postRegisterDto);
        return ResponseEntity.ok(ApiResponse.success(SUCCESS_SAVE_MESSAGE.getMessage()));
    }

    @GetMapping("/{postId}")
    public ResponseEntity<ApiResponse> get(@PathVariable final Long postId) {
        PostResponseDto responseDto = postService.get(postId);
        return ResponseEntity.ok(ApiResponse.success(SUCCESS_GET_MESSAGE.getMessage(), responseDto));
    }
}
