package util;

import java.sql.*;

/**
 * @author : 小小shark
 * @ClassName JdbcUtil
 * @date : 2021-04-20 20:16
 * @Description TODO
 **/
public class JdbcUtil {
    private JdbcUtil(){
    }

    /**
     * @description: TODO
     * @params: []
     * @return: java.sql.Connection
     * @author: 小小
     * @dateTime: 2021/4/20 20:19
     */
    public static Connection getConnection(){
        Connection connection = null;

        try {
            //第1步：加载oracle驱动;
            String className = "oracle.jdbc.driver.OracleDriver";
            Class.forName(className);
            //第2步：通过驱动管理器得到连接
            String url = "jdbc:oracle:thin:@localhost:1521:orcl";
            String user = "scott";
            String password = "tiger";
            connection = DriverManager.getConnection(url,user,password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return connection;
    }

   
   /**
    * @description: TODO
    * @params: [connection]
    * @return: void
    * @author: 小小
    * @dateTime: 2021/4/20 20:20
    */
    public static void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Connection connection = JdbcUtil.getConnection();
        JdbcUtil.closeConnection(connection);
    }

}
