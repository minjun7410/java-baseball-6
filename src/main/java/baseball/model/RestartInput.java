package baseball.model;

public class RestartInput {
    private static final String RESTART_NUMBER = "1";
    private static final String TERMINATE_NUMBER = "2";
    private final String restartInput;

    RestartInput(String restartInput) {
        validateOneOrTwo(restartInput);
        this.restartInput = restartInput;
    }

    public boolean isOne() {
        return restartInput.equals(RESTART_NUMBER);
    }

    public boolean isTwo() {
        return restartInput.equals(TERMINATE_NUMBER);
    }

    private void validateOneOrTwo(String input) {
        if (!(input.equals(RESTART_NUMBER) || input.equals(TERMINATE_NUMBER))) {
            throw new IllegalArgumentException(String.format("%s 혹은 %s를 입력하세요.", RESTART_NUMBER, TERMINATE_NUMBER));
        }
    }
}
