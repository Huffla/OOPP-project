package group3.modelFolder;
import java.io.Serializable;
import java.util.ArrayList;

public class User implements Serializable{
    public String name;
    private ArrayList<Character> contributions;
    private int amountOfContributions;

    public ArrayList<Character> getContributions() {
        return contributions;
    }
    public int getAmountOfContributions() {
        return amountOfContributions;
    }


    public User(String s){
        name = s;
        //contributions =
        //amountOfContributions = contributions.size();
    }
}
