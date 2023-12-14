package menu.view;

import java.util.List;
import java.util.stream.Collectors;
import menu.domain.Category;
import menu.domain.Coach;

public class OutputView {
    public void printStartMessage() {
        System.out.println("점심 메뉴 추천을 시작합니다.\n");
    }

    public void printWeek(List<String> week) {
        String format = String.format("[ 구분 | %s ]",
                String.join(" | ", week));
        System.out.println(format);
    }

    public void printCategories(List<Category> categories) {
        String format = String.format("[ 카테고리 | %s ]",
                categories.stream()
                        .map(Category::toString)
                        .collect(Collectors.joining(" | ")));
        System.out.println(format);
    }

    public void printMenus(Coach coach) {
        System.out.println("메뉴 추천 결과입니다.");
        String format = String.format("[ %s | %s ]",
                coach.getName(),
                coach.getMenus().stream()
                        .collect(Collectors.joining(" | ")));
        System.out.println(format);
        System.out.println("추천을 완료했습니다.");
    }
}
