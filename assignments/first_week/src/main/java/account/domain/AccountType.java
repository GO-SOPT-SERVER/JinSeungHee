package account.domain;

import java.util.Arrays;
import java.util.Objects;
import java.util.function.Predicate;

public enum AccountType {
    SAVINGS(1, "저축"),
    CHEQUING(2, "입출금");

    private int typeNumber;
    private String typeName;

    AccountType(int typeNumber, String typeName) {
        this.typeNumber = typeNumber;
        this.typeName = typeName;
    }


    public String getTypeName() {
        return typeName;
    }

    private static AccountType find(final Predicate<AccountType> predicate) {
        return Arrays.stream(values()).filter(predicate).findAny().orElseThrow(IllegalArgumentException::new);
    }

    public static AccountType findAccountTypeWithTypeNumber(final int typeNumber) {
        return find(e -> Objects.equals(e.typeNumber, typeNumber));
    }
}
