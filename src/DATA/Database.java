package DATA;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * this class represent the user and pet data
 * @author Yu Liu
 */
public class Database {

    private static Database database = null;

    private Connection connection = null;

    private Database() {
        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            Properties props = new Properties();
            props.put("user", "pet");
            props.put("password", "pet");
            connection = DriverManager.getConnection("jdbc:derby:db/pet", props);
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }

    }

    public static Database getInstance() {
        if (database == null) {
            database = new Database();
        }
        return database;
    }

    /**
     * connection between database and user
     * @return
     */
    public Connection getConnection() {
        return connection;
    }

    static void close(Statement statement) {
        // get exsied data from database
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    static void close(ResultSet resultSet) {
        // set the result can not empty
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}
