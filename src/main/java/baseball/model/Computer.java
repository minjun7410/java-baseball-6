package baseball.model;

import baseball.constant.Constants;
import camp.nextstep.edu.missionutils.Randoms;

public class Computer {
    private Numbers computerNumbers;

    public Numbers initComputerNumbers() {
        computerNumbers = new Numbers();
        setComputerNumbersToRandom();
        return computerNumbers;
    }

    private void setComputerNumbersToRandom() {
        boolean[] visitedNumberArray = new boolean[Constants.MAXIMUM_NUMBER.getNumber() + 1];
        int size = 0;
        while (size < Constants.MAXIMUM_BALL_COUNT.getNumber()) {
            int randomNumber = Randoms.pickNumberInRange(Constants.MINIMUM_NUMBER.getNumber(), Constants.MAXIMUM_NUMBER.getNumber());
            if (checkDuplicated(visitedNumberArray, randomNumber)) continue;
            computerNumbers.addNumber(new Number(randomNumber));
            size++;
        }
    }

    private boolean checkDuplicated(boolean[] duplicateCheck, int num) {
        if (duplicateCheck[num]) return true;
        duplicateCheck[num] = true;
        return false;
    }

    public Judgement getJudgement(Numbers userNumbers) {
        return new Judgement(userNumbers, computerNumbers);
    }
}
