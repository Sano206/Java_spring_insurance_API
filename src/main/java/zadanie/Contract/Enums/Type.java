package zadanie.Contract.Enums;

import lombok.Getter;

@Getter
public enum Type {
    FLAT("Flat"),
    FAMILY_HOUSE_WOOD("Family wooden house"),
    FAMILY_HOUSE_BRICK("Family brick house");

    private final String name;

    Type(String name) {
        this.name = name;
    }
}
