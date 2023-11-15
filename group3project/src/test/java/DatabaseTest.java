
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import group3.modelFolder.*;
public class DatabaseTest {
    
    UserDatabaseHandler dh = new UserDatabaseHandler();
    
    @Test
    void test(){
        assertTrue(dh.getUsers().size() == 0);
        dh.addToList(new User("null",1));
        User u = dh.getUsers().get(0);
        assertTrue(u.getName() == "null");
        assertTrue(dh.getUsers().size() == 1);
    }
    
    

}
