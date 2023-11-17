package group3.modelFolder;

import java.io.IOException;
import java.util.ArrayList;

public class Model {
    ArrayList<User> user_list;
    ArrayList<Trait> traits_list;
    ArrayList<Character> character_list;
    ArrayList<Question> question_list;
    UserDatabaseHandler user_handler;
    TraitHandler trait_handler = new TraitHandler();
    CharacterDatabaseHandler character_handler = new CharacterDatabaseHandler();
    QuestionHandler question_handler = new QuestionHandler();
    LoginAuth loginAuth;
    public Model(String user_file_name){
        user_handler = new UserDatabaseHandler(user_file_name);
        user_list = user_handler.getUsers();
        traits_list = trait_handler.getTraits();
        character_list = character_handler.getCharacters();
        question_list = question_handler.getQuestions();
        loginAuth = new LoginAuth(user_handler.getUsers());
        

    }
    // returns the list of users
    public ArrayList<User> getUsers(){
        return user_list;
    }
    public ArrayList<Trait> getTraits(){
        return traits_list;
    }
    // returns the list of characters
    public ArrayList<Character> getCharacters(){
        return character_list;
    }
    public ArrayList<Question> getQuestions(){
        return question_list;
    }

    // add a list of users to the database
    public void setUsers(ArrayList<User> ulist){
        for(User u: ulist){
            user_handler.addUser(u);
        }
        user_list = user_handler.getUsers();
    }

    public void setCharacters(ArrayList<Character> clist){
        for(Character c: clist){
            character_handler.addToList(c);
        }
        character_list = character_handler.getCharacters();
    }

    public void addUser(User u){
        user_handler.addToList(u);
    }
    public void addCharacter(Character c){
        character_handler.addToList(c);
        character_list = character_handler.getCharacters();
    }
    // add a user to the database
    public void setUser(User u){
        user_handler.addUser(u);
        user_list = user_handler.getUsers(); // should not matter since the arrayList has the same reference everywhere
    }
    // clears the list of users
    public void clearUsers(){
        try {
            user_handler.clearList();
        } catch (Exception e) {
            System.out.println("Could not clear list");
        }
        
    }
    // removes a user object from the list of users
    public void removeUser(User u){
        try {
            user_handler.removeUser(u);
        } catch (IOException e) {
            System.out.println("IO exception");
            e.printStackTrace();
        }
    }
    
}
