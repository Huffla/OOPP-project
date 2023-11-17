import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import group3.modelFolder.*;

public class LoginAuthTest {
    Model model = new Model("UsersTest.txt");
    
    LoginAuth loginAuth = new LoginAuth(model.getUsers());
    
    void setUp(){
        model.clearUsers();
        model.setUser(new User("Smurf", "password123".hashCode()));
    }

    // add user to database
    @Test
    void returnsAccount()  {
        setUp();
        User u = new User("Smurf", "password123".hashCode());

        try {
            assertTrue(u.equals(loginAuth.attemptLogin("Smurf", "password123")));
        } catch (java.lang.NoSuchFieldException e) {
            assertTrue(false);
            e.printStackTrace();
        }
        
    }
    @Test
    void wrongPasswordThrows(){
        setUp();
        assertThrows(NoSuchFieldException.class, () -> loginAuth.attemptLogin("Smurf", "fellösenord"));
    }
    
    @Test 
    void noAccountThrows(){
        setUp();
        assertThrows(NoSuchFieldException.class, () -> loginAuth.attemptLogin("InteSmurf", "fellösenord"));
   
    }
}
