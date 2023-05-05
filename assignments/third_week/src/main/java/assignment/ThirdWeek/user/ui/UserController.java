package assignment.ThirdWeek.user.ui;

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
    public ResponseEntity<String> register(
            @RequestBody @Valid UserRegisterDto userRegisterDto) {
        userService.register(userRegisterDto);
        return ResponseEntity.ok("등록이 완료되었습니다.");
    }
}
