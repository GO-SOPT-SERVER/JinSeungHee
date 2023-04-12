package account.util;

import static account.domain.Account.ACCOUNT_NUMBER_LENGTH;
import static account.domain.Account.ACCOUNT_NUMBER_MAX;
import static account.domain.Account.ACCOUNT_NUMBER_MIN;

public class NumberGenerator {

    public NumberGenerator() {
    }

    public static String generateAccountNumber() {
        StringBuffer buf = new StringBuffer();
        for (int i = 0; i < ACCOUNT_NUMBER_LENGTH; i++) {
            buf.append((int) (Math.random() * ACCOUNT_NUMBER_MAX) + ACCOUNT_NUMBER_MIN);
        }
        return buf.toString();
    }
}
