package baseball;
import camp.nextstep.edu.missionutils.Console;

public class Display {
    public void printStartText(){
        System.out.println("숫자 야구 게임을 시작합니다.");
    }
    private void printEndText(){
        System.out.println("숫자 야구 게임을 종료합니다.");
    }
    public void printGameOverText(){
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
    public void printJudgeResult(int ballCount, int strikeCount){
        if(ballCount == 0 && strikeCount == 0){
            System.out.println("낫싱");
            return;
        }
        if(ballCount > 0 && strikeCount > 0){
            System.out.printf("%d볼 %d스트라이크\n", ballCount, strikeCount);
            return;
        }
        if(ballCount == 0){
            System.out.printf("%d스트라이크\n", strikeCount);
            return;
        }
        if(strikeCount == 0){
            System.out.printf("%d볼\n", ballCount);
            return;
        }
    }
    public int[] getUserInput(){
        System.out.print("숫자를 입력해주세요 : ");
        return getSplitedUserInput(Console.readLine());
    }
    private int[] getSplitedUserInput(String input){
        int[] result = new int[3];
        String trimInput = input.trim();
        Validation.validateUserInputSize(trimInput);
        char[] userInputs = trimInput.toCharArray();
        boolean[] numberCheckArray = new boolean[10];
        for(int i = 0; i < 3; i++){
            Validation.validateIsNumber(userInputs[i]);
            Validation.validateDuplicatedNumber(numberCheckArray, userInputs[i]);
            result[i] = userInputs[i] - '0';
        }
        return result;
    }
    public boolean getRestartInput(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        boolean oneOrTwo = getOneOrTwo(Console.readLine());
        return oneOrTwo;
    }
    private boolean getOneOrTwo(String input){
        String trimInput = input.trim();
        Validation.validateOneOrTwo(trimInput);
        if(trimInput.equals("1")){
            return true;
        }
        printEndText();
        return false;
    }
    public void close(){
        Console.close();
    }
}
