import group3.modelFolder.character.Character;
import group3.modelFolder.leaderboard.UserLeaderboardEntry;
import group3.modelFolder.leaderboard.CharacterLeaderboardEntry;
import group3.modelFolder.leaderboard.category.CategoryUser;
import group3.modelFolder.leaderboard.category.CategoryCharacter;
import group3.modelFolder.user.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class LeaderboardCategoryTest {
    private ArrayList<UserLeaderboardEntry> userEntries;
    private ArrayList<CharacterLeaderboardEntry> characterEntries;
    private CategoryUser categoryUser;
    private CategoryCharacter categoryCharacter;

    @BeforeEach
    public void setUp() {
        userEntries = new ArrayList<>();
        characterEntries = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            userEntries.add(new UserLeaderboardEntry(new User("name",0), i));
            characterEntries.add(new CharacterLeaderboardEntry(new Character(null,"name1","2"), i));
        }
        categoryUser = new CategoryUser(userEntries, 0);
        categoryCharacter = new CategoryCharacter(characterEntries, 1);
    }

    @Test
    public void testCategoryUser() {
        assertEquals("amount of contributions", categoryUser.getName());
        assertEquals(userEntries, categoryUser.getList());

    }

    @Test
    public void testCategoryCharacter() {
        assertEquals("amount of times guessed", categoryCharacter.getName());
        assertEquals(characterEntries, categoryCharacter.getList());

    }

    @Test
    public void testSort() {
        categoryUser.sort();
        categoryCharacter.sort();
        for (int i = 0; i < 4; i++) {
            assertTrue(categoryUser.get(i).getSortValue() <= categoryUser.get(i + 1).getSortValue());
            assertTrue(categoryCharacter.get(i).getSortValue() <= categoryCharacter.get(i + 1).getSortValue());
        }
    }
}