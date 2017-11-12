package ru.aserdyuchenko.servlet;

/**
 * @author Anton Serdyuchenko. anton415@gmail.com
 */
public class User {
    private String login;
    private String name;
    private String email;
    private String createDate;

    public User(String name, String email, String createDate) {
        this.name = name;
        this.email = email;
        this.createDate = createDate;
    }

    public User(String login, String name, String email, String createDate) {
        this.login = login;
        this.name = name;
        this.email = email;
        this.createDate = createDate;
    }

    @Override

    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", createDate=" + createDate +
                '}';
    }
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }
}
