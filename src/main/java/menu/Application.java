package menu;

import menu.controller.Controller;
import menu.controller.Parser;
import menu.view.InputView;
import menu.view.OutputView;

public class Application {
    public static void main(String[] args) {
        Controller controller = new Controller(new InputView(), new OutputView(), new Parser());
        controller.run();
    }
}
