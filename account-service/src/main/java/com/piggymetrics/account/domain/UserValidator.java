package com.piggymetrics.account.domain;

import com.diffblue.cover.annotations.InTestsUseStrings;

public class UserValidator {

    public static boolean validate(User user) {
        if (user == null) {
            throw new IllegalArgumentException("User cannot be null");
        }

        boolean isUsernameValid = validateUsername(user.getUsername());
        boolean isPasswordValid = validatePassword(user.getPassword());

        if (!isUsernameValid || !isPasswordValid) {
            throw new IllegalArgumentException("Credentials Invalid");
        }

        if (!isUsernameValid && !isPasswordValid) {
            throw new IllegalArgumentException("Credentials Invalid");
        }

        return true;

    }

    public static boolean validateUsername(String username) throws IllegalArgumentException {
    /*public static boolean validateUsername(
            @InTestsUseStrings({"alice123", "qa"}) String username)
            throws IllegalArgumentException {*/
        if (username == null || username.length() < 3 || username.length() > 20) {
            return false;
        } else {
            return true;
        }
    }

    public static boolean validatePassword(String password) throws IllegalArgumentException {
    /*public static boolean validatePassword(
            @InTestsUseStrings({"qwerty", "123"}) String password)
            throws IllegalArgumentException {*/
        if (password == null || password.length() < 6 || password.length() > 40) {
            return false;
        } else {
            return true;
        }
    }
}