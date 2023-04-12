package account.service;

import static account.util.NumberGenerator.generateAccountNumber;

import account.domain.Account;
import account.domain.AccountType;
import account.domain.TransactionType;
import account.service.dto.AccountRegisterDto;
import account.util.LogGenerator;

public class ChequingAccountService implements AccountService {

    @Override
    public Account register(AccountRegisterDto registerDto) {
        String accountNumber = generateAccountNumber();
        return new Account(registerDto.getOwner(), AccountType.CHEQUING, accountNumber);
    }

    @Override
    public void deposit(Account account, long depositRequest) {
        account.deposit(depositRequest);
    }

    @Override
    public void withdrawal(Account account, long withdrawalRequest) {
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
