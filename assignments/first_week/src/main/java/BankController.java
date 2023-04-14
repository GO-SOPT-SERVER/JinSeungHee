import static common.vo.CommandSign.ACCOUNT_DEPOSIT_SIGN;
import static common.vo.CommandSign.ACCOUNT_REGISTER_SIGN;
import static common.vo.CommandSign.ACCOUNT_WITHDRAWAL_SIGN;
import static common.vo.CommandSign.MEMBER_REGISTER_SIGN;

import account.service.dto.AccountRegisterDto;
import account.ui.AccountController;
import common.vo.CommandSign;
import user.controller.UserController;
import user.service.dto.UserRegisterDto;

public class BankController {
    private AccountController accountController = new AccountController();
    private UserController userController = new UserController();

    private BankView view = new BankView();

    public void run(final CommandSign commandSign) {
        if (commandSign == MEMBER_REGISTER_SIGN) {
            view.printCommandMessage(MEMBER_REGISTER_SIGN);

            UserRegisterDto userRegisterDto = view.getUserRegisterInfo();
            userController.register(userRegisterDto);

            view.printSaveOkMessage();
        } else if (commandSign == ACCOUNT_REGISTER_SIGN) {
            view.printCommandMessage(ACCOUNT_REGISTER_SIGN);

            AccountRegisterDto accountRegisterDto = view.getAccountRegisterInfo();
            accountController.register(accountRegisterDto);

            view.printSaveOkMessage();
        } else if (commandSign == ACCOUNT_DEPOSIT_SIGN) {
            view.printCommandMessage(ACCOUNT_DEPOSIT_SIGN);
            long depositRequestAmount = view.getDepositRequestAmount();
            accountController.deposit(depositRequestAmount);
        } else if (commandSign == ACCOUNT_WITHDRAWAL_SIGN) {
            view.printCommandMessage(ACCOUNT_WITHDRAWAL_SIGN);
            long withdrawalRequestAmount = view.getWithdrawalRequestAmount();
            accountController.withdrawal(withdrawalRequestAmount);
        } else {
            throw new IllegalArgumentException("잘못된 입력값을 입력하셨습니다.");
        }
    }
}