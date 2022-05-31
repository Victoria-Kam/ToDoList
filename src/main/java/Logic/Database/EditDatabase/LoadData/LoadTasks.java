package Logic.Database.EditDatabase.LoadData;

import Entity.Task;
import Logic.Database.EditDatabase.DBConfig;

import java.sql.*;
import java.util.ArrayList;

public class LoadTasks extends DBConfig {

    public ArrayList<Task> loadTask(ArrayList<Task> task) throws SQLException {         // добавление задачи из БД в лист

        Connection connection = DriverManager.getConnection(super.getUrl(), super.getName(), super.getPassword());
        Statement statement = connection.createStatement();
        String sql_select_type = "Select * from task";
        ResultSet resultSet = statement.executeQuery(sql_select_type);
        while (resultSet.next()) {
            task.add(new Task(resultSet.getInt("idTask"), resultSet.getInt("idtasktype"), resultSet.getString("title"),
                    resultSet.getString("content"), resultSet.getInt("idtaskstatus")));
        }

        connection.close();

        return task;
    }
}
