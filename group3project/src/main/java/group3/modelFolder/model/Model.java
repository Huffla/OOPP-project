package group3.modelFolder.model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;

import group3.modelFolder.login.LoginModel;
import group3.MainMenuWindowHandler;
import group3.modelFolder.character.Character;
import group3.modelFolder.character.CharacterInitializer;
import group3.modelFolder.compendium.Compendium;
import group3.modelFolder.database.CharacterDatabaseHandler;
import group3.modelFolder.database.QuestionDatabaseHandler;
import group3.modelFolder.database.TraitDatabaseHandler;
import group3.modelFolder.database.UserDatabaseHandler;
import group3.modelFolder.leaderboard.*;
import group3.modelFolder.leaderboard.category.Category;
import group3.modelFolder.leaderboard.category.CategoryCharacter;
import group3.modelFolder.leaderboard.category.CategoryUser;
import group3.modelFolder.login.LoginAuth;
import group3.modelFolder.question.Question;
import group3.modelFolder.question.QuestionInitializer;
import group3.modelFolder.smurfinator.Smurfinator;
import group3.modelFolder.trait.Trait;
import group3.modelFolder.trait.TraitIntitializer;
import group3.modelFolder.user.User;

public class Model {
    ArrayList<User> user_list;
    ArrayList<Trait> traits_list;
    ArrayList<Character> character_list;
    UserDatabaseHandler user_handler;
    TraitDatabaseHandler trait_handler;
    CharacterDatabaseHandler character_handler;
    QuestionDatabaseHandler question_handler;
    LoginAuth loginAuth;
    QuestionInitializer qi;
    TraitIntitializer ti;
    CharacterInitializer ci;
    private CategoryCharacter categoryCharacter;
    private CategoryUser categoryUser;
    private ArrayList<Category> leaderboardCategories = new ArrayList<>();
    private Smurfinator smurfinator;
    private Leaderboard leaderboard;
    Dictionary<Trait, Question> traitQuestionDict = new Hashtable<>();
    private LoginModel loginmodel;
    private static Model instance;
    private User loggedInUser;
    private Compendium compendium = new Compendium();

    MainMenuWindowHandler mainmenucontroller;

    // TODO fixa att smurfinator bara körs om man e inloggad, sätter user till null
    // så länge,
    // Ex genom att ta bort mycker från konstruktorn och göra så att smurfinator
    // skapas när man klickar på
    // smurfinator, vilket men enbart kan efter att man är inloggad. Första scenen
    // bör vara logga in sidan.
    private Model(String user_file_name, String questions_file_name, String traits_file_name,
            String characters_file_name) {
        user_handler = new UserDatabaseHandler(user_file_name);
        question_handler = new QuestionDatabaseHandler(questions_file_name);
        trait_handler = new TraitDatabaseHandler(traits_file_name);
        character_handler = new CharacterDatabaseHandler(characters_file_name);
        ti = new TraitIntitializer(traits_file_name);
        ti.initialize();
        qi = new QuestionInitializer(questions_file_name);
        qi.initialize(); // initializes the question database with questions and their corresponding
                         // trait, remove if you do not want to create new each time
        ci = new CharacterInitializer();
        ci.intialize();
        user_list = user_handler.getUsers();
        traits_list = trait_handler.getTraits();
        character_list = character_handler.getCharacters();
        categoryCharacter = new CategoryCharacter(initiateCharacterLeaderboard(), leaderboardCategories.size());
        leaderboardCategories.add(categoryCharacter);
        categoryUser = new CategoryUser(initiateUserLeaderboard(), leaderboardCategories.size());
        leaderboardCategories.add(categoryUser);

        compendium = new Compendium();
        loginAuth = new LoginAuth(user_handler.getUsers());
        initializeDict(question_handler.getQuestions());
        // TODO current user
        loginmodel = new LoginModel(user_handler);
        smurfinator = new Smurfinator(traitQuestionDict, character_list, null);
        leaderboard = new Leaderboard(leaderboardCategories);
    }

    private ArrayList<CharacterLeaderboardEntry> initiateCharacterLeaderboard() {
        ArrayList<CharacterLeaderboardEntry> temp = new ArrayList<>();
        for (Character c : character_list) {
            temp.add(new CharacterLeaderboardEntry(c, c.getGuessedAmount()));
        }
        return temp;
    }

    private ArrayList<UserLeaderboardEntry> initiateUserLeaderboard() {
        ArrayList<UserLeaderboardEntry> temp = new ArrayList<>();
        for (User u : user_list) {
            temp.add(new UserLeaderboardEntry(u, u.getAmountOfContributions()));
        }
        return temp;
    }

    public Compendium getCompendium() {
        return compendium;
    }

    public Dictionary<Trait, Question> getTraitQuestionDict() {
        return traitQuestionDict;
    }

    public static Model getInstance(String user_file_name, String questions_file_name, String traits_file_name,
            String characters_file_name) {
        if (instance == null) {
            instance = new Model(user_file_name, questions_file_name, traits_file_name, characters_file_name);
        }
        return instance;
    }

    public void setCurrentUser(User u) {
        loggedInUser = u;
        
    }

    public void setMainMenuController(MainMenuWindowHandler m) {
        mainmenucontroller = m;
    }

    // initializesDictionary of Traits as keys and questions as values.
    private void initializeDict(ArrayList<Question> questions) {
        if (questions.size() != traits_list.size()) {
            System.out.println("Question and trait lists are not of the same length");
            System.exit(0);
        }
        for (int i = 0; i < questions.size(); i++) {
            traitQuestionDict.put(traits_list.get(i), questions.get(i));
        }

    }

    public Smurfinator getSmurfinator() {
        return smurfinator;
    }

    // returns the initiated leaderboard object
    public Leaderboard getLeaderboard() {
        return leaderboard;
    }

    public LoginModel getLoginModel() {
        return loginmodel;
    }

    // returns the list of users
    public ArrayList<User> getUsers() {
        return user_list;
    }

    public ArrayList<Trait> getTraits() {
        return traits_list;
    }

    // returns the list of characters
    public ArrayList<Character> getCharacters() {
        return character_list;
    }

    public ArrayList<Category> getLeaderboardCategories() {
        return leaderboardCategories;
    }

    // add a list of users to the database
    public void addUsers(ArrayList<User> ulist) {
        for (User u : ulist) {
            user_handler.addUser(u);
        }
        user_list = user_handler.getUsers();
    }

    public void setUser(User u) {
        loggedInUser = u;
    }
    

    public void setCharacters(ArrayList<Character> clist) {
        for (Character c : clist) {
            character_handler.addToList(c);
        }
        character_list = character_handler.getCharacters();
    }

    public void addCharacter(Character c) {
        character_handler.addToList(c);
        character_list = character_handler.getCharacters();
    }

    // add a user to the database
    public void addUser(User u) {
        user_handler.addUser(u);
        user_list = user_handler.getUsers(); // should not matter since the arrayList has the same reference everywhere
    }

    // clears the list of users
    public void clearUsers() {
        try {
            user_handler.clearList();
        } catch (Exception e) {
            System.out.println("Could not clear list");
        }

    }

    public void addTraitWithQuestion(Question q, Trait t) {
        question_handler.addQuestion(q);
        trait_handler.addTrait(t);
        traitQuestionDict.put(t, q);

    }

    // removes a user object from the list of users
    public void removeUser(User u) {
        try {
            user_handler.removeUser(u);
        } catch (IOException e) {
            System.out.println("IO exception");
            e.printStackTrace();
        }
    }

}