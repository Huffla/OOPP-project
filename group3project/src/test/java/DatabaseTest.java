import org.junit.jupiter.api.Test;
import group3.modelFolder.*;

import static org.junit.jupiter.api.Assertions.*;

public class DatabaseTest {
    
    UserDatabaseHandler dh = new UserDatabaseHandler();
    
    @Test
    void test(){
        assertEquals(0, dh.getUsers().size());
        dh.addToList(new User("null"));
        User u = dh.getUsers().get(0);
        assertSame("null", u.name);
        assertEquals(1, dh.getUsers().size());
    }
    
    

}
