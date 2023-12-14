package menu.domain;

import java.util.Arrays;

public enum Category {
    일식("일식", 1),
    한식("한식", 2),
    중식("중식", 3),
    아시안("아시안", 4),
    양식("양식", 5);

    private final String name;
    private final int order;

    Category(String name, int order) {
        this.name = name;
        this.order = order;
    }

    public static Category getByOrder(int order) {
        return Arrays.stream(Category.values())
                .filter(category -> category.order == order)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    @Override
    public String toString() {
        return name;
    }
}
