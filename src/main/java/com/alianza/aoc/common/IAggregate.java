package com.alianza.aoc.common;

public interface IAggregate<T> {
    public T aggregate(int id, Object in); 
}