package group3.modelFolder;

import java.util.ArrayList;

public class Model {
    ArrayList<User> user_list;
    ArrayList<Trait> traits_list;
    ArrayList<Character> character_list;
    ArrayList<Question> question_list;
    UserDatabaseHandler user_handler = new UserDatabaseHandler();
    TraitHandler trait_handler = new TraitHandler();
    CharacterDatabaseHandler character_handler = new CharacterDatabaseHandler();
    QuestionHandler question_handler = new QuestionHandler();
    public Model(){
        user_list = user_handler.getUsers();
        traits_list = trait_handler.getTraits();
        character_list = character_handler.getCharacters();
        question_list = question_handler.getQuestions();
        

    }

    public ArrayList<User> getUsers(){
        return user_list;
    }
    public ArrayList<Trait> getTraits(){
        return traits_list;
    }
    public ArrayList<Character> getCharacters(){
        return character_list;
    }
    public ArrayList<Question> getQuestions(){
        return question_list;
    }

    public void setUsers(ArrayList<User> ulist){
        for(User u: ulist){
            user_handler.addToList(u);
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
    
}
