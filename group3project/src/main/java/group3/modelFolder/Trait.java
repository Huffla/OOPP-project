package group3.modelFolder;


public class Trait{

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