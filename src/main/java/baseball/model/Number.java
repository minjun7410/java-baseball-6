package baseball.model;

import baseball.constant.Constants;

public class Number {
    private final int number;

    public Number(int number) {
        validateIsNumber(number);
        this.number = number;
    }

    public void validateIsNumber(int input) {
        if (input <= Constants.MINIMUM_NUMBER.getNumber() - 1 || input > Constants.MAXIMUM_NUMBER.getNumber()) {
            throw new IllegalArgumentException(String.format("%d에서 %d사이 숫자를 입력해주세요.", Constants.MINIMUM_NUMBER.getNumber(), Constants.MAXIMUM_NUMBER.getNumber()));
        }
    }

    @Override
    public boolean equals(Object obj) {
        Number n = (Number) obj;
        return n.number == this.number;
    }
}
