package user.domain;

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
}