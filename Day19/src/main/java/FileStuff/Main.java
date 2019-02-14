package FileStuff;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Main {
    public static void main(String[] args) {

    }

    public static void writeDirContent(String path){
        try{
            File dir = new File(path);
            if(dir.isDirectory()){
                BufferedReader reader = new BufferedReader(new FileReader(path));

            }
            else{
                throw new FileNotFoundException();
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
