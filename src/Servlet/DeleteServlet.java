package Servlet;

import Bean.Student;
import Dao.JDBCUtil;
import Dao.UserDao;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class DeleteServlet extends HttpServlet {
    JDBCUtil db = new JDBCUtil();
    UserDao userDao = new UserDao();

    private static final long serialVersionUID = 1L;

    public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        String name = request.getParameter("name");
        Connection con = null;
        try {
            con = db.getConn();
        }catch (Exception e) {
            e.printStackTrace();
        }
        try{
            int i = userDao.delete(name);
            if (i>0) {
                request.setAttribute("deletename", name);
                List<Student> list = userDao.getAll();
                request.setAttribute("list", list);
                response.sendRedirect("deleteSuccess.jsp");
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
    public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException{
        this.doPost(request,response);
    }
}
