import Logic.LogicMenu;
import Print.DisplayMenu;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        LogicMenu logicMenu = new LogicMenu();

        int enteredValue = 0;
        boolean isWork = true;

        DisplayMenu.printGreetings();

        while (isWork) {
            DisplayMenu.displayMenu();

            enteredValue = logicMenu.returnCheckedValue(scanner);

            switch (enteredValue) {
                case 1: logicMenu.loadTask();
                    break;
                case 2:logicMenu.addTask(scanner);
                    break;
                case 3:logicMenu.changeTask(scanner);
                    break;
                case 4: logicMenu.deleteTask(scanner);
                    break;
                case 5:
                   isWork = false;
            }
        }
        DisplayMenu.printGoodbye();
    }
}
