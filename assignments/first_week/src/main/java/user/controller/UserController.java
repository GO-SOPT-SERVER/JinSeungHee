package user.controller;

import user.service.UserService;
import user.service.dto.UserRegisterDto;

public class UserController {
    private UserService userService = new UserService();

    public void register(final UserRegisterDto userRegisterDto) {
        userService.register(userRegisterDto);
    }
}
