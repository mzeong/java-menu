package menu.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Parser {
    public static final String DELIMITER = ",";

    public List<String> parseComma(String input) {
        return Arrays.stream(input.split(DELIMITER))
                .map(String::trim)
                .filter(str -> !str.isEmpty())
                .collect(Collectors.toList());
    }
}
