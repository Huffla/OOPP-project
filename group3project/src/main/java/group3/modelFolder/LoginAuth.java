package group3.modelFolder;



import java.util.Hashtable;


public class LoginAuth {
    private String name;
    private int hashedPassword;
    private Hashtable<String,User> userDatabase;
    /**
     * @param name Name of user
     * @param password  a password that is not hashed.
     * 
     */
    
    public LoginAuth(){
        userDatabase = new Hashtable<>();

    }

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
        
        if(userDatabase.containsKey(name)){
            user = userDatabase.get(name);
            if(user.getHashPassword() == hashedPassword){
                return user;
            } else{
                throw new NoSuchFieldException("Wrong password");
            }
        }else{
            throw new NoSuchFieldException("No account");
        }
        
        
    }
}
