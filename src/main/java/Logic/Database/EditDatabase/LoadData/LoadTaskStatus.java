package Logic.Database.EditDatabase.LoadData;

import Logic.Database.EditDatabase.DBConfig;

import java.sql.*;
import java.util.HashMap;

public class LoadTaskStatus extends DBConfig {

    public HashMap<Integer, String> loadTaskType(HashMap<Integer, String> taskType) throws SQLException {   // загружаем в map данные из таблицы taskstatus

        Connection connection = DriverManager.getConnection(super.getUrl(), super.getName(), super.getPassword());
        Statement statement = connection.createStatement();
        String sql_select_status = "Select * from task_status";
        ResultSet resultSet = statement.executeQuery(sql_select_status);
        int count = 1;          // key списка
        while (resultSet.next()) {
            taskType.put(count, resultSet.getString("name"));
            count++;
        }

        connection.close();

        return taskType;
    }
}
