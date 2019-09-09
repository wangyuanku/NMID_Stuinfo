package Dao;

import Bean.Student;
import Bean.User;

import java.sql.*;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    public User login(Connection con, User user) throws SQLException,Exception{
        User loginUser = null;
        JDBCUtil db = new JDBCUtil();
        con = db.getConn();
        String sql = "select * from user where username=? and password=?";
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
            flag = ps.executeUpdate() > 0;//>0的意思？
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

    public int insert(Connection con,Student student)throws SQLException{
        JDBCUtil db = new JDBCUtil();
        int i = 0;
        String sql = "insert into student values (?,?,?,?,?)";
        try{
            con = db.getConn();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1,student.getStuID());
            ps.setString(2,student.getName());
            ps.setString(3,student.getGender());
            ps.setInt(4,student.getAge());
            ps.setDate(5,new java.sql.Date(student.getBirthday().getTime()));//将date格式转为String
            i = ps.executeUpdate();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            db.getClose(con);
        }
        return i;
    }//增
    public int delete(String name)throws SQLException{
        JDBCUtil db = new JDBCUtil();
        Connection con = null;
        int i=0;
        String sql = "delete from student where name = ?";
        try{
            con = db.getConn();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1,name);
            i = ps.executeUpdate();
        } catch (Exception e){
            e.printStackTrace();
        }finally {
            db.getClose(con);
        }
        return i;
    }//删
//    public int update(Student student){
//
//    }
    public List<Student> getAll()throws SQLException{
        JDBCUtil db = new JDBCUtil();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Student> list = new ArrayList<Student>();
        try {
            con = db.getConn();
            String sql = "select * from student";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                Student student = new Student();
                student.setStuID(rs.getString("stuid"));
                student.setName(rs.getString("name"));
                student.setGender(rs.getString("gender"));
                student.setAge(rs.getInt("age"));
                student.setBirthday(rs.getDate("birthday"));
                list.add(student);
            }
        } catch (Exception e){
            e.printStackTrace();
        }finally {
            db.getClose(con);
        }
        return list;
    }//查

    public List<Student> findByName(String name)throws SQLException{
        JDBCUtil db = new JDBCUtil();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Student> list =  new ArrayList<>();
        try{
            con = db.getConn();
            String sql = "select * from student where name=?";
            ps = con.prepareStatement(sql);
            ps.setString(1,name);
            rs = ps.executeQuery();
            while (rs.next()){
                Student student = new Student();
                student.setStuID(rs.getString("stuid"));
                student.setName(rs.getString("name"));
                student.setGender(rs.getString("gender"));
                student.setAge(rs.getInt("age"));
                student.setBirthday(rs.getDate("birthday"));
                list.add(student);
            }
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            db.getClose(con);
        }
        return list;
    }


}
