package com.elysian.java.training.d01.s2.interf;

// the users should not be retrieved from the filesystem
@Deprecated
public class FileSystemRepository implements UserRepository {

    /**
     * This method does magic
     *
     * @param name the name
     *
     * @return something
     */
    @Override
    public User getUser(String name) {
        return new User("Amalia");
    }
}
