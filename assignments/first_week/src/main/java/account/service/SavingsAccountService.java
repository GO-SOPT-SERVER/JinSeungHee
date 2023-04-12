package account.service;

import static account.domain.Account.MAXIMUM_WITHDRAWAL_COUNT;
import static account.util.NumberGenerator.generateAccountNumber;

import account.domain.Account;
import account.domain.AccountType;
import account.domain.TransactionType;
import account.service.dto.AccountRegisterDto;
import account.util.LogGenerator;
import java.time.LocalDate;

public class SavingsAccountService implements AccountService {

    @Override
    public Account register(AccountRegisterDto registerDto) {
        String accountNumber = generateAccountNumber();
        return new Account(registerDto.getOwner(), AccountType.SAVINGS, accountNumber, registerDto.getExpirationDate());
    }

    @Override
    public void deposit(Account account, long depositRequest) {
        account.deposit(depositRequest);
    }

    @Override
    public void withdrawal(Account account, long withdrawalRequest) {
        if (account.getWithdrawalCount() >= MAXIMUM_WITHDRAWAL_COUNT) {
            throw new IllegalArgumentException("긴급 출금을 더 이상 사용하실 수 없습니다. 만료일 이후에 출금이 가능합니다.");
        }
        if (LocalDate.now().isAfter(account.getExpirationDate())) {
            throw new IllegalArgumentException("만료일이 아니므로 출급하실 수 없습니다.");

        }
        if (!account.isBalanceSufficient(withdrawalRequest)) {
            throw new IllegalArgumentException("금액이 충분하지 않습니다.");
        }
        account.withdrawal(withdrawalRequest);
    }

    @Override
    public void addLogs(Account account, TransactionType transactionType, long amount) {
        String log = LogGenerator.generateLog(amount, AccountType.CHEQUING, transactionType, account.getBalance());
        account.addLog(log);
    }
}
