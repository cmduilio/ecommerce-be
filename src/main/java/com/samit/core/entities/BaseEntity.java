package com.samit.core.entities;

import java.util.function.Consumer;

public abstract class BaseEntity {

    public <T> void setIfNotNull(final Consumer<T> setter, final T value) {
        if (value != null) {
            setter.accept(value);
        }
    }

    public abstract <T> void update(T object);
}
