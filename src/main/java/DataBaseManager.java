//import java.sql.*;
//
///**
// * @author 不笑猫
// */
//public class DataBaseManager
//{
//    Connection con;
//    ResultSet rs;
//    Statement stmt;
//
//    public DataBaseManager()
//    {
//        try
//        {
//            String driverClassName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
//            Class.forName(driverClassName);
//            //连接数据库
//            con = DriverManager.getConnection(
//                    "jdbc:sqlserver://localhost:1433", "sa",
//                    "123456");
////			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
//
//            stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
//                    ResultSet.CONCUR_UPDATABLE);
//        } catch (ClassNotFoundException cnfex)
//        {
//            System.err.println("Failed to load JDBC/ODBC driver.");
//            cnfex.printStackTrace();
//            System.exit(1);
//        } catch (SQLException sqle)
//        {
//            System.out.println(sqle.toString());
//        }
//    }
//
//    /**
//     *  查询数据库并返回ResultSet
//     * @param strSQL
//     * @return
//     */
//    public ResultSet getResult(String strSQL)
//    {
//        try
//        {
//            rs = stmt.executeQuery(strSQL);
//            return rs;
//        } catch (SQLException sqle)
//        {
//            System.out.println(sqle.toString());
//            return null;
//        }
//
//    }
//
//    /**
//     * 更新数据库
//     * @param strSQL
//     * @return
//     */
//    public boolean updateSql(String strSQL)
//    {
//        try
//        {
//            stmt.executeUpdate(strSQL);
//            con.commit();
//            return true;
//
//        } catch (SQLException sqle)
//        {
//            System.out.println(sqle.toString());
//            return false;
//        }
//
//    }
//
//    /**
//     * 关闭连接
//     */
//    public void closeConnection()
//    {
//        try
//        {
//            con.close();
//        } catch (SQLException sqle)
//        {
//            System.out.println(sqle.toString());
//        }
//    }
//
//}
