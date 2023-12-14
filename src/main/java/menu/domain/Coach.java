package menu.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import menu.util.RandomNumberGenerator;

public class Coach {
    private final String name;
    private final ExcludeMenus excludeMenu;
    private final List<String> menus = new ArrayList<>();

    public Coach(String name, ExcludeMenus excludeMenu) {
        this.name = name;
        this.excludeMenu = excludeMenu;
    }

    public void recommend(Category category, RandomNumberGenerator randomNumberGenerator) {
        String menuName;
        do {
            menuName = randomNumberGenerator.shuffle(category);
        } while (isInvalid(menuName));
        menus.add(menuName);
    }

    private boolean isInvalid(String target) {
        long excludeCount = excludeMenu.getExcludeMenus().stream()
                .filter(menu -> Objects.equals(menu.getName(), target))
                .count();
        if (excludeCount > 0) {
            return false;
        }

        long alreadyCount = menus.stream()
                .filter(menuName -> Objects.equals(menuName, target))
                .count();
        return alreadyCount > 0;
    }

    public String getName() {
        return name;
    }

    public ExcludeMenus getExcludeMenu() {
        return excludeMenu;
    }

    public List<String> getMenus() {
        return menus;
    }
}
