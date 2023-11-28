package group3.modelFolder;

import java.io.Serializable;

public class Trait implements Serializable{

    private String name;
    private Double amountOfTrait;

    public Trait(String name, Double amount){
        this.name = name;
        amountOfTrait = amount;
    }

    public void setName(String name) {
        this.name = name;

    }

    public String getName(){
        return this.name;
    }

    public Double get_amount_of_trait(){
        return amountOfTrait;
    }
}