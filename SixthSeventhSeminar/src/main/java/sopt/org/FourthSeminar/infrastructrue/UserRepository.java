package sopt.org.FourthSeminar.infrastructrue;

import java.util.Optional;
import org.springframework.data.repository.Repository;
import sopt.org.FourthSeminar.domain.User;

public interface UserRepository extends Repository<User, Long> {
    // CREATE
    void save(User user);

    // READ
    Optional<User> findByEmail(String email);
    boolean existsByEmail(String email);
    Optional<User> findById(Long userId);
}
