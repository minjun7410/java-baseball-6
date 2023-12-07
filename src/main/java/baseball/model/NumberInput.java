package baseball.model;

import baseball.constant.Constants;

public class NumberInput {
    private final String numberInput;

    public NumberInput(String numberInput) {
        validateUserInputSize(numberInput);
        this.numberInput = numberInput;
    }

    public void validateUserInputSize(String input) {
        if (input.length() != Constants.MAXIMUM_BALL_COUNT.getNumber()) {
            throw new IllegalArgumentException(String.format("%d자리 숫자를 입력해주세요.", Constants.MAXIMUM_BALL_COUNT.getNumber()));
        }
    }

    public Numbers getNumbers() {
        Numbers numbers = new Numbers();
        for (int i = 0; i < Constants.MAXIMUM_BALL_COUNT.getNumber(); i++) {
            numbers.addNumber(new Number(numberInput.charAt(i) - '0'));
        }
        return numbers;
    }
}
