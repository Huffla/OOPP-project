package group3.modelFolder;

public class TraitIntitializer {
    TraitDatabaseHandler db;
    public TraitIntitializer(String s){
        db = new TraitDatabaseHandler(s);
        
        
    }

    public void initialize(){
        db.clearList();
        
    }
}
