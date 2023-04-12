package account.domain;

public enum AccountType {
    SAVINGS("저축"),
    CHEQUING("입출금");

    private String typeName;

    AccountType(String typeName) {
        this.typeName = typeName;
    }

    public String getTypeName() {
        return typeName;
    }
}
