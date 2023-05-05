package assignment.ThirdWeek.user.service;

import static assignment.ThirdWeek.common.ExceptionMessage.USER_NOT_FOUND;

import assignment.ThirdWeek.exception.NotFoundException;
import assignment.ThirdWeek.user.domain.User;
import assignment.ThirdWeek.user.domain.UserRepository;
import assignment.ThirdWeek.user.service.dto.UserRegisterDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    @Transactional
    public void register(UserRegisterDto userRegisterDto) {
        userRepository.save(userRegisterDto.toEntity());
    }

    @Transactional(readOnly = true)
    public User findUser(Long userId) {
        return userRepository.findById(userId).orElseThrow(() -> new NotFoundException(USER_NOT_FOUND.getMessage()));
    }
}
