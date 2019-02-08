package Budget;

import java.util.Scanner;

import static Budget.BudgetMenus.printMainMenu;

public class BudgetMain {
    public static void init(){
        printMainMenu();
        while(true){
            switch (new Scanner(System.in).next().charAt(0)){
                case  '1': break;
                case  '2': break;
                case  '3': break;
                case  '4': break;
                case  '5': break;
                case  'b': break;
                case  'x': System.exit(0);
                default: System.out.println("Unrecognised input!"); printMainMenu();
            }
        }
    }
}
