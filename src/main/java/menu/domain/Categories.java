package menu.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import menu.util.RandomNumberGenerator;

public class Categories {
    private final RandomNumberGenerator randomNumberGenerator;
    private final List<Category> categories = new ArrayList<>();

    public Categories(RandomNumberGenerator randomNumberGenerator) {
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public Category selectCategory() {
        Category category;
        do {
            category = Category.getByOrder(randomNumberGenerator.generate());
        } while (isUnselectable(category));

        categories.add(category);
        return category;
    }

    private boolean isUnselectable(Category target) {
        int count = (int) categories.stream()
                .filter(category -> category == target)
                .count();
        if (count >= 2) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return String.format("[ 카테고리 | %s ]",
                categories.stream()
                        .map(Category::toString)
                        .collect(Collectors.joining(" | ")));
    }
}
