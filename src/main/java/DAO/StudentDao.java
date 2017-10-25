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
        if (pstmt.executeUpdate() != 0) {
            if (pstmt != null) pstmt.close();
            if (conn != null) conn.close();
            return true;
        } else {
            if (pstmt != null) pstmt.close();
            if (conn != null) conn.close();
            return false;
        }
    }
    public ArrayList<Student> showAllStudent() throws ClassNotFoundException, SQLException{
        ArrayList<Student> studentList = new ArrayList<Student>();
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "lip", "1049");
        String sql =" select * from studentList";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        while(rs.next()){
            studentList.add(new Student(rs.getString(2), rs.getInt(3),rs.getInt(4)));
        }
        rs.close();
        pstmt.close();
        conn.close();
        return studentList;
    }
}