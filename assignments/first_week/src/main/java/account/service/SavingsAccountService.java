package account.service;

import static account.domain.Account.MAXIMUM_WITHDRAWAL_COUNT;
import static account.util.NumberGenerator.generateAccountNumber;

import account.domain.Account;
import account.domain.AccountRepository;
import account.domain.AccountType;
import account.domain.TransactionType;
import account.service.dto.AccountRegisterDto;
import account.util.LogGenerator;
import java.time.LocalDate;

public class SavingsAccountService implements AccountService {

    private final AccountRepository accountRepository = new AccountRepository();

    @Override
    public void register(final AccountRegisterDto registerDto) {
        String accountNumber = generateAccountNumber();
        Account account = new Account(AccountType.SAVINGS, accountNumber, registerDto.getDurationMonth());
        accountRepository.save(account);
    }

    @Override
    public void deposit(final Account account, final long depositRequest) {
        account.deposit(depositRequest);
        addLogs(account, TransactionType.DEPOSIT, depositRequest);
    }

    @Override
    public void withdrawal(final Account account, final long withdrawalRequest) {
        if (account.getWithdrawalCount() >= MAXIMUM_WITHDRAWAL_COUNT) {
            throw new IllegalArgumentException("긴급 출금을 더 이상 사용하실 수 없습니다. 만료일 이후에 출금이 가능합니다.");
        }
        if (LocalDate.now().isBefore(account.getExpirationDate())) {
            throw new IllegalArgumentException("만료일이 아니므로 출금하실 수 없습니다.");
        }
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
