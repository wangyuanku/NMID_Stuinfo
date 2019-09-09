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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class InsertServlet extends HttpServlet {
    JDBCUtil db = new JDBCUtil();
    UserDao userDao = new UserDao();

    private static final long serialVersionUID = 1L;

    public InsertServlet(){
        super();
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        int current=0;
        Connection con = null;
        //获取insert.jsp页面提交的学生数据
        String stuID = request.getParameter("stuid");
        String name = request.getParameter("name");
        String gender = request.getParameter("gender");
        String aage = request.getParameter("age");
        String bbirthday = request.getParameter("birthday");

        //将int和birthday转化为相应属性
        Date birthday = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            birthday = sdf.parse(bbirthday);
        } catch (ParseException e){
            e.printStackTrace();
        }
        int age = Integer.parseInt(aage);

        Student student = new Student(stuID,name,gender,age,birthday);//实例化对象
        try{
            db.getConn();
        } catch (Exception e){
            e.printStackTrace();
        }
        try {
            current = userDao.insert(con, student);
            if (current > 0) {
                request.setAttribute("error", "添加成功");
                List<Student> list = userDao.getAll();
                request.setAttribute("list", list);
                response.sendRedirect("insertSuccess.jsp");
            } else {
                request.setAttribute("error", "添加失败");
                request.getRequestDispatcher("insert.jsp").forward(request, response);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        this.doPost(request,response);
    }
}
