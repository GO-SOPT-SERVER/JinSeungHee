package sopt.org.FourthSeminar.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import sopt.org.FourthSeminar.common.ApiResponse;
import sopt.org.FourthSeminar.config.resolver.UserId;
import sopt.org.FourthSeminar.controller.dto.BoardRequestDto;
import sopt.org.FourthSeminar.exception.Success;
import sopt.org.FourthSeminar.external.client.aws.S3Service;
import sopt.org.FourthSeminar.service.BoardService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {

    private final S3Service s3Service;
    private final BoardService boardService;

    @PostMapping(value = "/create", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @SecurityRequirement(name = "JWT Auth")
    @ResponseStatus(HttpStatus.CREATED)
    public ApiResponse create(
            @UserId Long userId,
            @ModelAttribute @Valid final BoardRequestDto request) {
        List<String> boardThumbnailImageUrl = s3Service.uploadImages(request.getThumbnail(), "board");
        boardService.create(userId, boardThumbnailImageUrl, request);
        return ApiResponse.success(Success.CREATE_BOARD_SUCCESS);
    }
}