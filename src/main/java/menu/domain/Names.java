package menu.domain;

import java.util.List;

public class Names {
    private final List<String> names;

    public Names(List<String> names) {
        validateLength(names);
        validateSize(names);
        this.names = names;
    }

    private void validateLength(List<String> names) {
        long count = names.stream()
                .filter(name -> name.length() >= 2 && name.length() <= 4)
                .count();
        if (count != names.size()) {
            throw new IllegalArgumentException("코치의 이름은 최소 2글자, 최대 4글자로 입력해야 합니다.");
        }
    }

    private void validateSize(List<String> names) {
        if (names.size() < 2 || names.size() > 5) {
            throw new IllegalArgumentException("코치는 최소 2명 이상, 5명 이하로 입력해야 합니다.");
        }
    }

    public List<String> getNames() {
        return names;
    }
}
