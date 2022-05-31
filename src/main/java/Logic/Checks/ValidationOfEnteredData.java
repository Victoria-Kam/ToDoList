package Logic.Checks;

import Print.PrintInformation;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidationOfEnteredData {


    public static int checkEnteredType(Scanner scanner) {           // проверка ввода типа задачи от пользователя

        boolean typeIsEntered = false;
        int enteredType = 0;

        while (!typeIsEntered) {
            enteredType = scanner.nextInt();
            if (ValidationOfEnteredData.checkType(enteredType)) {       // проверка введенного значения от пользователя
                typeIsEntered = true;
            } else {
                PrintInformation.printBigValueInformation();
                scanner.nextLine();
            }
            scanner.nextLine();
        }

        return enteredType;
    }

    public static String checkEnteredTitle(Scanner scanner){            // проверка ввода заголовка задачи

        boolean titleIsEntered = false;
        String title = "";

        while (!titleIsEntered) {
            title = scanner.nextLine();
            if (!title.isEmpty()) {
                titleIsEntered = true;
            } else {
                PrintInformation.printEmptyTitleInformation();
            }
        }

        return title;
    }

    public static String checkEnteredContent(Scanner scanner){          // проверка ввода самой задачи пользователя

        boolean contentIsEntered = false;

        String content = "";

        while (!contentIsEntered) {
            content = scanner.nextLine();
            if (!content.isEmpty()) {
                contentIsEntered = true;
            } else {
                PrintInformation.printEmptyTitleInformation();
            }
        }

        return content;
    }

    public static int checkEnteredStatus(Scanner scanner){           // проверка ввода статуса задачи от пользователя

        boolean statusIsEntered = false;
        int enteredStatus = 0;

        while (!statusIsEntered) {
            enteredStatus = scanner.nextInt();
            if (ValidationOfEnteredData.checkStatus(enteredStatus)) {       // проверка введенного значения от пользователя
                statusIsEntered = true;
            } else {
                PrintInformation.printBigValueInformation();
                scanner.nextLine();
            }
        }
        return enteredStatus;
    }

    public static int checkEnteredIdTask(Scanner scanner, int size){       // проверка ввода ID задания для редактирования задачи

        boolean enteredId = false;
        int idTask = 0;

        while (!enteredId) {
            idTask = scanner.nextInt();
            if (ValidationOfEnteredData.checkId(idTask) && idTask<=size) {   // проверка введенного значения от пользователя
                enteredId = true;
            } else {
                PrintInformation.printBigValueInformation();
                scanner.nextLine();
            }
        }
        return idTask;
    }

    private static boolean checkType(int enteredType){           // проверка ввода типа задачи по регуляркам, должна быть цифра в определенном диапазоне

        String localEnteredSType = String.valueOf(enteredType);

        Pattern pattern = Pattern.compile("^[1-5]$");
        Matcher matcher = pattern.matcher(localEnteredSType);

        return matcher.find();
    }

    private static boolean checkStatus(int enteredStatus){           // проверка ввода статуса задачи по регуляркам, должна быть цифра в определенном диапазоне

        String localEnteredStatus = String.valueOf(enteredStatus);

        Pattern pattern = Pattern.compile("^[1-3]$");
        Matcher matcher = pattern.matcher(localEnteredStatus);

        return matcher.find();
    }

    private static boolean checkId(int idTask){         // проверка ввода ID задачи по регуляркам, должна быть цифра

        String localIdTask = String.valueOf(idTask);

        Pattern pattern = Pattern.compile("^\\d+$");
        Matcher matcher = pattern.matcher(localIdTask);

        return matcher.find();
    }
}
