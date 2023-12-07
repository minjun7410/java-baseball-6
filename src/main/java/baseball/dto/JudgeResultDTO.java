package baseball.dto;

public class JudgeResultDTO {
    private final int ballCount;
    private final int strikeCount;

    public JudgeResultDTO(int ballCount, int strikeCount) {
        this.ballCount = ballCount;
        this.strikeCount = strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }

    public int getStrikeCount() {
        return strikeCount;
    }
}
