import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import group3.modelFolder.*;

public class LoginAuthTest {
    
    private static final Class NoSuchFieldException = null;
    LoginAuth loginAuth = new LoginAuth();
    User user = new User("test","test".hashCode());
    // add user to database
    @Test
    void returnsAccount() throws  java.lang.NoSuchFieldException {
        assertThrows(NoSuchFieldException, () -> loginAuth.attemptLogin("test", "wrongPassword"));
        assertThrows(NoSuchFieldException, () -> loginAuth.attemptLogin("!!!!noUSER!!!!", "wrongPassword"));
        assertTrue(loginAuth.attemptLogin("test", "test") == user);
    }
}
