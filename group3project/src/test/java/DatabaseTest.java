
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import group3.modelFolder.*;
public class DatabaseTest {
    
    UserDatabaseHandler dh = new UserDatabaseHandler("UsersTest.txt");
    
    @Test
    void setUp(){
        dh.clearList();
    }
    @Test
    private void assertEmpty() {
        assertTrue(dh.getUsers().size() == 0);
    }
    @Test
    void assertAlreadyExists(){
        setUp();
        dh.addUser(new User("null",1));
        assertTrue(dh.getUsers().size() == 1);
        dh.addUser(new User("null",1));
        assertTrue(dh.getUsers().size() == 1);
    }
    @Test
    void assertUserRemoved(){
    
    }


    
    

}
