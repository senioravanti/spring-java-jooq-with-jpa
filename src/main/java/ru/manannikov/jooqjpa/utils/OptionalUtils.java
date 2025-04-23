package ru.manannikov.jooqjpa.utils;

import java.util.Optional;
import java.util.function.Supplier;

public class OptionalUtils {
    public static <T> Optional<T> fromThrowingSupplier(Supplier<T> throwingSupplier) {
        try {
            return Optional.ofNullable(throwingSupplier.get());
        } catch (Exception ex) {
            return Optional.empty();
        }
    }
}