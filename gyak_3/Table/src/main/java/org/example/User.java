package org.example;

public class User {

    private String userName;
    private String password;
    private int id;
    private int loginCount;
    private boolean loggedIn;

    // Default konstruktor
    public User() {
        this.userName = null;
        this.password = null;
        this.id = 0;
        this.loginCount = 0;
        this.loggedIn = false;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public int getId() {
        return id;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public int getLoginCount() {
        return loginCount;
    }

    public void login() {
        loggedIn = true;
        loginCount++;
    }

    public void logout() {
        loggedIn = false;
    }

    public boolean updatePwd(String newPwd, boolean isLoggedIn) {
        if (!isLoggedIn) {
            throw new IllegalStateException("User not logged in!");
        }
        this.password = newPwd;
        return true;
    }
}
