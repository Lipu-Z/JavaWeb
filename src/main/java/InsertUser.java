import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class InsertUser extends HttpServlet {
    protected void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        boolean insert = false;
        try {
            insert = Insert(username,password);
        } catch (Exception e){
            e.printStackTrace();
        }
        if(insert) {
            response.setContentType("text/html");
            response.getWriter().println("Insert Sucess!!!");
        } else {
            response.setContentType("text/html");
            response.getWriter().println("Insert Failed!!!");
        }
    }

    public boolean Insert(String username,String password) throws ClassNotFoundException, SQLException{
            /*
             * 用户登录方法
             */
        //1.注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        //2.获取连接
        Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","lip","1049");
        //3.编写sql语句
        String sql="insert into login(Name,PWD) values(?,?)";
        //4.创建预处理对象
        PreparedStatement pstmt=conn.prepareStatement(sql);
        //5.设置参数（给占位符）
        pstmt.setString(1, username);
        pstmt.setString(2, password);
        //6.执行查询操作
        int row =pstmt.executeUpdate();
        //7.对结果集进行处理
        if(row!=0){
            if(pstmt!=null) pstmt.close();
            if(conn!=null) conn.close();
            return true;
        } else{
            if(pstmt!=null) pstmt.close();
            if(conn!=null) conn.close();
            return false;
        }
    }

}
