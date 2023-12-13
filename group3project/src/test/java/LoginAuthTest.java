import group3.modelFolder.login.LoginAuth;
import group3.modelFolder.model.Model;
import group3.modelFolder.user.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LoginAuthTest {
    Model model = Model.getInstance("UsersTest.txt","Questions.txt","Traits.txt","Characters.txt");
    
    LoginAuth loginAuth = new LoginAuth(model.getUsers());
    
    void setUp(){
        model.clearUsers();
        model.setUser(new User("Smurf", "password123".hashCode()));
        model.addUser(new User("Smurf", "password123".hashCode()));
    }

    // add user to database
    @Test
    void returnsAccount()  {
        setUp();
        User u = new User("Smurf", "password123".hashCode());


        try {
            assertTrue(u.getName().equals(loginAuth.attemptLogin("Smurf", "password123").getName()));
        } catch (java.lang.NoSuchFieldException e) {
            fail();
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
