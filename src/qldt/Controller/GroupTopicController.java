/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package qldt.Controller;

import java.security.interfaces.RSAKey;
import java.sql.ResultSet;
import java.util.ArrayList;
import qldt.Model.GroupTopic;
import java.sql.Connection;
import java.sql.PreparedStatement;
import qldt.Model.Student;
import qldt.Model.Topic;
import qldt.View.MenuView;
import java.sql.Statement;
import qldt.View.GroupTopicView;

/**
 *
 * @author ziplo
 */
public class GroupTopicController {

    public ArrayList<Student> students = new ArrayList<>();
    public Connection connection = new DBConnection().connectDB();

    public ArrayList<Student> showGroupTopic(String groupName) {
        String sql
                = """
                select Student.StudentID, Student.StudentName, GroupTopic.GroupName, Topic.TopicName, Topic.Instructor, Topic.`Status`
                FROM GroupTopic
                Join Topic Using(TopicID)
                Join Student using(GroupID)
                where GroupTopic.GroupName = ?;""";
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setString(1, groupName);
            ResultSet resultSet = pre.executeQuery();
            while (resultSet.next()) {
                int studentID = resultSet.getInt("StudentID");
                String studentName = resultSet.getString("StudentName");
                Student student = new Student(studentID, studentName);
                students.add(student);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return students;
    }

    public int updateGroupTopic(String groupName) {
        String[] data = GroupTopicView.data;
        String sql
                = """
                update Topic
                join GroupTopic using (TopicID)
                SET Topic.TopicName = ?, Topic.Instructor = ?, Topic.`Status` = ?
                where GroupTopic.GroupName = ?;  """;
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, data[0]);
            statement.setString(2, data[1]);
            statement.setString(3, data[2]);
            statement.setString(4, groupName);
            statement.executeUpdate();

            return 0;

        } catch (Exception ex) {
            ex.printStackTrace();
            return 1;
        }
    }

    public int checkTopicName(String topicname) {
        String sql
                = "SELECT Topic.TopicName FROM Topic WHERE Topic.TopicName LIKE '" + topicname + "';";

        try {
            PreparedStatement pr = connection.prepareStatement(sql);
            ResultSet rs = pr.executeQuery();
            if (rs.next()) {
                return 1;
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            return 2;

        }
        return 0;
    }

    public int deleteGroupTopic(String TopicName) {
        String sql = "DELETE FROM `Topic` WHERE TopicName = '" + TopicName + "';";
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public boolean deleteStudentInGroup(int studentID) {
        String sql
                = """
                UPDATE Student
                SET GROUPID = NULL
                WHERE StudentID = ?;
                """;

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, studentID);
            statement.executeUpdate();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;

    }

    public int setGroupIDOfTopicDeleted(int groupID) {
        String sql
                = """
        UPDATE Student
        SET groupID = null
        WHERE GroupID = ?
        """;
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, groupID);
            statement.executeUpdate();
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
    public int setGroupIDOfStudentDeleted(int groupID, int studentID) {
        String sql
                = """
        UPDATE Student
        SET groupID = null
        WHERE GroupID = ? AND STUDENTID = ?;
        """;
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, groupID);
            statement.setInt(2, studentID);
            statement.executeUpdate();
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

}
