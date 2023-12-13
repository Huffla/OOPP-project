import group3.modelFolder.character.Character;
import group3.modelFolder.character.CharacterFactory;
import group3.modelFolder.trait.Trait;
import org.junit.jupiter.api.Test;

import java.util.Dictionary;
import java.util.Hashtable;

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

    @Test
    public void testCreateCharacter() {
        CharacterFactory factory = new CharacterFactory();
        Dictionary<String, Double> traits = new Hashtable<>();
        traits.put("Trait1", 1.0);
        traits.put("Trait2", 0.5);
        Character character = factory.createCharacter(traits, "Test Character", "Test Image");
        assertTrue("Test Character".equals(character.getName()) );
        assertTrue("Test Image".equals(character.getImagePath()));
        for(Trait t: character.getCharacterTraits()){
            if(t.getName().equals("Trait1")){
                assertTrue(t.get_amount_of_trait() - 1.0 < 0.0001);
            }
        }

    }
}
