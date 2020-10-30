package zadanie.Contract.Enums;

import lombok.Getter;

@Getter
public enum Validity {
    SLOVAKIA("Slovakia"),
    WORLD("World"),
    WORLD_AND_SLOVAKIA("Everywhere");

    private final String name;

    Validity(String name) {
        this.name = name;
    }
}
