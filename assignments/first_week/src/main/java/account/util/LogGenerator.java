package account.util;

import account.domain.AccountType;
import account.domain.TransactionType;
import java.time.LocalDateTime;

public class LogGenerator {
    public static String generateLog(Long amount, AccountType accountType, TransactionType transactionType,
                                     long balance) {
        return LocalDateTime.now() + ":" + accountType.getTypeName() + "통장 >> " + transactionType.getTypeString()
                + " ) " + amount + "원 / 잔액 : " + balance;
    }
}
