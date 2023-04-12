package sopt.org.SecondSeminar.controller.user;

import static sopt.org.SecondSeminar.SecondSeminarApplication.userList;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sopt.org.SecondSeminar.domain.user.dto.request.RequestDto;
import sopt.org.SecondSeminar.service.user.UserService;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/user")
    public String register(@RequestBody final RequestDto request) {
        Long userId = userService.register(request);
        System.out.println(userList.get(userId.intValue() - 1).toString());

        return userId + "번 유저가 등록되었습니다!";
    }

    @GetMapping("/user/{userId}")
    public String getOne(@PathVariable final Long userId) {
        System.out.println("요청 유저 아이디: " + userId);
        return "유저 조회 성공";
    }

    @GetMapping("/user/search")
    public String search(@RequestParam final String name) {
        System.out.println("유저 이름 검색 인자: " + name);
        return "유저 검색 성공";
    }
}
