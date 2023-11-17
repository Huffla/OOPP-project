package group3.modelFolder;

import java.util.ArrayList;

public class TraitHandler extends DatabaseHandler{

    public TraitHandler() {
        super("Traits.txt");

    }
    public ArrayList<Trait> getTraits(){
        ArrayList<Trait> traits = new ArrayList<>();
        for(Object elem: data_list){
            traits.add((Trait) elem);
        }
        return traits;
    }


}
