package group3.modelFolder.user;

import group3.modelFolder.character.Character;

import java.io.Serializable;

import java.util.ArrayList;

public class User implements Serializable{
    private String name;
    private int hashedPassword;

    /**
     * @param name Takes the name of the user
     * @param hashedPassword Takes a hashedpassword and saves it to a user
     */
    private ArrayList<Character> contributions;
    private int amountOfContributions = 0;

    public ArrayList<Character> getContributions() {
        return contributions;
    }
    public int getAmountOfContributions() {
        return amountOfContributions;
    }
    public void increaseContributions(){
        amountOfContributions++;
    }


    public User(String name, int hashedPassword){
        this.name = name;
        this.hashedPassword = hashedPassword;

    }
    public String getName(){
        return name;
    }
    public int getHashPassword(){
        return hashedPassword;
    }
    public boolean equals(User u2){
        if(u2.name.equals(this.name)  && this.hashedPassword == u2.hashedPassword) return true;
        return false;
        //contributions =
        //amountOfContributions = contributions.size();
    }
}