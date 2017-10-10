import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class main extends HttpServlet{
    protected void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        System.out.println("username=" + username);
        System.out.println("password=" + password);
        boolean login = false;
        try {
            login = login(username,password);
        } catch (Exception e){
            e.printStackTrace();
        }
        if(login) {
            response.setContentType("text/html");
            response.getWriter().println("Login Sucess!!!");
        } else {
            response.setContentType("text/html");
            response.getWriter().println("Login Failed!!!");
        }
    }

    public boolean login(String username,String password) throws ClassNotFoundException, SQLException{
            /*
             * 用户登录方法
             */
        //1.注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        //2.获取连接
        Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","lip","1049");
        //3.编写sql语句
        String sql="select * from login where Name=? and PWD=?";
        //4.创建预处理对象
        PreparedStatement pstmt=conn.prepareStatement(sql);
        //5.设置参数（给占位符）
        pstmt.setString(1, username);
        pstmt.setString(2, password);
        //6.执行查询操作
        ResultSet rs=pstmt.executeQuery();
        //7.对结果集进行处理
        if(rs.next()){
            if(rs!=null) rs.close();
            if(pstmt!=null) pstmt.close();
            if(conn!=null) conn.close();
            return true;
        }else{
            if(rs!=null) rs.close();
            if(pstmt!=null) pstmt.close();
            if(conn!=null) conn.close();
            return false;
        }

    }
}