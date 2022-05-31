package Logic.Database;

import Entity.Task;
import Logic.Database.EditDatabase.AddData;
import Logic.Database.EditDatabase.DeleteData;
import Logic.Database.EditDatabase.LoadData.LoadTaskStatus;
import Logic.Database.EditDatabase.LoadData.LoadTaskType;
import Logic.Database.EditDatabase.LoadData.LoadTasks;
import Logic.Database.EditDatabase.UpdateData.Interface.UpdateData;
import Logic.Database.EditDatabase.UpdateData.UpdateContent;
import Logic.Database.EditDatabase.UpdateData.UpdateTaskStatus;
import Logic.Database.EditDatabase.UpdateData.UpdateTaskType;
import Logic.Database.EditDatabase.UpdateData.UpdateTitle;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;


public class LogicDB {

    // коллекции, где будут хранится данные из БД
    private ArrayList<Task> taskList;
    private HashMap<Integer, String> taskStatus;
    private HashMap<Integer, String> taskType;

    // для предзагрузки данных из БД
    private LoadTasks loadTask;
    private LoadTaskType loadTaskType;
    private LoadTaskStatus loadTaskStatus;

    // Добавление, редактирование и удаление записей в БД
    private AddData add;
    private UpdateData updateData;
    private DeleteData deleteData;


    public LogicDB() {
        taskList = new ArrayList<>();
        taskStatus = new HashMap<>();
        taskType = new HashMap<>();

        loadTask = new LoadTasks();
        loadTaskType = new LoadTaskType();
        loadTaskStatus = new LoadTaskStatus();
        add = new AddData();
        deleteData = new DeleteData();

        this.loadData();    // метод для загрузки типа и статуса задач, а также сами задачи
    }

    private void loadData() {       // метод для заполнения коллекций данными из БД

        taskStatus = loadTaskStatus(taskStatus);
        taskType = loadTaskType(taskType);
        taskList = loadTask();
    }

    private HashMap<Integer, String> loadTaskStatus(HashMap<Integer, String> taskStatus) {     // загрузка видов статуса задач

        try {
            taskStatus = loadTaskStatus.loadTaskType(taskStatus);
        } catch (SQLException e) {
            System.out.println("Error in LogicDB.java  loadTaskStatus" + e);
        }

        return taskStatus;
    }

    private HashMap<Integer, String> loadTaskType(HashMap<Integer, String> taskType) {     // загрузка видов типа задач

        try {
            taskType = loadTaskType.loadTaskType(taskType);
        } catch (SQLException e) {
            System.out.println("Error in LogicDB.java loadTaskType" + e);
        }

        return taskType;
    }

    private ArrayList<Task> loadTask() {             // загрузка самих задач

        try {
            taskList = loadTask.loadTask(taskList);

        } catch (SQLException e) {
            System.out.println("Error in LogicDB.java loadTask" + e);
        }
        return taskList;
    }

    public HashMap<Integer, String> getTaskType() {
        return taskType;
    }

    public HashMap<Integer, String> getTaskStatus() {
        return taskStatus;
    }

    public ArrayList<Task> getLoadTask() {
        return taskList;
    }

    public String addTask(Task task){       // добавление задачи
        try{
            add.addTask(task);
            taskList.clear();           // очищаем лист от предыдущих записей
            this.loadTask();            // загружаем заново данные из БД, но с новой записью
        }catch(SQLException e){
            System.out.println("Error in LogicDB.java addTask" + e);
        }
        return "Задача добавлена!";
    }

    public String updType(int idTask, int typeNumber){      // обновление типа задачи
        try{
            updateData = new UpdateTaskType();
            updateData.update(idTask,typeNumber);
            taskList.clear();       // очищаем лист от предыдущих записей
            this.loadTask();        // загружаем заново данные из БД, но с измененной записью
        }catch (SQLException e){
            System.out.println("Error in LogicDB.java updType" + e);
        }
        return "Тип задачи изменен!";
    }

    public String updTitle(int idTask, String title){       // обновление заголовка задачи
        try{
            updateData = new UpdateTitle();
            updateData.update(idTask,title);
            taskList.clear();       // очищаем лист от предыдущих записей
            this.loadTask();        // загружаем заново данные из БД, но с измененной записью
        }catch (SQLException e){
            System.out.println("Error in LogicDB.java updTitle" + e);
        }
        return "Название задачи изменено!";
    }

    public String updContent(int idTask, String content){   // обновление самой задачи
        try{
            updateData = new UpdateContent();
            updateData.update(idTask,content);
            taskList.clear();       // очищаем лист от предыдущих записей
            this.loadTask();        // загружаем заново данные из БД, но с измененной записью
        }catch (SQLException e){
            System.out.println("Error in LogicDB.java updContent" + e);
        }
        return "Задача изменена!";
    }

    public String updStatus(int idTask, int status){    // обновление статуса задачи
        try{
            updateData = new UpdateTaskStatus();
            updateData.update(idTask,status);
            taskList.clear();       // очищаем лист от предыдущих записей
            this.loadTask();        // загружаем заново данные из БД, но с измененной записью
        }catch (SQLException e){
            System.out.println("Error in LogicDB.java updStatus" + e);
        }
        return "Статус задачи изменен!";
    }

    public String deleteData(int idTask){       // удаление задачи из БД
    try{
        deleteData.deleteData(idTask);
        taskList.clear();       // очищаем лист от предыдущих записей
        this.loadTask();        // загружаем заново данные из БД, но без удаенной записи
    } catch (SQLException e) {
        System.out.println("Error in LogicDB.java deleteData" + e);
    }

        return "Задача удалена!";
    }
}
