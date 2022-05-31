package Logic.Database.EditDatabase;

import Entity.Task;

import java.sql.*;

public class AddData {

    public void addTask(Task task) throws SQLException {        // добавление новой записи в БД

        Connection connection = DriverManager.getConnection(DBConfig.URL, DBConfig.NAME, DBConfig.PASSWORD);
        //Statement statement = connection.createStatement();
        String sql_add_data = "insert into task values(" + task.getIdTask() + "," + task.getIdTaskStyle() + ",'" +
                task.getTitle() + "','" + task.getContent() + "'," + task.getIdTaskStatus() + ");";
        PreparedStatement preparedStatement = connection.prepareStatement(sql_add_data);
        preparedStatement.executeUpdate();
        connection.close();

    }
}
