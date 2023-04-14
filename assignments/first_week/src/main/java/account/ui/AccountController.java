package account.ui;

import account.domain.Account;
import account.domain.AccountRepository;
import account.domain.AccountType;
import account.service.ChequingAccountService;
import account.service.SavingsAccountService;
import account.service.dto.AccountRegisterDto;

public class AccountController {
    private final SavingsAccountService savingsAccountService = new SavingsAccountService();
    private final ChequingAccountService chequingAccountService = new ChequingAccountService();
    private final AccountRepository accountRepository = new AccountRepository();

    public void register(final AccountRegisterDto registerDto) {
        if (registerDto.getAccountType().equals(AccountType.CHEQUING)) {
            chequingAccountService.register(registerDto);
            return;
        }
        if (registerDto.getAccountType().equals(AccountType.SAVINGS)) {
            savingsAccountService.register(registerDto);
            return;
        }
        throw new IllegalArgumentException("잘못된 입력값입니다.");
    }

    public void deposit(final long depositAmount) {
        Account account = accountRepository.findAccount();
        if (account.getAccountType() == AccountType.SAVINGS) {
            savingsAccountService.deposit(account, depositAmount);
            return;
        }
        chequingAccountService.deposit(account, depositAmount);
    }

    public void withdrawal(final long withdrawalRequestAmount) {
        Account account = accountRepository.findAccount();
        if (account.getAccountType() == AccountType.SAVINGS) {
            savingsAccountService.withdrawal(account, withdrawalRequestAmount);
            return;
        }
        chequingAccountService.withdrawal(account, withdrawalRequestAmount);
    }
}
