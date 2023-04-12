package sopt.org.SecondSeminar.service.post;

import static sopt.org.SecondSeminar.SecondSeminarApplication.postList;

import java.util.Objects;
import org.springframework.stereotype.Service;
import sopt.org.SecondSeminar.domain.post.Post;
import sopt.org.SecondSeminar.domain.post.dto.request.RequestDto;
import sopt.org.SecondSeminar.domain.post.dto.response.ResponseDto;

@Service
public class PostService {
    public Long register(RequestDto request) {
        Post newPost = new Post(
                request.getTitle(),
                request.getContent());

        // 데이터베이스에 저장
        postList.add(newPost);
        newPost.setId((long) postList.size());

        // 저장한 유저 아이디 값 반환
        return newPost.getId();
    }

    public ResponseDto getOne(Long postId) {
        try {
            Post post = postList.get((int) (postId - 1));
            return new ResponseDto(post);
        } catch (Exception e) {
            throw new IllegalArgumentException("해당 아이디의 게시글이 존재하지 않습니다.");
        }

    }

    public ResponseDto search(String title) {
        for (Post post : postList) {
            if (Objects.equals(post.getTitle(), title)) {
                return new ResponseDto(post);
            }
        }
        throw new IllegalArgumentException("해당 제목의 게시글이 존재하지 않습니다.");
    }
}