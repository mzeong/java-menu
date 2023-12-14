package menu.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import menu.domain.Category;
import menu.domain.Menu;

public class RandomNumberGenerator {
    public int generate() {
        return Randoms.pickNumberInRange(1, 5);
    }

    public String shuffle(Category category) {
        List<String> menus = Menu.getMenusInCategory(category);
        return Randoms.shuffle(menus).get(0);
    }
}
