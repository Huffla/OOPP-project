package group3.modelFolder.trait;

import java.io.Serializable;
import java.util.ArrayList;

public class Trait implements Serializable{

    private String name;
    private Double amountOfTrait;
    public ArrayList<String> opppositeTraits;


    public Trait(String name, Double amount, ArrayList<String> oppositeTraits){
        this.name = name;
        amountOfTrait = amount;
        this.opppositeTraits = oppositeTraits;

    }

    public ArrayList<String> getOppositeTraits(){
        return opppositeTraits;
    }
    public void setName(String name) {
        this.name = name;

    }

    public Trait copy(){
        Trait tempTrait = new Trait(this.name,this.amountOfTrait, this.opppositeTraits);
        return tempTrait;
    }

    public Trait copy(double d){
        Trait tempTrait = new Trait(this.name, d, this.opppositeTraits);
        return tempTrait;
    }

    public String getName(){
        return this.name;
    }

    public Double get_amount_of_trait(){
        return amountOfTrait;
    }
}