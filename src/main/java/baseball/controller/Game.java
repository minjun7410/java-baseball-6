package baseball.controller;

import baseball.model.Computer;
import baseball.model.Judgement;
import baseball.model.Numbers;
import baseball.view.InputView;
import baseball.view.OutputView;

public class Game {
    private final InputView inputView;
    private final OutputView outputView;
    private final Computer computer = new Computer();

    public Game(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        outputView.printStartText();
    }

    public void playGame() {
        computer.initComputerNumbers();
        Judgement judgement;
        do {
            Numbers userNumbers = inputView.getUserNumbers();
            judgement = computer.getJudgement(userNumbers);
            outputView.printJudgeResult(judgement.getResult());
        } while (!judgement.isOut());
        outputView.printGameOverText();
    }
}
