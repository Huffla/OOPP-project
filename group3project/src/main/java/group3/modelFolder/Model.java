package group3.modelFolder;

import java.io.IOException;
import java.util.ArrayList;

public class Model {
    ArrayList<User> user_list;
    ArrayList<Trait> traits_list;
    ArrayList<Character> character_list;
    ArrayList<Question> question_list;
    UserDatabaseHandler user_handler;
    TraitDatabaseHandler trait_handler;
    CharacterDatabaseHandler character_handler;
    QuestionDatabaseHandler question_handler;
    LoginAuth loginAuth;
    QuestionInitializer qi;
    TraitIntitializer ti;
    public Smurfinator smurfinator;

    private static Model instance;
    //TODO fixa att smurfinator bara körs om man e inloggad, sätter user till null så länge
    private Model(String user_file_name, String questions_file_name, String traits_file_name,String characters_file_name){
        user_handler = new UserDatabaseHandler(user_file_name);
        question_handler  = new QuestionDatabaseHandler(questions_file_name);
        trait_handler =  new TraitDatabaseHandler(traits_file_name);
        character_handler = new CharacterDatabaseHandler(characters_file_name);
        ti = new TraitIntitializer(traits_file_name);
        ti.initialize();
        qi = new QuestionInitializer(questions_file_name);
        qi.initialize(); // initializes the question database with questions and their corresponding trait, remove if you do not want to create new each time
        
        user_list = user_handler.getUsers();
        traits_list = trait_handler.getTraits();
        character_list = character_handler.getCharacters();
        question_list = question_handler.getQuestions();
        loginAuth = new LoginAuth(user_handler.getUsers());
        
        smurfinator = new Smurfinator(question_list, traits_list, character_list, null); //TODO current user

    }

    public static Model getInstance(String user_file_name,String questions_file_name, String traits_file_name,String characters_file_name){
        if (instance == null){
            instance = new Model(user_file_name,questions_file_name,traits_file_name,characters_file_name);
        }
        return instance;
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

    public void addQuestion(Question q){
        question_handler.addQuestion(q);
        question_list = question_handler.getQuestions();
    
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
