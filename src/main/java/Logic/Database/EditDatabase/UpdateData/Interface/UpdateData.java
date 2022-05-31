package Logic.Database.EditDatabase.UpdateData.Interface;

import java.sql.SQLException;

public interface UpdateData<T> {

    void update(int idTask, T data)  throws SQLException;
}
