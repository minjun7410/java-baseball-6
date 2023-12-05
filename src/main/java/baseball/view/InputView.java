package baseball.view;

import baseball.model.NumberInput;
import baseball.model.Numbers;
import baseball.model.RestartInput;
import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String END_TEXT = "숫자 야구 게임을 종료합니다.";
    private static final String NUMBER_INPUT_TEXT = "숫자를 입력해주세요 : ";
    private static final String RESTART_INPUT_TEXT = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public Numbers getUserNumbers() {
        System.out.print(NUMBER_INPUT_TEXT);
        NumberInput numberInput = new NumberInput(Console.readLine().trim());
        return numberInput.getNumbers();
    }

    public boolean getRestartInput() {
        System.out.println(RESTART_INPUT_TEXT);
        return getOneOrTwo(Console.readLine());
    }

    private boolean getOneOrTwo(String userInput) {
        String trimUserInput = userInput.trim();
        RestartInput restartInput = new RestartInput(trimUserInput);
        if (restartInput.isOne()) {
            return true;
        }
        System.out.println(END_TEXT);
        return false;
    }

    public void close() {
        Console.close();
    }
}
