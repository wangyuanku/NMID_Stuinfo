package Servlet;

import Bean.User;
import Dao.JDBCUtil;
import Dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;

public class LoginServlet extends HttpServlet {
    JDBCUtil db = new JDBCUtil();
    UserDao userDao = new UserDao();

    private static final long serialVersionUID = 1l;

    public LoginServlet(){
        super();
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        //获取index.jsp页面提交的账号和密码
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Connection con = null;
        try{
            User user = new User(username,password);//用index.jsp获取的账号和密码将user实例化
            con = db.getConn();
            User currentUser = userDao.login(con,user);//index.jsp获取的账号和密码与数据库进行交互
            if (currentUser == null){
                request.setAttribute("error","用户名或密码错误");
                request.setAttribute("username",username);
                request.setAttribute("password",password);
                request.getRequestDispatcher("index.jsp").forward(request,response);
            } else {
                HttpSession session = request.getSession();//将对象保存至session中
                session.setAttribute("currentUser",currentUser);
                response.sendRedirect("main.jsp");//跳转至主页面
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        this.doPost(request,response);
    }
}
