package baseball;

public class Game {
    private Display display;
    private Computer computer;
    public Game(){
        display = new Display();
        computer = new Computer();
        display.printStartText();
    }
    public void playGame(){
        computer.initComputerNumbers();
        Judgement judgeResult;
        do{
            Numbers userNumbers = display.getUserNumbers();
            judgeResult = computer.getJudgement(userNumbers);
            judgeResult.printResult();
        }
        while(!judgeResult.isOut());
        display.printGameOverText();
    }
}
