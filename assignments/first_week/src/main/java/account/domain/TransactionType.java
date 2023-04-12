package account.domain;

public enum TransactionType {
    DEPOSIT("예금"),
    WITHDRAWAL("출금");

    private String typeString;

    TransactionType(String typeString) {
        this.typeString = typeString;
    }

    public String getTypeString() {
        return typeString;
    }
}
