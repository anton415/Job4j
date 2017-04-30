package ru.aserdyuchenko.UserSort;

/**
 * Created by Anton on 30.04.17.
 */
public class User implements Comparable<User> {
    private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(User o) {
        return age - o.age;
    }
}
