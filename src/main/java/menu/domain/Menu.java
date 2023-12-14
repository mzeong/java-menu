package menu.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public enum Menu {
    규동(Category.일식, "규동"),
    우동(Category.일식, "우동"),
    미소시루(Category.일식, "미소시루"),
    스시(Category.일식, "스시"),
    가츠동(Category.일식, "가츠동"),
    오니기리(Category.일식, "오니기리"),
    하이라이스(Category.일식, "하이라이스"),
    라멘(Category.일식, "라멘"),

    김밥(Category.한식, "김밥"),
    김치찌개(Category.한식, "김치찌개"),
    쌈밥(Category.한식, "쌈밥"),
    된장찌개(Category.한식, "된장찌개"),
    칼국수(Category.한식, "칼국수"),
    불고기(Category.한식, "불고기"),
    떡볶이(Category.한식, "떡볶이"),
    제육볶음(Category.한식, "제육볶음"),

    깐풍기(Category.중식, "깐풍기"),
    볶음면(Category.중식, "볶음면"),
    동파육(Category.중식, "동파육"),
    짜장면(Category.중식, "짜장면"),
    짬뽕(Category.중식, "짬뽕"),
    마파두부(Category.중식, "마파두부"),
    탕수육(Category.중식, "탕수육"),
    토마토_달걀볶음(Category.중식, "토마토 달걀볶음"),
    고추잡채(Category.중식, "고추잡채"),

    팟타이(Category.아시안, "팟타이"),
    카오_팟(Category.아시안, "카오 팟"),
    나시고렝(Category.아시안, "나시고렝"),
    파인애플_볶음밥(Category.아시안, "파인애플 볶음밥"),
    쌀국수(Category.아시안, "쌀국수"),
    똠얌꿍(Category.아시안, "똠얌꿍"),
    반미(Category.아시안, "반미"),
    월남쌈(Category.아시안, "월남쌈"),
    분짜(Category.아시안, "분짜"),

    라자냐(Category.양식, "라자냐"),
    그라탱(Category.양식, "그라탱"),
    뇨끼(Category.양식, "뇨끼"),
    끼슈(Category.양식, "끼슈"),
    프렌치_토스트(Category.양식, "프렌치 토스트"),
    바게트(Category.양식, "바게트"),
    스파게티(Category.양식, "스파게티"),
    피자(Category.양식, "피자"),
    파니니(Category.양식, "파니니");

    private final Category category;
    private final String name;

    Menu(Category category, String name) {
        this.category = category;
        this.name = name;
    }

    public static Menu getByName(String name) {
        return Arrays.stream(Menu.values())
                .filter(menu -> Objects.equals(menu.name, name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("존재하는 메뉴를 입력해야 합니다."));
    }

    public static List<String> getMenusInCategory(Category category) {
        return Arrays.stream(Menu.values())
                .filter(menu -> menu.category == category)
                .map(menu -> menu.name)
                .collect(Collectors.toList());
    }

    public Category getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }
}
