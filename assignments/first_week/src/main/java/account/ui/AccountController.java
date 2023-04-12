package account.ui;

import account.service.ChequingAccountService;
import account.service.SavingsAccountService;

public class AccountController {
    private final SavingsAccountService savingsAccountService;
    private final ChequingAccountService chequingAccountService;

    public AccountController() {
        this.savingsAccountService = new SavingsAccountService();
        this.chequingAccountService = new ChequingAccountService();
    }

    public void register() {

    }
}
