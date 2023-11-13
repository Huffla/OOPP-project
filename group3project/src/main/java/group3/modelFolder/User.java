package group3.modelFolder;

public class User {
    private String name;
    private int hashedPassword;

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
