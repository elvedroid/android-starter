package com.elveselimoski.starterapp.base;

public interface BaseContract {
    interface View<T> {
        boolean isActive();
    }

    interface Presenter<T> {
        void bind(T view);

        void unbind();
    }
}