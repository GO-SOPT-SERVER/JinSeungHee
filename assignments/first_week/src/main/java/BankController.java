import static common.vo.CommandSign.ACCOUNT_REGISTER_SIGN;
import static common.vo.CommandSign.ACCOUNT_VIEW_SIGN;
import static common.vo.CommandSign.MEMBER_REGISTER_SIGN;

import account.ui.AccountController;
import java.util.Scanner;
import user.controller.UserController;
import user.service.dto.UserRegisterDto;

public class BankController {
    private AccountController accountController;
    private UserController userController;
    private Scanner sc;

    public BankController() {
        this.accountController = new AccountController();
        this.userController = new UserController();
        sc = new Scanner(System.in);
    }

    // TODO : VIEW 와 분리하기
    public void run() {
        System.out.println("==== 은행에 오신 것을 환영합니다. 원하시는 옵션을 선택해주세요. ====\n 1: 회원가입 2: 계좌 생성 3: 계좌 거래 내역 조회");

        int commandSignNumber = sc.nextInt();

        if (commandSignNumber == MEMBER_REGISTER_SIGN.getSignNumber()) {
            UserRegisterDto userRegisterDto = getUseRegisterInfo();
            userController.register(userRegisterDto);
            System.out.println(MEMBER_REGISTER_SIGN.getMessage());
        }
        if (commandSignNumber == ACCOUNT_REGISTER_SIGN.getSignNumber()) {
            accountController.register();
            System.out.println(ACCOUNT_REGISTER_SIGN.getMessage());
        }
        if (commandSignNumber == ACCOUNT_VIEW_SIGN.getSignNumber()) {
            accountController.viewLogs();
            System.out.println(ACCOUNT_VIEW_SIGN.getMessage());
        } else {
            throw new IllegalArgumentException("잘못된 입력값을 입력하셨습니다.");
        }
    }

    private UserRegisterDto getUseRegisterInfo() {
        System.out.println("이름 : ");
        String name = sc.next();
        System.out.println("나이 : ");
        int age = sc.nextInt();
        return new UserRegisterDto(name, age);
    }

    
}
