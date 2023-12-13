package group3.modelFolder.leaderboard;

import group3.modelFolder.leaderboard.category.Category;

import java.util.ArrayList;

public class Leaderboard implements LeaderboardInterface{

    private final ArrayList<Category> categories;
    private Category category;

    final int characterLeaderboardCode = 0;
    final int userLeaderboardCode = 1;

    // List of observers
    private ArrayList<LeaderboardObserver> leaderboardObservers = new ArrayList<>();

    // Constructor
    public Leaderboard(ArrayList<Category> categories){
        this.categories = categories;
    }

    // Add an observer to the list of observers
    public void addObserver(LeaderboardObserver leaderboardObserver){
        leaderboardObservers.add(leaderboardObserver);
    }

    // Make the initial call to the leaderboard
    public void makeInitialCall(){
        category = categories.get(0);
        update();
    }

    // Send the leaderboard to the observers
    public void sendLeaderboard(){
        for(LeaderboardObserver leaderboardObserver: leaderboardObservers){
            leaderboardObserver.updateLeaderboardField(category);
        }
    }

    // Update the leaderboard
    public void update(){
        updateLeaderboard();
        sendLeaderboard();
    }

    // Switch category to display based on index in categories
    public void switchCategory(int i){
        category = categories.get(i);
        updateLeaderboard();
        sendLeaderboard();
    }

    // update the order of objects to be displayed as the leaderboard
    public void updateLeaderboard() {
            category.sort();
    }

    // return the leaderboard
    public ArrayList<LeaderboardEntry> getLeaderboard(){
        return new ArrayList<>(category.getList());
    }
}
