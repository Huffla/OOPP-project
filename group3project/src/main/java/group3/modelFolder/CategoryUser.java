package group3.modelFolder;

import java.util.ArrayList;

public class CategoryUser extends Category{

    public CategoryUser(ArrayList<User> list, int i) {
        this.name = "amount of contributions";
        this.list = userListToLbEList(list);
        this.categoryCode = i;
    }

    public ArrayList<LeaderboardEntry> userListToLbEList(ArrayList<User> list){
        ArrayList<LeaderboardEntry> temp = new ArrayList<>();
        for (User user : list) {
            temp.add(user);
        }
        return temp;
    }

    public ArrayList<LeaderboardEntry> getList(){
        return this.list;
    }
}