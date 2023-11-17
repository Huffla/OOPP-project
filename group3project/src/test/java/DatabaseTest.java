import group3.modelFolder.Character;
import org.junit.jupiter.api.Test;
import group3.modelFolder.*;

import static org.junit.jupiter.api.Assertions.*;

public class DatabaseTest {
    
    UserDatabaseHandler dh = new UserDatabaseHandler("UsersTest.txt");
    Model tmodel = new Model("UserTest.txt");
    
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

    void test(){
        assertEquals(0, dh.getUsers().size());
        dh.addUser(new User("null","null".hashCode()));
        User u = dh.getUsers().get(0);
        assertSame("null", u.getName());
        assertEquals(1, dh.getUsers().size());
        tmodel.addCharacter(new Character("Craig"));
        Character c = tmodel.getCharacters().get(0);
        assertSame("Craig", c.getName());
    }
    @Test
    void assertUserRemoved(){
    
    }


    
    

}
