
package adamoxy.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import adamoxy.common.Config;
import adamoxy.common.log;

/**
 *
 * @author adam
 */
public class WamyConnection {

    public Connection connection = null;

    public WamyConnection() {
        try {

            Class.forName("com.mysql.jdbc.Driver");
            String databaseName = Config.getConfigurationParameter("databaseName", "");
            String databaseServer = Config.getConfigurationParameter("databaseServer", "");
            String databaseUser = Config.getConfigurationParameter("databaseUser", "");
            String password = Config.getConfigurationParameter("databasePassword", "");
            String databasePort = Config.getConfigurationParameter("databasePort", "");

            connection = DriverManager.getConnection(
                    "jdbc:mysql://" + databaseServer + ":" + databasePort
                    + "/" + databaseName + "?characterEncoding=utf-8&useUnicode=true",
                    databaseUser, password);

        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex.toString());

            log.writeEvent("Error in : WamyConnection  : " + ex.toString());
        }
    }

    public void close() {
        try {
            if (connection != null) {
                connection.close();
                connection = null;
            }
        } catch (Exception ex) {
            log.writeEvent("Error while disconnect WamyConnection : " + ex.toString());
        }
    }

}
