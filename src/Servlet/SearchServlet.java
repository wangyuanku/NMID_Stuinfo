package Servlet;

import Bean.Student;
import Dao.JDBCUtil;
import Dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class SearchServlet extends HttpServlet {
    JDBCUtil db = new JDBCUtil();
    UserDao userDao = new UserDao();

    private static final long serialVersionUID = 1L;

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
        Connection con = null;
        try{
            con = db.getConn();
        } catch (Exception e){
            e.printStackTrace();
        }
        try{
            String name = request.getParameter("name");
            List<Student> list = userDao.findByName(name);
            request.setAttribute("list",list);
            request.getRequestDispatcher("main.jsp").forward(request,response);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        this.doPost(request,response);
    }
}
