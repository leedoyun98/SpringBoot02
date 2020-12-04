package com.example.demo.utils;

@FunctionalInterface
public interface ISupply<T> {
    public T get();
}
