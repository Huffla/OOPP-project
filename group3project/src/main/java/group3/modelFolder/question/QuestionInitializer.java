package group3.modelFolder.question;

import group3.modelFolder.database.QuestionDatabaseHandler;

public class QuestionInitializer {
    QuestionDatabaseHandler db;
    public QuestionInitializer(String s){
        db = new QuestionDatabaseHandler(s);


    }

    public void initialize(){
        db.clearList();

        db.createMultipleChoiceQuestion("Is your character a girl?");
        db.createMultipleChoiceQuestion("Is your character male?");
        db.createMultipleChoiceQuestion("Is your character strong?");
        db.createMultipleChoiceQuestion("Is your character old?");
        db.createMultipleChoiceQuestion("Is your character smart?");
        db.createMultipleChoiceQuestion("Is your character very young?");
        db.createMultipleChoiceQuestion("Is your character nice to others?");
        db.createMultipleChoiceQuestion("Is your character good looking?");
        db.createMultipleChoiceQuestion("Does your character have anger issues?");
        db.createMultipleChoiceQuestion("Does your character make a lot of mistakes?");
        db.createMultipleChoiceQuestion("Is your character considered calm?");
        db.createMultipleChoiceQuestion("Is your character an animal?");
        db.createMultipleChoiceQuestion("Does your character wear glasses?");
        db.createMultipleChoiceQuestion("Does your character have facial hair");
        db.createMultipleChoiceQuestion("Does your character wear a hat?");
        db.createRangeQuestion("How likely is your character to drive drunk when drinking fermented hallonsaft?");
        db.createMultipleChoiceQuestion("Does your character care more for themselves than others?");
        db.createMultipleChoiceQuestion("Is your character considered funny?");
        db.createMultipleChoiceQuestion("Does your character possess magical abilities?");
        db.createMultipleChoiceQuestion("Is your character creative?");
        db.createMultipleChoiceQuestion("Does your character have blond hair?");
        db.createMultipleChoiceQuestion("Does your character have freckles?");
        db.createMultipleChoiceQuestion("Is your character evil?");
        db.createMultipleChoiceQuestion("Does your character have long hair?");
        db.createMultipleChoiceQuestion("Is your character tattoed?");
        db.createMultipleChoiceQuestion("Does your character wear a jacket?");
        db.createMultipleChoiceQuestion("Is your character ugly?");
        db.createMultipleChoiceQuestion("Does your character have black hair?");
        db.createMultipleChoiceQuestion("Is your character considered a monster?");
        db.createMultipleChoiceQuestion("Is your character human?");
        db.createMultipleChoiceQuestion("Does your character like to play around?");
        db.createMultipleChoiceQuestion("Does your character like to invent things?");
        db.createMultipleChoiceQuestion("Can your character be considered proficient with the pen?");
        db.createMultipleChoiceQuestion("Does your character like to cook food?");
        db.createMultipleChoiceQuestion("Can your character be considered a leader?");
        db.createMultipleChoiceQuestion("Is your character indulging in the arts of alchemy?");
        db.createMultipleChoiceQuestion("Is your character a mechanical construct?");
        db.createMultipleChoiceQuestion("Has your character comitted murder?");
        db.createMultipleChoiceQuestion("Would your character be considered handy?");
        db.createMultipleChoiceQuestion("Is your character brave?");
        db.createMultipleChoiceQuestion("Is your character musical?");
        db.createMultipleChoiceQuestion("Does your character prefer the use of violence?");
        db.createMultipleChoiceQuestion("Is your character not very smart?");
        db.createMultipleChoiceQuestion("Do your character wear a skirt?");
        db.createMultipleChoiceQuestion("Do your character usually carry a weapon?");
        db.createMultipleChoiceQuestion("Is your character religious?");
        db.createMultipleChoiceQuestion("Do your character wear a dress?");
        db.createMultipleChoiceQuestion("Is your character a smurf?");







    }
}
