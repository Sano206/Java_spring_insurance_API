package zadanie.Contract.Enums;

import lombok.Getter;

@Getter
public enum Purpose {
    WORK("Work"),
    RELAX("Relax"),
    SPORT("Sport");

    private final String name;

    Purpose(String name) {
        this.name = name;
    }
}
