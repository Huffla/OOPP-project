import group3.modelFolder.character.Character;
import group3.modelFolder.character.CharacterFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class CharacterTest {
    CharacterFactory cFactory = new CharacterFactory();
    Character testCharacter = cFactory.createCharacter("Torgny");

    @Test
    public void CharacterPropertiesTest(){
        assertEquals(testCharacter.getName(), "Torgny"); //Fox pappa heter Torgny
        assertNull(testCharacter.getCharacterTraits());
        assertNull(testCharacter.getImagePath());
    }
}
