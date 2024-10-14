package org.example.templates.interview.SingletonImpls;

public enum EnumSingleton {
    INSTANCE(null);

    private final Object res;

    EnumSingleton(Object res) {
        this.res = res;
    }

    public Object getRes() {
        return res;
    }
}
