import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import group3.modelFolder.*;

public class LoginAuthTest {
    private static final Class InvalidPasswordException = null;
    private static final Class NoUserFoundException = null;
    LoginAuth loginAuth = new LoginAuth();
    User user = new User("test","test".hashCode());
    // add user to database
    @Test
    void returnsAccount() throws group3.modelFolder.InvalidPasswordException, group3.modelFolder.NoUserFoundException {
        assertThrows(InvalidPasswordException, () -> loginAuth.attemptLogin("test", "wrongPassword"));
        assertThrows(NoUserFoundException, () -> loginAuth.attemptLogin("!!!!noUSER!!!!", "wrongPassword"));
        assertTrue(loginAuth.attemptLogin("test", "test") == user);
    }
}
