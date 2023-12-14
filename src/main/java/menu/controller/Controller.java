package menu.controller;

import java.util.ArrayList;
import java.util.List;
import menu.domain.Calculator;
import menu.domain.Coach;
import menu.domain.ExcludeMenus;
import menu.util.RandomNumberGenerator;
import menu.view.InputView;
import menu.view.OutputView;

public class Controller {
    public static final String ERR_PREFIX = "[ERROR] ";
    private final InputView inputView;
    private final OutputView outputView;
    private final Parser parser;

    public Controller(InputView inputView, OutputView outputView, Parser parser) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.parser = parser;
    }

    public void run() {
        outputView.printStartMessage();
        List<String> coachNames = getCoachNames();
        List<Coach> coaches = new ArrayList<>();
        for (String name : coachNames) {
            coaches.add(new Coach(name, getExcludeMenus(name)));
        }

        Calculator calculator = new Calculator(coaches, new RandomNumberGenerator());
        calculator.recommendWeek();
        outputView.printWeek(calculator.getWeek());
        outputView.printCategories(calculator.getCategories());
        for (Coach coach : coaches) {
            outputView.printMenus(coach);
        }

    }

    private List<String> getCoachNames() {
        while (true) {
            try {
                return parser.parseCoachNames(inputView.inputCoachNames());
            } catch (IllegalArgumentException e) {
                System.out.println(ERR_PREFIX + e.getMessage());
            }
        }
    }

    private ExcludeMenus getExcludeMenus(String name) {
        while (true) {
            try {
                return new ExcludeMenus(parser.parseExcludeMenus(inputView.inputExcludeMenus(name)));
            } catch (IllegalArgumentException e) {
                System.out.println(ERR_PREFIX + e.getMessage());
            }
        }
    }
}
