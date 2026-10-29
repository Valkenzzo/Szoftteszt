package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void userObject_shouldNotBeNull() {
        User u = new User();
        assertNotNull(u);
    }

    @Test
    void defaultFields_shouldBeNullOrZero() {
        User u = new User();

        assertNull(u.getUserName());
        assertNull(u.getPassword());
        assertEquals(0, u.getId());
        assertEquals(0, u.getLoginCount());
    }

    @Test
    void updatePwd_shouldThrowExceptionWhenNotLoggedIn() {
        User u = new User();
        assertThrows(IllegalStateException.class, () -> u.updatePwd("new", false));
    }


    @Test
    void isLoggedIn_shouldReturnFalseByDefault() {
        User u = new User();
        assertFalse(u.isLoggedIn());
    }

    @Test
    void login_shouldSetLoggedInTrueAndIncreaseLoginCount() {
        User u = new User();
        u.login();
        assertTrue(u.isLoggedIn());
        assertEquals(1, u.getLoginCount());
    }

    @Test
    void logout_shouldSetLoggedInFalse() {
        User u = new User();
        u.login();
        u.logout();
        assertFalse(u.isLoggedIn());
    }


}
