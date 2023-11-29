/*package group3.modelFolder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class SmurfinatorTest {
    Model m = Model.getInstance("SmurfinatorTestUsers.txt", "SmurfinatorTestQuestions.txt", "SmurfinatorTestTraits.txt","SmurfinatorTestCharacters.txt");
    Smurfinator smurfinator = new Smurfinator(m.getQuestions(),m.getTraits(),m.getCharacters(),new User("test", 0));
    
    void setup(){
    m.character_handler.clearList();
    }
    @Test
    void testAnswerDontKnow() {
        setup();
        Trait t = smurfinator.currentTrait;
        smurfinator.answerDontKnow();
        for (Trait askedTrait: smurfinator.askedTraits) {
            if(askedTrait.getName().equals(t.getName())){
                assertTrue(askedTrait.get_amount_of_trait().equals(0.5) );
                break;
            }
        }
    }

    @Test
    void testAnswerNo() {
        setup();
        Trait t = smurfinator.currentTrait;
        smurfinator.answerNo();
        for (Trait askedTrait: smurfinator.askedTraits) {
            if(askedTrait.getName().equals(t.getName())){
                assertTrue(askedTrait.get_amount_of_trait().equals(0.0) );
                break;
            }
        }
    }

    @Test
    void testAnswerRange() {
        setup();
        Trait t = smurfinator.currentTrait;
        smurfinator.answerRange(0.7);
        for (Trait askedTrait: smurfinator.askedTraits) {
            if(askedTrait.getName().equals(t.getName())){
                assertTrue(askedTrait.get_amount_of_trait().equals(0.7));
                break;
            }
        }
    }

    @Test
    void testAnswerYes() {
        setup();
        Trait t = smurfinator.currentTrait;
        smurfinator.answerYes();
        for (Trait askedTrait: smurfinator.askedTraits) {
            if(askedTrait.getName().equals(t.getName())){
                assertTrue(askedTrait.get_amount_of_trait().equals(1.0) );
                break;
            }
        }
    }

    @Test
    void testCreateNewCharacter() {
        setup();
        smurfinator.createNewCharacter("null");
        for(Character c : m.getCharacters()){
            assertTrue(c.getName().equals("null"));
        }
    }


    @Test
    void testReset() {
        setup();
        smurfinator.reset();
        assertEquals(smurfinator.askedQuestions.size(), 0);
        assertEquals(smurfinator.askableQuestions.size(),smurfinator.questions.size() );
        assertEquals(smurfinator.askedTraits.size(), 0);
        assertEquals(smurfinator.characterCreatingState, false);
    }


}
*/
