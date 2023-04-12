package account.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import user.domain.User;

// 역할 : 계좌에 대하여 정의한다.
public class Account {
    public static final int ACCOUNT_NUMBER_LENGTH = 13;
    public static final int ACCOUNT_NUMBER_MIN = 0;
    public static final int ACCOUNT_NUMBER_MAX = 9;
    public static final int ACCOUNT_AVAILABLE_AGE = 14;
    public static final int MAXIMUM_WITHDRAWAL_COUNT = 3;

    private User owner;
    private AccountType accountType;
    private String accountNumber;
    private LocalDateTime createdAt;
    private long balance; // 잔액
    private int withdrawalCount;
    private LocalDate expirationDate;
    private List<String> logs = new ArrayList<>();

    public void deposit(long depositAmount) {
        this.balance += depositAmount;
    }

    public void withdrawal(long withdrawalAmount) {
        this.balance -= withdrawalAmount;
    }

    public boolean isBalanceSufficient(long withdrawalAmount) {
        return this.balance >= withdrawalAmount;
    }

    public void addLog(String log) {
        this.logs.add(log);
    }

    public Account(User owner, AccountType accountType, String accountNumber, LocalDate expirationDate) {
        this.owner = owner;
        this.accountNumber = accountNumber;
        this.balance = 0;
        this.createdAt = LocalDateTime.now();
        this.withdrawalCount = 0;
        this.expirationDate = expirationDate;
    }

    public Account(User owner, AccountType accountType, String accountNumber) {
        this.owner = owner;
        this.accountNumber = accountNumber;
        this.balance = 0;
        this.createdAt = LocalDateTime.now();
        this.withdrawalCount = 0;
    }

    public User getOwner() {
        return owner;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
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

    public List<String> getLogs() {
        return logs;
    }
}
