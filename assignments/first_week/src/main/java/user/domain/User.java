package user.domain;

import static account.domain.Account.ACCOUNT_AVAILABLE_AGE;

import account.domain.Account;
import java.util.ArrayList;
import java.util.List;

public class User {
    private String name;
    private int age;
    private List<Account> accounts = new ArrayList<>();

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // getter 를 지양하고 메시지를 던져라
    public boolean isAccountAvailableAge() {
        return age >= ACCOUNT_AVAILABLE_AGE;
    }
}
