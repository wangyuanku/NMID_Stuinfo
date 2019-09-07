package Dao;

import Bean.Student;
import Bean.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.lang.String;

public class UserDao {
    public User login(Connection con, User user) throws SQLException,Exception{
        User loginUser = null;
        JDBCUtil db = new JDBCUtil();
        con = db.getConn();
        String sql = "select * from user where name=? and password=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1,user.getUsername());
        ps.setString(2,user.getPassword());
        ResultSet rs = ps.executeQuery();//执行sql
        if (rs.next()){
            loginUser = new User();
            //将数据库中对应的值设置到登录对象中
            loginUser.setUsername(rs.getString("username"));
            loginUser.setPassword(rs.getString("password"));
        }
        return loginUser;
    }//登录

    public boolean register(Connection con, User user){
        String sql = "insert into user(username,password) values(?,?)";
        boolean flag = false;
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1,user.getUsername());
            ps.setString(2,user.getPassword());
            flag = ps.executeUpdate() >0 ;//>0的意思？
        } catch (Exception e){
            e.printStackTrace();
        }
        try{
            con.close();
        } catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }//注册

//    public int insert(Student student){
//        Connection con = null;
//        int i = 0;
//        String sql = "insert into student(stuid,name,gender,age,birthday) values (?,?,?,?,?)";
//        try{
//            PreparedStatement ps = con.prepareStatement(sql);
//            ps.setString(1,student.getStuID());
//            ps.setString(2,student.getName());
//            ps.setString(3,student.getGender());
//            ps.setString(4,student.getAge());
//            ps.setString(5,student.getBirthday());
//            i = ps.executeUpdate();
//        } catch (Exception e){
//            e.printStackTrace();
//        }
//        try{
//            con.close();
//        } catch (Exception e){
//            e.printStackTrace();
//        }
//    }//增
    public int delete(String name){
        Connection con = null;
        int i=0;
        String sql = "delete from student where name = '" + name + "'";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            i = ps.executeUpdate();
        } catch (Exception e){
            e.printStackTrace();
        }
        try{
            con.close();
        } catch (Exception e){
            e.printStackTrace();
        }
        return i;
    }//删
//    public int update(Student student){
//
//    }
//    public User getAll(Connection con, User user){
//        User loginuser = null;
//        String sql = "select * from student";
//        PreparedStatement ps = con.prepareStatement(sql);
//        ResultSet rs = ps.executeQuery();
//        if (rs.next()){
//            loginuser = new User();
//        }
//        return loginuser;
//    }//查


}
