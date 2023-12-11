import group3.LeaderboardController;
import group3.modelFolder.Character;
import org.junit.jupiter.api.Test;
import group3.modelFolder.*;


import static org.junit.jupiter.api.Assertions.assertEquals;


public class LeaderboardTest{

    UserDatabaseHandler dh = new UserDatabaseHandler("UsersTest.txt");
    Model tmodel = Model.getInstance("UserTest.txt","Questions.txt","Traits.txt","Characters.txt");
    Leaderboard leaderboard = tmodel.getLeaderboard();
    LeaderboardController leaderboardController = LeaderboardController.getInstance(leaderboard);

    @Test
    void leaderboardTest(){
        // leaderboard test cool 👍
    }
}
