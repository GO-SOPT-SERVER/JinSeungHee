package account.service.dto;

import java.time.LocalDate;
import user.domain.User;

public class AccountRegisterDto {
    private User owner;
    private String purpose;
    private LocalDate expirationDate;

    public User getOwner() {
        return owner;
    }

    public String getPurpose() {
        return purpose;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public AccountRegisterDto(User owner, String purpose) {
        this.owner = owner;
        this.purpose = purpose;
    }

    public AccountRegisterDto(User owner, String purpose, LocalDate expirationDate) {
        this.owner = owner;
        this.purpose = purpose;
        this.expirationDate = expirationDate;
    }
}
