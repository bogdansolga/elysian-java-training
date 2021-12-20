package com.elysian.java.training.d01.s2.interf;

public interface UserRepository {

    // defines the contract (to be implemented by each implementation)
    User getUser(String name);
}
