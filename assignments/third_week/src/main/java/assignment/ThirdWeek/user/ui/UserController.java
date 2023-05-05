package assignment.ThirdWeek.user.ui;

import static assignment.ThirdWeek.common.ResponseMessage.SUCCESS_SAVE_MESSAGE;

import assignment.ThirdWeek.common.dto.ApiResponse;
import assignment.ThirdWeek.user.service.UserService;
import assignment.ThirdWeek.user.service.dto.UserRegisterDto;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<ApiResponse> register(
            @RequestBody @Valid UserRegisterDto userRegisterDto) {
        userService.register(userRegisterDto);
        return ResponseEntity.ok(ApiResponse.success(SUCCESS_SAVE_MESSAGE.getMessage()));
    }
}
