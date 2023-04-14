package account.domain;

import java.util.ArrayList;
import java.util.List;

public class AccountRepository {

    public static List<Account> accounts = new ArrayList<>();

    public void save(final Account account) {
        accounts.add(account);
    }

    public Account findAccount() {
        return accounts.get(accounts.size() - 1);
    }
}
