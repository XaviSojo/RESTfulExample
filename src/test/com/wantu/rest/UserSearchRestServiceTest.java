package com.wantu.rest;

import org.junit.jupiter.api.Test;

import java.net.UnknownHostException;

import static org.junit.jupiter.api.Assertions.*;

class UserSearchRestServiceTest {

    @Test
    void displaySearchReceivesNull() throws UnknownHostException {
        UserSearchRestService test = new UserSearchRestService();
        test.displaySearch("");
    }
}