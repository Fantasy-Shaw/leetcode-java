package org.example.others;

import java.util.*;

public final class Singleton {
    private static Singleton instance;

    // 用于双重校验锁，volatile禁止重排序，所有write都在read之前
    private static volatile Singleton instance2;

    private Singleton() {
        // private constructor
    }

    public static Singleton getInstance() {
        synchronized (Singleton.class) {
            if (instance == null) {
                instance = new Singleton();
            }
        }
        return instance;
    }

    public static Singleton getInstance2() {
        if (instance2 == null) {
            synchronized (Singleton.class) {
                if (instance2 == null) {
                    instance2 = new Singleton();
                }
            }
        }
        return instance2;
    }

    public static void main(String[] args) {

    }
}
