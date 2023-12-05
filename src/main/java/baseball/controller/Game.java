package baseball.controller;

import baseball.model.Computer;
import baseball.model.Judgement;
import baseball.model.Numbers;
import baseball.view.InputView;
import baseball.view.OutputView;

public class Game {
    private final InputView inputView = new InputView();
    private final Computer computer = new Computer();

    public Game() {
        OutputView.printStartText();
    }

    public void playGame() {
        computer.initComputerNumbers();
        Judgement judgement;
        do {
            Numbers userNumbers = inputView.getUserNumbers();
            judgement = computer.getJudgement(userNumbers);
            judgement.printResult();
        } while (!judgement.isOut());
        OutputView.printGameOverText();
    }
}
