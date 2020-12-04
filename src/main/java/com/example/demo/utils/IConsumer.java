package com.example.demo.utils;

@FunctionalInterface
public interface IConsumer<T> {
    public void accept(T s);
}
