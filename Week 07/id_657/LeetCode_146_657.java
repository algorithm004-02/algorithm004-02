package com.arithmetic.arithmetic.week07;

import java.util.LinkedHashMap;
import java.util.Map;

public class LeetCode_146_657 extends LinkedHashMap<Integer, Integer> {
    private int capacity;

    public LeetCode_146_657(int capacity) {
        super(capacity, 0.75F, true);
        this.capacity = capacity;
    }

    public int get(int key) {
        return super.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }
}
