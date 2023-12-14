package menu.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import menu.domain.Menu;

public class Parser {
    public static final String DELIMITER = ",";

    public List<String> parseCoachNames(String input) {
        return Arrays.stream(input.split(DELIMITER))
                .map(String::trim)
                .filter(name -> !name.isEmpty())
                .collect(Collectors.toList());
    }

    public List<Menu> parseExcludeMenus(String input) {
        if (input == null || input.trim().isEmpty()) {
            return List.of();
        }
        try {
            return Arrays.stream(input.split(DELIMITER))
                    .map(String::trim)
                    .map(Menu::valueOf)
                    .collect(Collectors.toList());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("존재하는 메뉴만 입력해야 합니다.");
        }
    }
}
