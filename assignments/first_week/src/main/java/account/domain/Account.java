package account.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

// 역할 : 계좌에 대하여 정의한다.
public class Account {
    public static final int ACCOUNT_NUMBER_LENGTH = 13;
    public static final int ACCOUNT_NUMBER_MIN = 0;
    public static final int ACCOUNT_NUMBER_MAX = 9;
    public static final int MAXIMUM_WITHDRAWAL_COUNT = 3;

    private AccountType accountType;
    private String accountNumber;
    private LocalDateTime createdAt;
    private long balance; // 잔액
    private int withdrawalCount;
    private LocalDate expirationDate;
    private List<String> logs = new ArrayList<>();

    public void deposit(final long depositAmount) {
        this.balance += depositAmount;
    }

    public void withdrawal(final long withdrawalAmount) {
        this.balance -= withdrawalAmount;
    }

    public boolean isBalanceSufficient(final long withdrawalAmount) {
        return this.balance >= withdrawalAmount;
    }

    public void addLog(String log) {
        this.logs.add(log);
    }

    public Account() {
        this.createdAt = LocalDateTime.now();
        this.withdrawalCount = 0;
        this.balance = 0;
    }

    public Account(final AccountType accountType, final String accountNumber, final int durationMonth) {
        this();
        this.accountType = accountType;
        this.accountNumber = accountNumber;
        this.expirationDate = LocalDate.now().plusMonths(durationMonth);
    }

    public Account(final AccountType accountType, final String accountNumber) {
        this();
        this.accountType = accountType;
        this.accountNumber = accountNumber;
        this.expirationDate = null;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public long getBalance() {
        return balance;
    }

    public int getWithdrawalCount() {
        return withdrawalCount;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }
}
