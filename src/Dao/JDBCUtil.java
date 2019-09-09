package Dao;

import java.sql.*;

public class JDBCUtil {
    private String driver = "com.mysql.jdbc.Driver";
    private String url = "jdbc:mysql://localhost:3306/stuinfo?useUnicode=true&characterEncoding=UTF-8&?useSSL=false";
    private String username = "root";
    private String password = "1234";

    public Connection getConn() throws Exception{
        Class.forName(driver);
        Connection con = DriverManager.getConnection(url,username,password);
        return con;
    }

//    public static void main(String args[]){
//        JDBCUtil db = new JDBCUtil();
//        try {
//            db.getConn();
//            System.out.println("连接成功");
//        }catch (Exception e){
//            e.printStackTrace();
//            System.out.println("连接失败");
//        }
//    }//连接测试

    public static void getClose(Connection con) throws SQLException{
        if (con != null){
            con.close();
        }
    }

}
