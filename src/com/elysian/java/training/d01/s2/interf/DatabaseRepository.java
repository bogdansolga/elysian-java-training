package com.elysian.java.training.d01.s2.interf;

public class DatabaseRepository implements UserRepository {

    @SuppressWarnings("unused")
    private void notUsedMethod() {
    }

    @Override
    public User getUser(String name) {
        return new User("Alex");
    }
}
