/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package qldt.Controller;

import java.sql.Statement;
import java.sql.Connection;
import qldt.Model.Topic;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

/**
 *
 * @author ziplo
 */
public class AddNewTopicController {
    public Connection connection = new DBConnection().connectDB();
    public boolean checkTopic(Topic topic){
        String sql = "SELECT Topic.TopicName FROM Topic WHERE TopicName LIKE '" + topic.getTopicName() + "';";
        try{
            PreparedStatement pr = connection.prepareStatement(sql);
            ResultSet rs = pr.executeQuery();
            if (rs.next()) return false;
        }catch (Exception ex) {
            ex.printStackTrace();
            
        }
        return true;
    }
    public boolean UpdateInfoTopic(Topic topic, int topicID){
        String sql = 
                """
                Update Topic
                SET TopicName = ?, Instructor = ?
                WHERE TopicID = ?;
                """;
        try{
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, topic.getTopicName());
            statement.setString(2, topic.getInstructor());
            statement.setInt(3, topicID);
            statement.executeUpdate();
            return true;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
 

    public boolean cancelCreateNewTopic(String topicName){
        String sql = 
                
                "delete from Topic where TopicName = '"+ topicName + "';";
                
                
        try{
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.executeUpdate();
            return true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
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
}
