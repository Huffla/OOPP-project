package group3.modelFolder;

import java.io.Serializable;

public class User implements Serializable{
    private String name;
    private int hashedPassword;

    /**
     * @param name Takes the name of the user
     * @param hashedPassword Takes a hashedpassword and saves it to a user
     */
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
    }
}
