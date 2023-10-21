package baseball;
import camp.nextstep.edu.missionutils.Randoms;
public class Computer {
    int[] computerNumbers;
    Computer(){
        computerNumbers = new int[3];
    }
    public int[] initComputerNumbers(){
        boolean[] visitedNumberArray = new boolean[10];
        int computerNumberIndex = 0;
        while(computerNumberIndex < 3){
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if(checkDuplicated(visitedNumberArray, randomNumber)) continue;
            computerNumbers[computerNumberIndex++] = randomNumber;
        }
        return computerNumbers;
    }
    private boolean checkDuplicated(boolean[] duplicateCheck, int num){
        if(duplicateCheck[num]) return true;
        duplicateCheck[num] = true;
        return false;
    }
    public Judgement getJudgeResult(int[] userInput){
        int strike = 0;
        int ball = 0;
        for(int userIndex = 0; userIndex < 3; userIndex++){
            if(isStrike(userInput, userIndex)) strike++;
            else if(isBall(userInput, userIndex)) ball++;
        }
        return new Judgement(ball, strike);
    }
    private boolean isStrike(int[] userInput, int index){
        return userInput[index] == computerNumbers[index];
    }
    private boolean isBall(int[] userInput, int userIndex){
        for(int computerIndex = 0; computerIndex < 3; computerIndex++){
            if(userIndex == computerIndex) continue;
            if(userInput[userIndex] == computerNumbers[computerIndex]) return true;
        }
        return false;
    }
}
