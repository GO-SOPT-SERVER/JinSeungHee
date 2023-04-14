package account.service.dto;

import account.domain.AccountType;

public class AccountRegisterDto {
    private AccountType accountType;
    private int durationMonth;

    public AccountType getAccountType() {
        return accountType;
    }

    public int getDurationMonth() {
        return durationMonth;
    }

    public AccountRegisterDto(final AccountType accountType, final int durationMonth) {
        this.accountType = accountType;
        this.durationMonth = durationMonth;
    }

    public AccountRegisterDto(final AccountType accountType) {
        this.accountType = accountType;
    }
}
