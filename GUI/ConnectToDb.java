package GUI;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.sql.Connection;
import java.sql.SQLException;

public class ConnectToDb {

    public static void main(String[] args) throws SQLException {
        var server = "LAPTOP-BT14K5NE\\SQLEXPRESS";
        var user = "sa";
        var password = "123";
        var db = "QuanLySinhVien";
        var port = 1500;
        SQLServerDataSource ds = new SQLServerDataSource();
        ds.setUser(user);
        ds.setPassword(password);
        ds.setDatabaseName(db);
        ds.setServerName(server);
        ds.setPortNumber(port);
        ds.setEncrypt(false);
        try (Connection conn = ds.getConnection()) {
            System.out.println("ok");
        } catch (SQLServerException ex) {
            ex.printStackTrace();
        }
    }
}
