package Print;

import Entity.Task;
import Logic.Enum.TaskParameters;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DisplayMenu {

    public static void displayMenu() {
        System.out.println("Выберите что хотите сделать:");
        System.out.println("1. Высести весь список дел.");
        System.out.println("2. Добавить новую задачу.");
        System.out.println("3. Изменить задачу.");
        System.out.println("4. Удалить задачу.");
        System.out.println();
        System.out.println("5. Завершить работу.");
    }

    public static void printGreetings() {
        System.out.println("\n*** Список дел ***\n");
    }

    public static void printGoodbye() {
        System.out.println("Пока, не забудь про список дел.");
    }

    public static void printTaskHashMaps(HashMap<Integer, String> map) {
        for (Map.Entry<Integer, String> col : map.entrySet()) {
            System.out.println(col.getKey() + ". " + col.getValue());
        }
        System.out.println();
    }

    public static void printTasks(ArrayList<Task> tasks) {
        for (Task t : tasks) {
            System.out.println(t);
        }
        System.out.println();
    }

    public static void enterType() {
        System.out.println("Выберите тип задачи из списка:");
    }

    public static void enterTitle() {
        System.out.print("Введите заголовок задачи: ");
    }

    public static void enterContent() {
        System.out.println("Введите саму задачу: ");
    }

    public static void enterStatus() {
        System.out.println("Введите статус задачи из списка: ");
    }

    public static void emptyLine() {
        System.out.println();
    }

    public static void printAddTaskAction() {
        System.out.println("\nВы выбрали добавить новую задачу!\n");
    }

    public static void printChangeTask() {
        System.out.println("Введите номер задачи, которую хотите изменить:");
    }

    public static void printChangeTaskChoice() {
        System.out.println("Выберите из списка ниже, что именно хотите изменить: ");
    }

    public static void printParameters(int count) {
        for (TaskParameters taskParameters : TaskParameters.values()) {
            System.out.println(count++ + ". " + taskParameters.toString());
        }
    }

    public static void printChangeType(){
        System.out.println("Вы выбрали изменить тип задачи! Пожалуйста выберите из списка новую задачу:");
    }

    public static void printChangeTitle(){
        System.out.println("Вы выбрали изменить название задачи! Пожалуйста введите новое название задачи:");
    }

    public static void printChangeContent(){
        System.out.println("Вы выбрали изменить задачу! Пожалуйста введите новое название задачи:");
    }

    public static void printChangeStatus(){
        System.out.println("Вы выбрали изменить статус задачи! Пожалуйста выберите из списка новую задачу:");
    }

    public static void printDeleteData(){
        System.out.println("Вы выбрали удалить задачу! Введите номер задачи, которую хотите удалить:");
    }

    public static void printMessageInfo(String message){
        System.out.println(message);
    }
}
