package menu.controller;

import java.util.List;
import menu.domain.Coach;
import menu.domain.ExcludeMenus;
import menu.domain.Menu;
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

    public void init() {
        List<String> coachNames = getCoachNames();
        for (String name : coachNames) {
            ExcludeMenus excludeMenus = getExcludeMenus(name);
            Coach coach = new Coach(name, excludeMenus);
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
                List<Menu> menus = parser.parseExcludeMenus(inputView.inputExcludeMenus(name));
                return new ExcludeMenus(menus);
            } catch (IllegalArgumentException e) {
                System.out.println(ERR_PREFIX + e.getMessage());
            }
        }
    }
}
