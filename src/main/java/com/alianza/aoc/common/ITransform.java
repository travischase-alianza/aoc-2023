package com.alianza.aoc.common;

public interface ITransform<T> {
    public T transform(int id, String in);
}