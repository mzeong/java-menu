package menu.domain;

import java.util.HashSet;
import java.util.Set;
import menu.util.RandomNumberGenerator;

public class Coach {
    private final String name;
    private final ExcludeMenus excludeMenu;
    private final RandomNumberGenerator randomNumberGenerator;
    public Set<String> menus = new HashSet<>();

    public Coach(String name, ExcludeMenus excludeMenu, RandomNumberGenerator randomNumberGenerator) {
        this.name = name;
        this.excludeMenu = excludeMenu;
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public void selectMenu(Category category) {
        String menuName;
        do {
            menuName = randomNumberGenerator.shuffle(category);
        } while (isUnselectable(menuName) || !menus.add(menuName));
    }

    private boolean isUnselectable(String menuName) {
        return excludeMenu.isUnselectable(menuName);
    }

    @Override
    public String toString() {
        return String.format("[ 카테고리 | %s ]",
                String.join(" | ", menus));
    }
}
