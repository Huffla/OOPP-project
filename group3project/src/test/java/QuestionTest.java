import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import group3.modelFolder.question.Question;

public class QuestionTest {
    private Question question;

    @BeforeEach
    public void setUp() {
        question = new Question("TestQuestion");
    }

    @Test
    public void testGetQuestionText() {
        assertEquals("TestQuestion", question.getQuestionText());
    }
}