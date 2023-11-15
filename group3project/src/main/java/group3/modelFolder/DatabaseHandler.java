package group3.modelFolder;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
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

    private void attemptLoadFile() {
        try {
            data_list = loadFromFile();
        } catch (Exception e) {
            System.out.println("No file found");
            data_list = new ArrayList();
            // Has to have two cases to know if it has to write to a know file.
            try {
                writeToFile();
            } catch (IOException e1) {
                System.out.println("What da hell are you doing");
                e1.printStackTrace();
            }
        }
    }

    public void addToList(Object data){
        data_list.add(data);
        try {
            writeToFile();
        } catch (IOException e) {
            System.out.println("Writing exception");
            e.printStackTrace();
        }
        
    }
    protected void writeToFile() throws IOException{
        try {
            File obj = new File(fileName);
            ObjectOutputStream objout;
            objout = new ObjectOutputStream(new FileOutputStream(obj));
            objout.writeObject(data_list);
            objout.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
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
    public void clearList() throws IOException{
        data_list.clear();
        writeToFile();
    }

    
    
    
}
