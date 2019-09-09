package Servlet;

import Bean.User;
import Dao.JDBCUtil;
import Dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;

public class RegisterServlet extends HttpServlet {
    JDBCUtil db = new JDBCUtil();
    UserDao userDao = new UserDao();

    private static final long serialVersionUID = 1L;

    public RegisterServlet(){
        super();
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        //获取regist.jsp页面提交的账号和密码
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        Connection con = null;
        User user = new User(username,password);//用regist.jsp页面获取的账号和密码将user实例化
        try{
            con = db.getConn();
        } catch (Exception e){
            e.printStackTrace();
        }
        boolean current = userDao.register(con,user);//数据库交互
        if (current){
            request.setAttribute("error","注册成功，返回登陆界面");
            request.getRequestDispatcher("login.jsp").forward(request,response);
        } else {
            request.setAttribute("error","注册失败，请重新注册");
            request.getRequestDispatcher("regist.jsp").forward(request,response);
        }
    }
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        this.doPost(request,response);
    }
}
