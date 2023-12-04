package group3.modelFolder;

import java.util.ArrayList;


public abstract class Category{
    String name;
    protected ArrayList<LeaderboardEntry> list;

    public int length() {
        return list.size();
    }
    public String getName(){
        return name;
    }
    public LeaderboardEntry get(int index) {
        return list.get(index);
    }
    public LeaderboardEntry set(int index, LeaderboardEntry object ) {
        return list.set(index,object);
    }
    public int getSortValue(int index){
    return 0;
    }
    public void sort(){
        int n = this.length();
        for (int i = 1; i < n; ++i) {
            int j = i - 1;
            LeaderboardEntry key = this.get(i);
            LeaderboardEntry key2 = this.get(j);
            while (j >= 0 && key2.getSortValue() > key.getSortValue()) {
                this.set(j + 1, this.get(j));
                j = j - 1;
            }
            this.set(j + 1, key);
        }            
        }
}
