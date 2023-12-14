package menu.domain;

import java.util.List;

public class ExcludeMenus {
    private final List<Menu> excludeMenus;

    public ExcludeMenus(List<Menu> excludeMenus) {
        validateDuplicate(excludeMenus);
        validateSize(excludeMenus);
        this.excludeMenus = excludeMenus;
    }

    private void validateDuplicate(List<Menu> excludeMenus) {
        long count = excludeMenus.stream()
                .distinct()
                .count();
        if (count != excludeMenus.size()) {
            throw new IllegalArgumentException("메뉴는 중복되지 않게 입력해야 합니다.");
        }
    }

    private void validateSize(List<Menu> excludeMenus) {
        if (excludeMenus.size() > 2) {
            throw new IllegalArgumentException("메뉴는 최소 0개, 최대 2개로 입력해야 합니다.");
        }
    }
}
