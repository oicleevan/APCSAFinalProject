import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class FileManagement {
    public static File createValidFile(String pathname) {
        File file = new File(pathname);
        try {
            new File(pathname.split("/")[0]).mkdirs();
            file.createNewFile();
        } catch(Exception e) {
            e.printStackTrace();
        }

        return file;
    }
    
    public static void saveObjectsToFile(String filename, ArrayList<EmailAccount> arraylist) {
        if(arraylist.size() == 0) return;

        try {
            FileOutputStream file_out = new FileOutputStream(createValidFile(filename), true);
            ObjectOutputStream out = new ObjectOutputStream(file_out);
        
            for(EmailAccount e : arraylist) {
                try {
                    out.writeObject(e);
                } catch(Exception ex) {
                    ex.printStackTrace();
                }
            }
            out.close();
            file_out.close();
        } catch (IOException e) { e.printStackTrace(); }
    }

    public static ArrayList<EmailAccount> loadFromFile(String filename) {
        File file = new File(filename);
        if(!file.exists()) return new ArrayList<EmailAccount>();

        ArrayList<EmailAccount> arraylist = new ArrayList<>();
        try {
            FileInputStream file_in = new FileInputStream(file);
            ObjectInputStream in = new ObjectInputStream(file_in);
            boolean running = true;
            while(running) {
                try {
                    EmailAccount e = null;
                    try {
                        e = (EmailAccount) in.readObject();   
                    } catch (EOFException eof) { }

                    if(e != null) {
                        arraylist.add(e);
                    } else {
                        running = false;
                    }
                } catch (Exception e) { 
                    e.printStackTrace(); 
                }
            }
            file_in.close();
            in.close();
        } catch (Exception e) { e.printStackTrace(); }

        file.delete();
        return arraylist;
    }
}