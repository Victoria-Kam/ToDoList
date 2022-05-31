package Logic;

import Entity.Task;
import Logic.Checks.CheckValueFromMenu;
import Logic.Checks.ValidationOfEnteredData;
import Logic.Database.LogicDB;
import Print.DisplayMenu;

import java.util.*;

public class LogicMenu {

    private ArrayList<Task> taskList;
    private HashMap<Integer, String> taskStatus;
    private HashMap<Integer, String> taskType;

    private int listSize;

    // для передачи данных в класс, который работает с БД
    private LogicDB logicDB;

    public LogicMenu() {
        logicDB = new LogicDB();
        this.setTaskStatus();
        this.setTaskType();
        this.setTasks();
    }

    public int returnCheckedValue(Scanner scanner) {         // проверка ввода числа основного меню

        return CheckValueFromMenu.checkValue(scanner);
    }


    public void loadTask() {         //загрузка списка задач из БД

        DisplayMenu.printTasks(taskList);

    }

    public void addTask(Scanner scanner) {      // добавление задачи в БД

        String message = "";

        try {
            Task task = this.setAddTask(scanner);       // создаем задачу с проверенными данными
            message = logicDB.addTask(task);            // уведомляем пользователя об окончании работы метода
            System.out.println(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void changeTask(Scanner scanner) {       // изменяем данные в БД

        int idTask = 0;
        int updChoice = 0;
        int temp = 1;
        int type = 0;
        int status = 0;
        String title = "";
        String content = "";
        String result = "";

        DisplayMenu.printTasks(taskList);

        DisplayMenu.printChangeTask();
        idTask = ValidationOfEnteredData.checkEnteredIdTask(scanner, listSize);     // проверяем введенный ID задачи для редактирования задачи в БД
        DisplayMenu.printChangeTaskChoice();
        DisplayMenu.printParameters(temp);          // выводим перечисление
        updChoice = CheckValueFromMenu.checkValueForChangeTask(scanner);        // проверяем введенное число
        switch (updChoice) {
            case 1:                         // редактируем тип задачи
                DisplayMenu.printChangeType();
                DisplayMenu.printTaskHashMaps(taskType);
                type = ValidationOfEnteredData.checkEnteredType(scanner);
                result = logicDB.updType(idTask, type);
                DisplayMenu.printMessageInfo(result);
                break;
            case 2:                         // редактируем заголовок задачи
                DisplayMenu.printChangeTitle();
                title = ValidationOfEnteredData.checkEnteredTitle(scanner);
                result = logicDB.updTitle(idTask, title);
                DisplayMenu.printMessageInfo(result);
                break;
            case 3:                         // редактируем саму задачу
                DisplayMenu.printChangeContent();
                content = ValidationOfEnteredData.checkEnteredContent(scanner);
                result = logicDB.updContent(idTask,content);
                DisplayMenu.printMessageInfo(result);
                break;
            case 4:                         // редактируем статус задачи
                DisplayMenu.printChangeStatus();
                DisplayMenu.printTaskHashMaps(taskStatus);
                status = ValidationOfEnteredData.checkEnteredStatus(scanner);
                result = logicDB.updStatus(idTask,status);
                DisplayMenu.printMessageInfo(result);
                break;
        }

    }

    public void deleteTask(Scanner scanner){    // удаляем задачу в БД

        int idTask = 0;
        String result = "";

        DisplayMenu.printTasks(taskList);

        DisplayMenu.printDeleteData();
        idTask = ValidationOfEnteredData.checkEnteredIdTask(scanner, listSize);
        result = logicDB.deleteData(idTask);
        DisplayMenu.printMessageInfo(result);
    }


    private void setTasks() {       // загрудаем в лист задачи
        taskList = logicDB.getLoadTask();
        listSize = taskList.size();
    }

    private void setTaskType() {    // загрудаем в map тип задач
        taskType = logicDB.getTaskType();
    }

    private void setTaskStatus() {  // загрудаем в map статус задач
        taskStatus = logicDB.getTaskStatus();
    }

    private Task setAddTask(Scanner scanner) {          // добавляем задачу

        int enteredType = 0;
        int enteredStatus = 0;

        String title = "";
        String content = "";


        Task task;

        DisplayMenu.printAddTaskAction();

        DisplayMenu.enterType();
        DisplayMenu.printTaskHashMaps(taskType);
        enteredType = ValidationOfEnteredData.checkEnteredType(scanner);    // проверка ввода типа задачи

        DisplayMenu.enterTitle();
        title = ValidationOfEnteredData.checkEnteredTitle(scanner);         // проверка ввода заголовка задачи

        DisplayMenu.emptyLine();

        DisplayMenu.enterContent();
        content = ValidationOfEnteredData.checkEnteredContent(scanner);     // проверка ввода самой задачи


        DisplayMenu.emptyLine();

        DisplayMenu.enterStatus();
        DisplayMenu.printTaskHashMaps(taskStatus);          // проверка ввода статуса задачи
        enteredStatus = ValidationOfEnteredData.checkEnteredStatus(scanner);

        task = new Task(++listSize, enteredType, title, content, enteredStatus);

        return task;
    }
}
