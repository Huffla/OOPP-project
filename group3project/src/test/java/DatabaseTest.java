import group3.modelFolder.Character;
import org.junit.jupiter.api.Test;
import group3.modelFolder.*;

import static org.junit.jupiter.api.Assertions.*;

public class DatabaseTest {
    
    UserDatabaseHandler dh = new UserDatabaseHandler("UsersTest.txt");
    Model tmodel = new Model();
    
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
    void test(){
        assertEquals(0, dh.getUsers().size());
        dh.addToList(new User("null"));
        User u = dh.getUsers().get(0);
        assertSame("null", u.name);
        assertEquals(1, dh.getUsers().size());
        tmodel.addCharacter(new Character("Craig"));
        Character c = tmodel.getCharacters().get(0);
        assertSame("Craig", c.getName());
    }
    @Test
    void assertUserRemoved(){
    
    }


    
    

}
