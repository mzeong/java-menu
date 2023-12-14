package menu.domain;

import java.util.ArrayList;
import java.util.List;
import menu.util.RandomNumberGenerator;

public class Calculator {
    private final List<Coach> coaches;
    private final RandomNumberGenerator randomNumberGenerator;
    private final List<Category> categories;
    private final List<String> week;

    public Calculator(List<Coach> coaches, RandomNumberGenerator randomNumberGenerator) {
        this.coaches = coaches;
        this.randomNumberGenerator = randomNumberGenerator;
        this.categories = new ArrayList<>();
        this.week = List.of("월요일", "화요일", "수요일", "목요일", "금요일");
    }

    public void recommendWeek() {
        for (String day : week) {
            recommendAll();
        }
    }

    private void recommendAll() {
        Category category = chooseCategory();
        for (Coach coach : coaches) {
            coach.recommend(category, randomNumberGenerator);
        }
    }

    private Category chooseCategory() {
        Category category;
        do {
            category = Category.getByOrder(randomNumberGenerator.generate());
        } while (isInvalid(category));
        categories.add(category);
        return category;
    }

    private boolean isInvalid(Category target) {
        long count = categories.stream()
                .filter(category -> category == target)
                .count();
        return count >= 2;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public List<String> getWeek() {
        return week;
    }
}
