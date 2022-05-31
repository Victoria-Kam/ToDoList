package Logic.Database.EditDatabase.UpdateData;

import Logic.Database.EditDatabase.DBConfig;
import Logic.Database.EditDatabase.UpdateData.Interface.UpdateData;
import org.postgresql.Driver;

import java.sql.*;

public class UpdateTaskType<T> extends DBConfig implements UpdateData<T> {

    @Override
    public void update(int idTask, T data) throws SQLException {    // изменение типа задачи
        Connection connection = DriverManager.getConnection(super.getUrl(),super.getName(),super.getPassword());
        //Statement statement = connection.createStatement();
        String sql_update_type = "update task set idtasktype = " + data + " where idtask = " + idTask + ";";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql_update_type);
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            connection.rollback();
            System.out.println("Error in update Type " + e);
        }finally {
            connection.close();
        }
    }
}
