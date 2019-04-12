package com.elveselimoski.starterapp.base

interface BaseContract {
    interface View<T> {
        fun isActive(): Boolean
    }

    interface Presenter<T> {
        fun bind(view: T)

        fun unbind()
    }
}