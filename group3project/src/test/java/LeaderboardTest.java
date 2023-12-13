import group3.modelFolder.leaderboard.LeaderboardEntry;
import group3.modelFolder.leaderboard.UserLeaderboardEntry;
import group3.modelFolder.leaderboard.category.CategoryUser;
import group3.modelFolder.user.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import group3.modelFolder.leaderboard.Leaderboard;
import group3.modelFolder.leaderboard.category.Category;
import java.util.ArrayList;

public class LeaderboardTest {
    private Leaderboard leaderboard;
    private ArrayList<Category> categories;
    private Category category1;
    private Category category2;
    @BeforeEach
    public void setUp() {
        categories = new ArrayList<>();
        leaderboard = new Leaderboard(categories);

    }

    public void createCategories(){
        UserLeaderboardEntry entry1 = new UserLeaderboardEntry(new User("name",0),0);
        UserLeaderboardEntry entry2 = new UserLeaderboardEntry(new User("name2",0),1);
        UserLeaderboardEntry entry3 = new UserLeaderboardEntry(new User("name3",0),2);
        UserLeaderboardEntry entry4 = new UserLeaderboardEntry(new User("name4",0),3);
        UserLeaderboardEntry entry5 = new UserLeaderboardEntry(new User("name5",0),4);
        ArrayList<UserLeaderboardEntry> entries = new ArrayList<>();
        entries.add(entry1);
        entries.add(entry2);
        entries.add(entry3);
        entries.add(entry4);
        entries.add(entry5);
        category1 = new CategoryUser( entries, 0);
        category2 = new CategoryUser( entries, 1);
        categories.add(category1);
        categories.add(category2);
    }


    @Test
    public void testSwitchCategory() {
        createCategories();
        leaderboard.switchCategory(1);
        assertEquals(category2, leaderboard.getCategory());
    }


}
