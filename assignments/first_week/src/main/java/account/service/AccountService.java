package account.service;

import account.domain.Account;
import account.domain.TransactionType;
import account.service.dto.AccountRegisterDto;

public interface AccountService {
    void register(final AccountRegisterDto registerDto);

    void deposit(final Account account, final long depositRequest);

    void withdrawal(final Account account, final long withdrawalRequest);

    void addLogs(final Account account, final TransactionType transactionType, final long amount);
}
