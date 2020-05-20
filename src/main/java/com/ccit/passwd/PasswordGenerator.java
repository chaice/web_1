package com.ccit.passwd;

public class PasswordGenerator {
    public static void main(String[] args) {
        genpwd("matrix", "e192b7253fbd1d7a5cb0aa6468ca1e44");
    }

    public static void genpwd(String username, String password) {
        System.out.println(username + ":" + MD5Utils.encrypt(MD5Utils.encrypt(password)) + ":" +
                MD5Utils.encrypt(
                        MD5Utils.encrypt(MD5Utils.encrypt(password)) + "{" + username + "}")
        );
    }

    public static void genpwd(String username) {
        genpwd(username, username);
    }
}
