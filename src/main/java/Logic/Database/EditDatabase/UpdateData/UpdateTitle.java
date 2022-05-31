package Logic.Database.EditDatabase.UpdateData;

import Logic.Database.EditDatabase.DBConfig;
import Logic.Database.EditDatabase.UpdateData.Interface.UpdateData;

import java.sql.*;

public class UpdateTitle<T> extends DBConfig implements UpdateData<T> {
    @Override
    public void update(int idTask, T data) throws SQLException {    // изменение заголовка задачи
        Connection connection = DriverManager.getConnection(super.getUrl(), super.getName(), super.getPassword());
        String sql_update_title = "update task set title='" + data + "' where idtask = " + idTask + ";";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql_update_title);
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            connection.rollback();
            System.out.println("Error in update Title " + e);
        }
        finally {
            connection.close();
        }
    }
}
