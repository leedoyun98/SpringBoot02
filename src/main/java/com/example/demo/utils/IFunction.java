package com.example.demo.utils;

@FunctionalInterface
public interface IFunction<T,R> {
    public R apply(T s);
}
