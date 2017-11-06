package DAO;

import entity.Student;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;


@Repository
public class StudentDao {
    public boolean insetStudent(String name, int age, int id) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "lip", "1049");
        String sql = "insert into studentlist(name,age,studentid) values(?,?,?)";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, name);
        pstmt.setInt(2, age);
        pstmt.setInt(3, id);
        return verifyExecuteUpdate(pstmt.executeUpdate(), pstmt, conn);
    }
    public ArrayList<Student> showAllStudent() throws ClassNotFoundException, SQLException{
        ArrayList<Student> studentList = new ArrayList<Student>();
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "lip", "1049");
        String sql =" select * from studentList";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        while(rs.next()){
            studentList.add(new Student(rs.getInt(1),rs.getString(2), rs.getInt(3),rs.getInt(4)));
        }
        rs.close();
        pstmt.close();
        conn.close();
        return studentList;
    }
    public boolean deleteStudent(int idunique)throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "lip", "1049");
        String sql = "delete from studentList where ID=?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1,idunique);
        return verifyExecuteUpdate(pstmt.executeUpdate(), pstmt, conn);
    }

    public boolean verifyExecuteUpdate(int rs, PreparedStatement pstmt,  Connection conn )throws ClassNotFoundException, SQLException{
        if (pstmt != null) pstmt.close();
        if (conn != null) conn.close();
        if(rs!=0) return true;
        return false;
    }
}