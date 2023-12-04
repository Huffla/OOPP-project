package group3.modelFolder;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public abstract class DatabaseHandler {
    protected ArrayList<Object> data_list;
    File obj;
    String fileName;
    
    public DatabaseHandler(String fileName){
        this.fileName = fileName;
        obj = new File(this.fileName);
        attemptLoadFile();
        
        
        
    }
        // Has to have two cases to know if it has to write to a new file.
    private void attemptLoadFile() {
        try {
            data_list = loadFromFile();
        } catch (Exception e) {
            System.out.println("No file found");
            System.out.println("File created!");
            data_list = new ArrayList();
            
            writeToFile();
            
        }
    }

    protected void addToList(Object data){
        data_list.add(data);
        
            writeToFile();
        
    }
    protected void writeToFile() {
        try {
            File obj = new File(fileName);
            ObjectOutputStream objout;
            objout = new ObjectOutputStream(new FileOutputStream(obj));
            objout.writeObject(data_list);
            objout.close();
        } catch (IOException e) {
            
            e.printStackTrace();
        }
    }
        
    
    
    private ArrayList<Object> loadFromFile() throws IOException, ClassNotFoundException{
    
        ObjectInputStream objin = new ObjectInputStream(new FileInputStream(obj));
        ArrayList<Object> data;
        data = (ArrayList<Object>) objin.readObject();
        objin.close();
        return data;
    
    }
    public void clearList(){
        data_list.clear();
        writeToFile();
    }

    
    
    
}
