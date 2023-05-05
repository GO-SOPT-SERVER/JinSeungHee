package assignment.ThirdWeek.post.service;

import static assignment.ThirdWeek.common.ExceptionMessage.DATA_NOT_FOUND;

import assignment.ThirdWeek.exception.NotFoundException;
import assignment.ThirdWeek.post.domain.Post;
import assignment.ThirdWeek.post.domain.PostRepository;
import assignment.ThirdWeek.post.service.dto.PostRegisterDto;
import assignment.ThirdWeek.post.service.dto.PostResponseDto;
import assignment.ThirdWeek.user.domain.User;
import assignment.ThirdWeek.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;
    private final UserService userService;

    @Transactional
    public void register(PostRegisterDto postRegisterDto) {
        User user = userService.findUser(postRegisterDto.getUserId());
        Post post = postRegisterDto.toEntity(user);
        postRepository.save(post);
    }

    @Transactional(readOnly = true)
    public PostResponseDto get(Long postId) {
        Post post = findPost(postId);
        return PostResponseDto.of(post);
    }

    public Post findPost(Long postId) {
        return postRepository.findById(postId).orElseThrow(() -> new NotFoundException(DATA_NOT_FOUND.getMessage()));
    }
}
