package baseball.constant;

public enum Constants {

    MAXIMUM_NUMBER(9),
    MINIMUM_NUMBER(1),
    MAXIMUM_BALL_COUNT(3),;

    private final int number;

    Constants(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
