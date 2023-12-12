import group3.LeaderboardController;
import group3.modelFolder.database.UserDatabaseHandler;
import group3.modelFolder.leaderboard.Leaderboard;
import group3.modelFolder.model.Model;
import org.junit.jupiter.api.Test;


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
