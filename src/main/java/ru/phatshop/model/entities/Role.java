package ru.phatshop.model.entities;

import java.util.stream.Stream;

public enum Role {
    ADMIN,
    USER,
    SELLER;

    public static Stream<Role> stream() {
        return Stream.of(Role.values());
    }
}
