package user.domain;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    public static final List<User> users = new ArrayList<>();

    public void save(final User user) {
        users.add(user);
    }
}
