package Logic.Database.EditDatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteData {

    public void deleteData(int id) throws SQLException {    // удаление записи из БД
        Connection connection = DriverManager.getConnection(DBConfig.URL, DBConfig.NAME,DBConfig.PASSWORD);
        String sql_delete = "delete from task where idtask =" + id + ";";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql_delete);
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            connection.rollback();
            System.out.println("Error in delete data " + e);
        }
        finally {
            connection.close();
        }
    }
}
