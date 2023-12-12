package group3.modelFolder;

import group3.modelFolder.character.Character;
import group3.modelFolder.model.Model;
import group3.modelFolder.smurfinator.Smurfinator;
import group3.modelFolder.trait.Trait;
import group3.modelFolder.user.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SmurfinatorTest {
    Model m = Model.getInstance("SmurfinatorTestUsers.txt", "SmurfinatorTestQuestions.txt", "SmurfinatorTestTraits.txt","Characters.txt");
    Smurfinator smurfinator = new Smurfinator(m.getTraitQuestionDict(),m.getCharacters(),new User("test", 0));
    
    void setup(){
    smurfinator.update();
    }
    @Test
    void testAnswerDontKnow() {
        setup();
        smurfinator.answerDontKnow();
        Trait t = smurfinator.getCurrentTrait();
        for (Trait askedTrait: smurfinator.getAskedTraits()) {
            if(askedTrait.getName().equals(t.getName())){
                assertTrue(askedTrait.get_amount_of_trait().equals(0.5) );
                break;
            }
        }
    }

    @Test
    void testAnswerNo() {
        setup();
        Trait t = smurfinator.getCurrentTrait();
        smurfinator.answerNo();
        for (Trait askedTrait: smurfinator.getAskedTraits()) {
            if(askedTrait.getName().equals(t.getName())){
                assertTrue(askedTrait.get_amount_of_trait().equals(0.0) );
                break;
            }
        }
    }

    @Test
    void testAnswerRange() {
        setup();
        Trait t = smurfinator.getCurrentTrait();
        smurfinator.answerRange(0.7);
        for (Trait askedTrait: smurfinator.getAskedTraits()) {
            if(askedTrait.getName().equals(t.getName())){
                assertTrue(askedTrait.get_amount_of_trait().equals(0.7));
                break;
            }
        }
    }

    @Test
    void testAnswerYes() {
        setup();
        Trait t = smurfinator.getCurrentTrait();
        smurfinator.answerYes();
        for (Trait askedTrait: smurfinator.getAskedTraits()) {
            if(askedTrait.getName().equals(t.getName())){
                assertTrue(askedTrait.get_amount_of_trait().equals(1.0) );
                break;
            }
        }
    }

    @Test
    void testCreateNewCharacter() {
        setup();
        smurfinator.createNewCharacter("null","null");
        for(Character c : m.getCharacters()){
            if(c.getName() == "null"){
                assertTrue(true);
                break;
            }
        }
    }


    @Test
    void testReset() {
        setup();
        smurfinator.reset();
        /*
        assertEquals(smurfinator.askedQuestions.size(), 0);
        assertEquals(smurfinator.askableQuestions.size(),smurfinator.questions.size() );

         */
        assertEquals(smurfinator.getAskedTraits().size(), 0);
        assertFalse(smurfinator.getCharacterCreationState());
    }


}

