package sopt.org.FourthSeminar.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sopt.org.FourthSeminar.controller.dto.BoardRequestDto;
import sopt.org.FourthSeminar.domain.Board;
import sopt.org.FourthSeminar.domain.Image;
import sopt.org.FourthSeminar.domain.User;
import sopt.org.FourthSeminar.exception.Error;
import sopt.org.FourthSeminar.exception.model.NotFoundException;
import sopt.org.FourthSeminar.infrastructrue.BoardRepository;
import sopt.org.FourthSeminar.infrastructrue.ImageRepository;
import sopt.org.FourthSeminar.infrastructrue.UserRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final UserRepository userRepository;
    private final BoardRepository boardRepository;
    private final ImageRepository imageRepository;

    @Transactional
    public void create(Long userId, List<String> boardThumbnailImageUrls, BoardRequestDto request) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException(Error.NOT_FOUND_USER_EXCEPTION,
                        Error.NOT_FOUND_USER_EXCEPTION.getMessage()));

        Board newBoard = Board.newInstance(
                user,
                request.getTitle(),
                request.getContent(),
                request.getIsPublic()
        );
        boardRepository.save(newBoard);

        for (String boardThumbnailImageUrl : boardThumbnailImageUrls) {
            imageRepository.save(Image.newInstance(newBoard, boardThumbnailImageUrl));
        }
    }
}