package sopt.org.FourthSeminar.service;

import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sopt.org.FourthSeminar.controller.dto.UserLoginRequestDto;
import sopt.org.FourthSeminar.controller.dto.UserRequestDto;
import sopt.org.FourthSeminar.controller.dto.UserResponseDto;
import sopt.org.FourthSeminar.domain.User;
import sopt.org.FourthSeminar.exception.Error;
import sopt.org.FourthSeminar.exception.model.BadRequestException;
import sopt.org.FourthSeminar.exception.model.ConflictException;
import sopt.org.FourthSeminar.exception.model.NotFoundException;
import sopt.org.FourthSeminar.infrastructrue.UserRepository;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public UserResponseDto create(final UserRequestDto request) {
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new ConflictException(Error.ALREADY_EXIST_USER_EXCEPTION,
                    Error.ALREADY_EXIST_USER_EXCEPTION.getMessage());
        }

        User newUser = User.newInstance(
                request.getNickname(),
                request.getEmail(),
                request.getPassword()
        );

        userRepository.save(newUser);

        return UserResponseDto.of(newUser.getId(), newUser.getNickname());
    }

    @Transactional
    public Long login(UserLoginRequestDto request) {
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new NotFoundException(Error.NOT_FOUND_USER_EXCEPTION,
                        Error.NOT_FOUND_USER_EXCEPTION.getMessage()));

        if (!user.getPassword().equals(request.getPassword())) {
            throw new BadRequestException(Error.INVALID_PASSWORD_EXCEPTION,
                    Error.INVALID_PASSWORD_EXCEPTION.getMessage());
        }

        return user.getId();
    }

}
