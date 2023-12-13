package group3.modelFolder.leaderboard.category;

import group3.modelFolder.leaderboard.LeaderboardEntry;

import java.util.ArrayList;


public abstract class Category{
    protected String name;
    protected int categoryCode;
    protected ArrayList<LeaderboardEntry> list;

    public String getName(){
        return name;
    }

    public ArrayList<LeaderboardEntry> getList() {
        return list;
    }

    public LeaderboardEntry get(int index) {
        return list.get(index);
    }
    public LeaderboardEntry set(int index, LeaderboardEntry object ) {
        return list.set(index,object);
    }
    public void sort(){
        int n = this.list.size();
        for (int i = 1; i < n; ++i) {
            int j = i - 1;
            LeaderboardEntry key = this.list.get(i);
            LeaderboardEntry key2 = this.list.get(j);
            while (j >= 0 && key2.getSortValue() > key.getSortValue()) {
                this.list.set(j + 1, this.list.get(j));
                j = j - 1;
            }
            this.list.set(j + 1, key);
        }
    }
}
