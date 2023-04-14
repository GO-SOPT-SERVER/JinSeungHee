package account.util;

import account.domain.AccountType;
import account.domain.TransactionType;
import java.time.LocalDateTime;

public class LogGenerator {
    public static String generateLog(final Long amount, final AccountType accountType, final TransactionType transactionType,
                                     final long balance) {
        return LocalDateTime.now() + ":" + accountType.getTypeName() + "통장 >> " + transactionType.getTypeString()
                + " ) " + amount + "원 / 잔액 : " + balance;
    }
}