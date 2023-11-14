import group3.modelFolder.Character;
import org.junit.jupiter.api.Test;
import group3.modelFolder.*;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;


public class CharacterTest {

    Character testCharacter = CharacterFactory.createCharacter("Torgny");

    @Test
    public void CharacterPropertiesTest(){
        assertEquals(testCharacter.getName(), "Torgny"); //Fox pappa heter Torgny
        assertNull(testCharacter.getCharacterTraits());
        assertNull(testCharacter.getCharacterImage());
    }
}
