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
        mkdirs(pathname);
        try {
            file.createNewFile();
        } catch(Exception e) {
            e.printStackTrace();
        }

        return file;
    }
    
    public static void mkdirs(String path) {
        String[] words = path.split("/");
        String directory_path = "";
        for(int i = 0; i < words.length-1; i++) {
            directory_path += words[i] + "/";
        }

        new File(directory_path).mkdirs();
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
        } catch (IOException e) { 
            e.printStackTrace();
            Logging.warn("Failed to save to file");
        }
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
                    Logging.warn("Failed to load from file");
                }
            }
            file_in.close();
            in.close();
        } catch (Exception e) { e.printStackTrace(); }

        file.delete();
        return arraylist;
    }
}