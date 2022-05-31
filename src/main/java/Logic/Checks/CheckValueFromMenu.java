package Logic.Checks;

import Print.PrintInformation;

import java.util.Scanner;

public class CheckValueFromMenu {

    public static int checkValue(Scanner scanner) {         // проверка введенного значения для основного меню

        int enteredValue = 0;
        boolean isValid = false;

        while (!isValid) {
            while (!scanner.hasNextInt()) {         // проверка на ввод целочисленного числа
                PrintInformation.printValueInformation();
                scanner.nextLine();
            }
            enteredValue = scanner.nextInt();
            if (enteredValue >= 6 || enteredValue <= 0) {            // проверка числа, если число больше, чем есть в основном меню
                PrintInformation.printBigValueInformation();
            } else {
                isValid = true;
            }
        }
        return enteredValue;
    }

    public static int checkValueForChangeTask(Scanner scanner) {         // проверка введенного значения для выбора изменения таска

        int enteredValue = 0;
        boolean isValid = false;

        while (!isValid) {
            while (!scanner.hasNextInt()) {         // проверка на ввод целочисленного числа
                PrintInformation.printValueInformation();
                scanner.nextLine();
            }
            enteredValue = scanner.nextInt();
            if (enteredValue > 5 || enteredValue <= 0) {            // проверка числа, если число больше, чем есть в перечислении
                PrintInformation.printBigValueInformation();
            } else {
                isValid = true;
            }
        }
        return enteredValue;
    }
}
