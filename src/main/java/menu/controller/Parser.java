package menu.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import menu.domain.Menu;

public class Parser {
    public static final String DELIMITER = ",";

    public List<String> parseCoachNames(String input) {
        List<String> list = Arrays.stream(input.split(DELIMITER))
                .map(String::trim)
                .filter(str -> !str.isEmpty())
                .collect(Collectors.toList());
        if (list.isEmpty()) {
            throw new IllegalArgumentException("입력이 없거나 쉼표나 공백으로만 구성됨");
        }
        return list;
    }

    public List<Menu> parseExcludeMenus(String input) {
        if (input.trim().isEmpty()) {
            return List.of();
        }
        List<String> list = Arrays.stream(input.split(DELIMITER))
                .map(String::trim)
                .filter(str -> !str.isEmpty())
                .collect(Collectors.toList());
        if (list.isEmpty()) {
            throw new IllegalArgumentException("입력이 없거나 쉼표나 공백으로만 구성됨");
        }
        return list.stream()
                .map(Menu::getByName)
                .collect(Collectors.toList());
    }
}
