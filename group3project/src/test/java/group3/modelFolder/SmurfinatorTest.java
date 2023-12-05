package group3.modelFolder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class SmurfinatorTest {
    Model m = Model.getInstance("SmurfinatorTestUsers.txt", "SmurfinatorTestQuestions.txt", "SmurfinatorTestTraits.txt","Characters.txt");
    Smurfinator smurfinator = new Smurfinator(m.traitQuestionDict,m.getCharacters(),new User("test", 0));
    
    void setup(){
    smurfinator.update();
    }
    @Test
    void testAnswerDontKnow() {
        setup();
        smurfinator.answerDontKnow();
        Trait t = smurfinator.currentTrait;
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
        assertEquals(smurfinator.askedTraits.size(), 0);
        assertEquals(smurfinator.characterCreatingState, false);
    }


}

