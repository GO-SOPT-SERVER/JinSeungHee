package user.service;

import user.domain.User;
import user.domain.UserRepository;
import user.service.dto.UserRegisterDto;

public class UserService {

    private final UserRepository userRepository = new UserRepository();

    public void register(final UserRegisterDto request) {
        User user = new User(request.getName(), request.getAge());
        userRepository.save(user);
    }
}
