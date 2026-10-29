package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class UserTest {

    @Test
    void mockReturnsConfiguredUserDataAndVerifiesMethodCalls() {
        User user = mock(User.class);

        when(user.getUserName()).thenReturn("TesztElek");
        when(user.getPassword()).thenReturn("TOPSECRET");
        when(user.isLoggedIn()).thenReturn(true);
        when(user.getId()).thenReturn(123);

        assertEquals("TesztElek", user.getUserName());
        assertEquals("TOPSECRET", user.getPassword());
        assertTrue(user.isLoggedIn());
        assertEquals(123, user.getId());

        user.login();
        user.logout();
        user.updatePwd("NEWSECRET", true);

        verify(user).login();
        verify(user).logout();
        verify(user).updatePwd("NEWSECRET", true);
    }

    @Test
    void updatePwdCallsUserDatabase() {
        UserDatabase database = mock(UserDatabase.class);
        User user = new User(database);

        user.updatePwd("NEWSECRET", true);

        verify(database).setPassword(0, "NEWSECRET");
    }
}