import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class SILab2Test {

    @Test
    void testFunction_MandatoryInformationMissing() {
        User user = null;
        List<User> allUsers = new ArrayList<>();
        Assertions.assertThrows(RuntimeException.class, () -> SILab2.function(user, allUsers));
    }

    @Test
    void testFunction_SetUsernameWhenNull() {
        User user = new User(null, "password", "email@example.com");
        List<User> allUsers = new ArrayList<>();

        SILab2.function(user, allUsers);

        Assertions.assertEquals("email@example.com", user.getUsername());
    }

    @Test
    void testFunction_CheckSameCountForEmailAndUsername() {

        User user = new User("username", "password", "email@example.com");
        List<User> allUsers = new ArrayList<>();
        allUsers.add(new User("another", "anotherPassword", "email@example.com"));


        boolean result = SILab2.function(user, allUsers);


        Assertions.assertFalse(result);
    }


    @Test
    void testFunction_PasswordContainsUsername() {

        User user = new User("username", "password", "email@example.com");
        List<User> allUsers = new ArrayList<>();


        boolean result = SILab2.function(user, allUsers);


        Assertions.assertFalse(result);
    }

    @Test
    void testFunction_PasswordLengthLessThan8() {

        User user = new User("username", "pass", "email@example.com");
        List<User> allUsers = new ArrayList<>();

        boolean result = SILab2.function(user, allUsers);


        Assertions.assertFalse(result);
    }

    @Test
    void testFunction_PasswordContainsSpecialCharacters() {

        User user = new User("username", "password!", "email@example.com");
        List<User> allUsers = new ArrayList<>();

        boolean result = SILab2.function(user, allUsers);


        Assertions.assertTrue(result);
    }

    @Test
    void testFunction_AllConditionsSatisfied() {

        User user = new User("username", "!#password", "email@example.com");
        List<User> allUsers = new ArrayList<>();

        boolean result = SILab2.function(user, allUsers);


        Assertions.assertTrue(result);
    }
}