package com.example.demo.utils;

@FunctionalInterface
public interface IPredicate<T> {
    public boolean test(T t);
}
