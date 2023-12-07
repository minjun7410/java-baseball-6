package baseball;

import baseball.dto.JudgeResultDTO;
import baseball.model.Judgement;
import baseball.model.Number;
import baseball.model.Numbers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

public class JudgementTest {
    Numbers computerNumbers;

    @BeforeEach
    void setting() {
        computerNumbers = makeNumbers(new int[]{1, 2, 3});
    }

    @Test
    void 판정테스트_3스트라이크() {
        JudgeResultDTO result = getResult(new int[]{1, 2, 3});
        assertThat(result.getBallCount()).isEqualTo(0);
        assertThat(result.getStrikeCount()).isEqualTo(3);
    }

    @Test
    void 판정테스트_3볼() {
        JudgeResultDTO result = getResult(new int[]{2, 3, 1});
        assertThat(result.getBallCount()).isEqualTo(3);
        assertThat(result.getStrikeCount()).isEqualTo(0);
    }

    @Test
    void 판정테스트_1볼() {
        JudgeResultDTO result = getResult(new int[]{3, 5, 6});
        assertThat(result.getBallCount()).isEqualTo(1);
        assertThat(result.getStrikeCount()).isEqualTo(0);
    }

    @Test
    void 판정테스트_1볼1스트라이크() {
        JudgeResultDTO result = getResult(new int[]{1, 3, 6});
        assertThat(result.getBallCount()).isEqualTo(1);
        assertThat(result.getStrikeCount()).isEqualTo(1);
    }

    @Test
    void 판정테스트_2볼1스트라이크() {
        JudgeResultDTO result = getResult(new int[]{3, 2, 1});
        assertThat(result.getBallCount()).isEqualTo(2);
        assertThat(result.getStrikeCount()).isEqualTo(1);
    }

    JudgeResultDTO getResult(int[] list) {
        Judgement result = new Judgement(makeNumbers(list), computerNumbers);
        return result.getResult();
    }

    Numbers makeNumbers(int[] list) {
        Numbers numbers = new Numbers();
        for (int number : list) {
            numbers.addNumber(new Number(number));
        }
        return numbers;
    }
}
