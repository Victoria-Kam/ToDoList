package Logic.Database.EditDatabase.UpdateData;

import Logic.Database.EditDatabase.DBConfig;
import Logic.Database.EditDatabase.UpdateData.Interface.UpdateData;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateTaskStatus<T> extends DBConfig implements UpdateData<T> {
    @Override
    public void update(int idTask, T data) throws SQLException {    // изменение статуса задачи
        Connection connection = DriverManager.getConnection(super.getUrl(), super.getName(),super.getPassword());
        String sql_update_status = "update task set idtaskstatus =" + data + " where idtask =" + idTask + ";";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql_update_status);
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            System.out.println("Error in update Status " + e);
        }finally {
            connection.close();
        }
    }
}
