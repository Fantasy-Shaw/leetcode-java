package org.example.templates.interview.SingletonImpls;

import java.lang.reflect.Constructor;

public class DCLPSingleton {
    /**
     * Double-checked Locking Pattern
     */

    private DCLPSingleton() {
        // private constructor
    }

    private volatile static DCLPSingleton instance;

    public static DCLPSingleton getInstance() {
        if (instance == null) {
            synchronized (DCLPSingleton.class) {
                if (instance == null) {
                    instance = new DCLPSingleton();
                }
            }
        }
        return instance;
    }

    public static void breakDCLP() {
        try {
            Constructor<DCLPSingleton> constructor = DCLPSingleton.class.getDeclaredConstructor();
            constructor.setAccessible(true);
            DCLPSingleton dclpSingleton2 = constructor.newInstance();
            System.out.println(getInstance() == dclpSingleton2);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
