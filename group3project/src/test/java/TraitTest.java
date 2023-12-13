import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import group3.modelFolder.trait.Trait;
import java.util.ArrayList;

public class TraitTest {
    private Trait trait;

    @BeforeEach
    public void setUp() {
        ArrayList<String> oppositeTraits = new ArrayList<>();
        oppositeTraits.add("Trait1");
        oppositeTraits.add("Trait2");
        trait = new Trait("TestTrait", 0.0, oppositeTraits);
    }

    @Test
    public void testGetName() {
        assertEquals("TestTrait", trait.getName());
    }

    @Test
    public void testGetAmountOfTrait() {
        assertEquals(0.0, trait.get_amount_of_trait());
    }

    @Test
    public void testGetOppositeTraits() {
        assertNotNull(trait.getOppositeTraits());
        assertEquals(2, trait.getOppositeTraits().size());
    }

    @Test
    public void testSetName() {
        trait.setName("NewTrait");
        assertEquals("NewTrait", trait.getName());
    }

    @Test
    public void testCopy() {
        Trait copiedTrait = trait.copy();
        assertEquals(trait.getName(), copiedTrait.getName());
        assertEquals(trait.get_amount_of_trait(), copiedTrait.get_amount_of_trait());
        assertEquals(trait.getOppositeTraits(), copiedTrait.getOppositeTraits());
    }

    @Test
    public void testCopyWithAmount() {
        Trait copiedTrait = trait.copy(1.0);
        assertEquals(trait.getName(), copiedTrait.getName());
        assertEquals(1.0, copiedTrait.get_amount_of_trait());
        assertEquals(trait.getOppositeTraits(), copiedTrait.getOppositeTraits());
    }
}