package user.service;

import user.domain.User;
import user.service.dto.UserRegisterDto;

public class UserService {

    public void register(
            UserRegisterDto request

    ) {
        new User(request.getName(), request.getAge());
    }
}
