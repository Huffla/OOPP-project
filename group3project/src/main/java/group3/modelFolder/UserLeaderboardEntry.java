package group3.modelFolder;

public class UserLeaderboardEntry implements LeaderboardEntry{

        private User user;
        private int sortValue;
        private String name;

        // Class representing a user in the leaderboard
        public UserLeaderboardEntry(User user, int sortValue){
            this.user = user;
            this.name = user.getName();
            this.sortValue = sortValue;
        }

        public String getName(){
            return name;
        }

        public int getSortValue(){
            return sortValue;
        }
}
