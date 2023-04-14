package account.service;

import static account.util.NumberGenerator.generateAccountNumber;

import account.domain.Account;
import account.domain.AccountRepository;
import account.domain.AccountType;
import account.domain.TransactionType;
import account.service.dto.AccountRegisterDto;
import account.util.LogGenerator;

public class ChequingAccountService implements AccountService {

    private final AccountRepository accountRepository = new AccountRepository();

    @Override
    public void register(final AccountRegisterDto registerDto) {
        String accountNumber = generateAccountNumber();
        Account account = new Account(AccountType.CHEQUING, accountNumber);
        accountRepository.save(account);
    }

    @Override
    public void deposit(final Account account, final long depositRequest) {
        account.deposit(depositRequest);
        addLogs(account, TransactionType.DEPOSIT, depositRequest);
    }

    @Override
    public void withdrawal(final Account account, final long withdrawalRequest) {
        if (!account.isBalanceSufficient(withdrawalRequest)) {
            throw new IllegalArgumentException("금액이 충분하지 않습니다.");
        }
        account.withdrawal(withdrawalRequest);
        addLogs(account, TransactionType.WITHDRAWAL, withdrawalRequest);
    }

    @Override
    public void addLogs(final Account account, final TransactionType transactionType, final long amount) {
        String log = LogGenerator.generateLog(amount, AccountType.CHEQUING, transactionType, account.getBalance());
        account.addLog(log);
        System.out.println(log);
    }
}
