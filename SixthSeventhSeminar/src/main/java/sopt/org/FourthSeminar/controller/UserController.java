package sopt.org.FourthSeminar.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import sopt.org.FourthSeminar.common.ApiResponse;
import sopt.org.FourthSeminar.config.jwt.JwtService;
import sopt.org.FourthSeminar.controller.dto.UserLoginRequestDto;
import sopt.org.FourthSeminar.controller.dto.UserLoginResponseDto;
import sopt.org.FourthSeminar.controller.dto.UserRequestDto;
import sopt.org.FourthSeminar.controller.dto.UserResponseDto;
import sopt.org.FourthSeminar.exception.Success;
import sopt.org.FourthSeminar.service.UserService;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
@Tag(name = "User", description = "유저 API Document")
public class UserController {

    private final UserService userService;
    private final JwtService jwtService;

    @PostMapping("/signup")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "유저 생성", description = "유저를 생성합니다.")
    public ApiResponse<UserResponseDto> create(@RequestBody @Valid final UserRequestDto request) {
        return ApiResponse.success(Success.SIGNUP_SUCCESS, userService.create(request));
    }

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "유저 로그인", description = "로그인합니다.")
    public ApiResponse<UserLoginResponseDto> login(@RequestBody @Valid final UserLoginRequestDto request) {
        final Long userId = userService.login(request);
        final String token = jwtService.issuedToken(String.valueOf(userId));
        return ApiResponse.success(Success.LOGIN_SUCCESS, UserLoginResponseDto.of(userId, token));
    }
}
