package com.piggymetrics.account.domain;

import com.diffblue.cover.annotations.InterestingTestFactory;

public class UserFactory {

    @InterestingTestFactory
    //Valid user creation test data
    public static User createUser() {
        User user = new User();
        user.setUsername("smithy");
        user.setPassword("qwertyuio123");
        return user;
    }

    //@InterestingTestFactory
    //Invalid user creation test data
    public static User createInvalidUser() {
        User user = new User();
        user.setPassword("abc");
        user.setUsername("qaz");
        return user;
    }

}
