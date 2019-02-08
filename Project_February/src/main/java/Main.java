import Budget.BudgetMain;
import Exam.ExamMain;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
//        if(args.length == 0) {
//            Process p = Runtime.getRuntime().exec("cmd.exe /c start java -jar " + (new File(Main.class.getProtectionDomain().getCodeSource().getLocation().getPath())).getAbsolutePath() + " cmd");
//        }

        Scanner scn = new Scanner(System.in);
        printMenu();
        while(true){
            switch (scn.next().charAt(0)) {
                case '1': BudgetMain.init();break;
                case '2': ExamMain.init(); break;
                case 'x': System.exit(0);
                default:
                    System.out.println("Unrecognised input\n");
                    printMenu();
            }
        }
    }

    private static void printMenu(){
        System.out.println("Choose which program you would like to use:");
        System.out.println("1: Budget");
        System.out.println("2: Exam grading system");
        System.out.println("x - exit");
    }
}
