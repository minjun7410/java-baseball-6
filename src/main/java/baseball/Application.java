package baseball;

import baseball.controller.Game;
import baseball.view.InputView;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputView inputView = new InputView();
        Game game = new Game();
        do {
            game.playGame();
        } while (inputView.getRestartInput());
    }
}
