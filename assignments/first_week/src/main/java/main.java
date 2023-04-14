import static common.vo.CommandSign.QUIT_SIGN;

import common.vo.CommandSign;

public class main {
    public static void main(String[] args) {

        BankView view = new BankView();
        BankController bankController = new BankController();

        view.printIntroMessage();
        while (true) {
            int commandSignNumber = view.getCommandSignNumber();
            CommandSign commandSign = CommandSign.findCommandSignWithSignNumber(commandSignNumber);
            if (commandSign == QUIT_SIGN) {
                view.printCommandMessage(QUIT_SIGN);
                break;
            }
            bankController.run(commandSign);
        }
    }
}
