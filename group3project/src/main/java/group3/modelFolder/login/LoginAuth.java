package group3.modelFolder.login;



import group3.modelFolder.user.User;

import java.util.ArrayList;


public class LoginAuth {
    private String name;
    private int hashedPassword;
    private ArrayList<User> userDatabase;
    /**
     * @param name Name of user
     * @param password  a password that is not hashed.
     * 
     */
    
    public LoginAuth(ArrayList<User> db){
        userDatabase = db;

    }

    /**
     * @param name Takes tha name of the user
     * @param password Takes a unhashed password 
     * @return The user if the password and name matches, Throws exception if it does not
     * @throws NoSuchFieldException
     */
    public User attemptLogin(String name, String password) throws  NoSuchFieldException{
        User user;
        this.name = name;
        this.hashedPassword = password.hashCode();

        /*
         * Kolla med databas
         * If(kontofinns och lösenord stämmer) return User;
         * else if (konto finns men lösenord stämmer inte) throw new InvalidPasswordException();
         * else throw new NoSuchFieldException();
         */
        for(User u: userDatabase){
            if (u.getName().equals(name)){
                if(u.getHashPassword() == hashedPassword){
                    return u;
                  } else{
                     throw new NoSuchFieldException("Wrong password");
                 }
                
            }
        }
        throw new NoSuchFieldException("No account");
        
        
        
    }
}
