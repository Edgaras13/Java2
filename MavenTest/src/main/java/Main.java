import com.github.javafaker.Faker;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        if(args.length == 0) {
            Process p = Runtime.getRuntime().exec("cmd.exe /c start java -jar " + (new File(Main.class.getProtectionDomain().getCodeSource().getLocation().getPath())).getAbsolutePath() + " cmd");
        } else {
            //code to be executed
        }
        int k = new Scanner(System.in).nextInt();

        for (int i = 0; i < k; i++){
            System.out.println(new Faker().dragonBall().character());
        }
    }
}
