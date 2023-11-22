package group3.modelFolder;

import java.util.ArrayList;

public class TraitDatabaseHandler extends DatabaseHandler{

    public TraitDatabaseHandler(String s) {
        super(s);

    }
    public ArrayList<Trait> getTraits(){
        ArrayList<Trait> traits = new ArrayList<>();
        for(Object elem: data_list){
            traits.add((Trait) elem);
        }
        return traits;
    }


}
