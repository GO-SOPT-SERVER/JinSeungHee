package account.service;

import account.domain.Account;
import account.domain.TransactionType;
import account.service.dto.AccountRegisterDto;

public interface AccountService {
    Account register(AccountRegisterDto registerDto);

    void deposit(Account account, long depositRequest);

    void withdrawal(Account account, long withdrawalRequest);

    void addLogs(Account account, TransactionType transactionType, long amount);
}
