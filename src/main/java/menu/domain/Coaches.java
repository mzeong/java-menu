package menu.domain;

import java.util.List;

public class Coaches {
    private final List<String> names;

    public Coaches(List<String> names) {
        validateSize(names);
        this.names = names;
    }

    private void validateSize(List<String> names) {
        if (names.size() < 2 || names.size() > 5) {
            throw new IllegalArgumentException("코치는 최소 2명 이상 입력해야 합니다.");
        }
    }
}
