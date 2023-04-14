import account.domain.AccountType;
import account.service.dto.AccountRegisterDto;
import common.vo.CommandSign;
import java.util.Scanner;
import user.service.dto.UserRegisterDto;

public class BankView {
    private final Scanner sc = new Scanner(System.in);

    public void printIntroMessage() {
        System.out.println("==== 은행에 오신 것을 환영합니다. ====");
    }

    public void printCommandMessage(final CommandSign commandSign) {
        System.out.println(commandSign.getMessage());
    }

    public void printSaveOkMessage() {
        System.out.println("정상적으로 저장되었습니다.");
    }

    public int getCommandSignNumber() {
        System.out.println("원하는 옵션을 선택해주세요 \n 1: 회원가입 2: 계좌 생성 3: 계좌 입금 4: 계좌 출금 \n 종료하시려면 0을 입력해주세요.");
        return sc.nextInt();
    }

    public UserRegisterDto getUserRegisterInfo() {
        System.out.print("성함을 입력해주세요 >> ");
        String name = sc.next();
        System.out.print("나이를 입력해주세요 >> ");
        int age = sc.nextInt();
        return new UserRegisterDto(name, age);
    }

    public AccountRegisterDto getAccountRegisterInfo() {
        System.out.print("원하는 계좌의 형태를 입력해주세요 \n 1: 저축 계좌 2: 입출금 계좌");
        int accountTypeNumber = sc.nextInt();
        AccountType accountType = AccountType.findAccountTypeWithTypeNumber(accountTypeNumber);
        if (accountType == AccountType.SAVINGS) {
            System.out.print("몇달 뒤에 적금을 만료하시겠어요? >> ");
            int durationMonth = sc.nextInt();
            return new AccountRegisterDto(AccountType.SAVINGS, durationMonth);
        }
        return new AccountRegisterDto(AccountType.CHEQUING);
    }

    public long getDepositRequestAmount() {
        System.out.println("원하는 입금 금액을 입력해주세요 >> ");
        return sc.nextLong();
    }

    public long getWithdrawalRequestAmount() {
        System.out.println("원하는 출금 금액을 입력해주세요 >> ");
        return sc.nextLong();
    }
}
