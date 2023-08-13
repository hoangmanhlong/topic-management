/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package qldt.Controller;

import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import qldt.Model.Student;

/**
 *
 * @author ziplo
 */
public class ListStudentNoGroupController {
    public Connection connection = new DBConnection().connectDB();
    public ArrayList<Student> students = students = new ArrayList<>();;
    public ArrayList<Student> showList(){
        String sql = "SELECT Student.StudentID, Student.StudentName, Student.`Status` FROM qldt.Student Where GroupID IS NULL;";
        try{
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
                
            while(resultSet.next()){
                
                int studentID = resultSet.getInt("StudentID");
                String studentName = resultSet.getString("StudentName");
                String status = resultSet.getString("Status");
                Student student = new Student(studentID, studentName, status);
                students.add(student);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        System.out.println(students);
        return students;
    }
    public boolean addGrouptoStudentByGroupName(String groupName,int studentID){
        String sql = 
                """
                With getGroupID AS(
                	Select groupID 
                    FRom GroupTopic
                    Where GroupName = ?
                    )
                Update Student
                Set GroupID = (Select GroupID From getGroupID)
                Where Student.StudentID = ?;
                """;
        try{
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, groupName);
            statement.setInt(2, studentID);
            statement.executeUpdate();
            return true; 
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
    public boolean addGrouptoStudentByGroupID(int groupID,int studentID){
        String sql = 
                """
                With getGroupID AS(
                	Select GroupID 
                    FRom GroupTopic
                    Where GroupID = ?
                    )
                Update Student
                Set GroupID = (Select GroupID From getGroupID)
                Where Student.StudentID = ?;
                """;
        try{
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, groupID);
            statement.setInt(2, studentID);
            statement.executeUpdate();
            return true; 
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
   
}
