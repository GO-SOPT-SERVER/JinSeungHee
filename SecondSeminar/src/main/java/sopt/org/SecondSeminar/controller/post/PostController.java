package sopt.org.SecondSeminar.controller.post;

import static sopt.org.SecondSeminar.SecondSeminarApplication.postList;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sopt.org.SecondSeminar.domain.post.dto.request.RequestDto;
import sopt.org.SecondSeminar.service.post.PostService;

@RestController
@RequiredArgsConstructor
public class PostController {
    // post, 단일 객체, 제목으로 검색
    private final PostService postService;

    @PostMapping("/post")
    public String register(@RequestBody final RequestDto request) {
        Long postId = postService.register(request);
        System.out.println(postList.get(postId.intValue() - 1).toString());

        return postId + "번 게시글이 등록되었습니다!";
    }

    @GetMapping("/post/{postId}")
    public String getOne(@PathVariable final Long postId) {
        System.out.println("요청 게시글 아이디: " + postId);
        return postService.getOne(postId).toString();
    }

    @GetMapping("/post/search")
    public String search(@RequestParam final String title) {
        System.out.println("게시글 제목 검색 인자: " + title);
        return postService.search(title).toString();
    }

}
