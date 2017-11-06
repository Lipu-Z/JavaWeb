package service;

import DAO.StudentDao;
import entity.Student;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.SQLException;
import java.util.ArrayList;

public class StudentService {
    private StudentDao studentDao;

    @Autowired
    private void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    public StudentDao getStudentDao() {
        return studentDao;
    }

    public boolean insertUser(String name, int age, int id) {
        try {
            studentDao.insetStudent(name, age, id);
            return true;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public ArrayList<Student> showAllStudent(){
        ArrayList<Student> list = null;
        try{
            list = studentDao.showAllStudent();
        } catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    public boolean deleteStudent(int idunique){
        try{
            if(studentDao.deleteStudent(idunique)) return true;
            return false;
        } catch (Exception e){
            return false;
        }
    }
}
