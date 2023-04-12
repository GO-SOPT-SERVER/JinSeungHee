package user.controller;

import user.service.UserService;
import user.service.dto.UserRegisterDto;

public class UserController {
    private UserService userService;

    public UserController() {
        this.userService = new UserService();
    }

    public void register(UserRegisterDto userRegisterDto) {
        UserRegisterDto userRegisterDto = new UserRegisterDto();
        userService.register();
    }
}
