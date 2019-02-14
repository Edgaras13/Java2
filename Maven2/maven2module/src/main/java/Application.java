import org.apache.commons.codec.digest.DigestUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) throws IOException {
        File file = new File("D:\\Projects\\Java2\\Maven2\\maven2module\\src\\main\\java\\UserInfoFile.txt");
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
        if (!file.exists()) {
            file.createNewFile();
        }

        Scanner scn = new Scanner(System.in);

        printMenu();

        while (true) {
            switch (scn.next().charAt(0)){
                case '1': login(bufferedReader); break;
                case '2': register(bufferedWriter, bufferedReader); break;
                case 'x': System.exit(0);
                default: System.out.println("Unrecognized input!\n"); printMenu();
            }
        }
    }

    private static void printMenu(){
        System.out.println("1: Login");
        System.out.println("2: Register");
        System.out.println("X: Exit");
    }

    private static void register(BufferedWriter bufferedWriter, BufferedReader bufferedReader){
        Scanner scn = new Scanner(System.in);
        List<String> list = new ArrayList<String>();
        String line, userName, password;
        int count = 1;
        try {
            while ((line = bufferedReader.readLine()) != null) {
                if (count++ % 2 != 0) {
                    list.add(line);
                }
                count++;
            }
        }
        catch (IOException e){
            System.out.println("IO exception!");
        }

        System.out.println("Enter a username:");
        userName = scn.next();

        while(true) {
            if (list.stream().noneMatch(user -> user.equals(userName))){
                try {
                    bufferedWriter.write(userName + "\n");
                }
                catch (IOException e){
                    System.out.println("IO exception!");
                }
                break;
            }
            else{
                System.out.println("Username taken! Please try another one\n");
                System.out.println("Enter a username:");
                userName = scn.next();
            }
        }
    }

    private static void login(BufferedReader bufferedReader){

    }
}
