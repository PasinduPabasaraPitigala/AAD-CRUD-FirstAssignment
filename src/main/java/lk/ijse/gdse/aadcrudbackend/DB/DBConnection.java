package lk.ijse.gdse.aadcrudbackend.DB;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class DBConnection {
    private static Connection con;
    public static Connection getConnection(){
        try {
            InitialContext ctx = new InitialContext();
            DataSource pool = (DataSource) ctx.lookup("java:comp/env/jdbc/item");
            con = pool.getConnection();

        } catch (NamingException | SQLException e) {
            throw new RuntimeException(e);
        }
        return con;
    }
}
