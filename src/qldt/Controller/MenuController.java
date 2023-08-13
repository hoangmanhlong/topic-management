/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package qldt.Controller;
//

import java.sql.ResultSet;
import java.util.ArrayList;
import qldt.Model.Topic;
import java.sql.Connection;
import java.sql.PreparedStatement;
import qldt.Model.GroupTopic;
import java.sql.Statement;

/**
 *
 * @author ziplo
 */
public class MenuController { // lấy ra groupID của đề tài mới tạo

    public static GroupTopic menuController_GroupTopic;
    public ArrayList<Topic> topicTable = new ArrayList<>();
    public ArrayList<Topic> topicSearch = new ArrayList<>();
    public Connection con = new DBConnection().connectDB();

    public ArrayList<Topic> getTopic() {
        String sql = """
                        select Topic.TopicName, Topic.Instructor, GroupTopic.GroupName,COUNT(Student.GroupID) `Number`, Topic.`Status`
                        from GroupTopic
                        join Topic USING (TopicID)
                        join Student Using (GroupID)
                        Group by Student.GroupID; """;

        try {
            PreparedStatement pre = con.prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                String topicName = rs.getString("TopicName");
                String instructor = rs.getString("Instructor");
                String groupName = rs.getString("GroupName");
                String status = rs.getString("status");
                int number = rs.getInt("Number");
                Topic topic = new Topic(topicName, groupName, number, instructor, status);
                topicTable.add(topic);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return topicTable;
    }

    public boolean addNewTopicContructor() {
        String sql = "INSERT INTO Topic(Instructor) VALUES ('Person System')";
        String sql2 = "SET @last_idTopic = LAST_INSERT_ID();";
        String sql3 = "INSERT INTO GroupTopic(TopicID) VALUES (@last_idTopic);";

        try {
            PreparedStatement statement = con.prepareStatement(sql);
            statement.executeUpdate();

            statement = con.prepareStatement(sql2);
            statement.executeUpdate();

            statement = con.prepareStatement(sql3);
            statement.executeUpdate();

            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;

    }

    public GroupTopic getTopicID(String groupName) {
        String sql
                = """
                SELECT GroupID 
                FROM GroupTopic
                WHERE GroupName = 
                """ + groupName + ";";
        GroupTopic groupTopics = null;
        try {
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                int groupID = resultSet.getInt("GroupID");
                groupTopics = new GroupTopic(groupID);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return groupTopics;
    }

    public int getGroupID(String groupName) {
        String sql = "SELECT GroupID FROM GroupTopic WHERE GroupName = '" + groupName + "';";
        int groupID = 0;
        try {
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            if (rs.next()) {
                groupID = rs.getInt("GroupID");

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return groupID;
    }

    public Topic getNewTopic() {
        String sql
                = """
                SELECT TopicID, Topic.TopicName, Topic.Instructor, GroupTopic.GroupID, GroupTopic.GroupName 
                FROM Topic 
                join GroupTopic using(TopicID)
                 ORDER BY TopicID DESC Limit 1;
                """;
        Topic topic = null;
        try {
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                String topicName = resultSet.getString("TopicName");
                String instructor = resultSet.getString("Instructor");
                int groupID = resultSet.getInt("GroupID");
                String groupName = resultSet.getString("GroupName");
                int topicID = resultSet.getInt("TopicID");
                menuController_GroupTopic = new GroupTopic(groupID, groupName);
                topic = new Topic(topicID, topicName, instructor);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return topic;
    }

    public ArrayList<Topic> search(String inputSearch) {
        String sql
                = """
                SELECT Topic.TopicName, Topic.Instructor, GroupTopic.GroupName,COUNT(Student.GroupID) `Number`, Topic.`Status`
                from GroupTopic
                join Topic USING (TopicID)
                join Student Using (GroupID)
                WHERE MATCH(TopicName) AGAINST ( '""" + inputSearch + "')"
                + "Group by Student.GroupID; ";
        try {
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                String topicName = rs.getString("TopicName");
                String instructor = rs.getString("Instructor");
                String groupName = rs.getString("GroupName");
                String status = rs.getString("status");
                int number = rs.getInt("Number");
                Topic topic1 = new Topic(topicName, groupName, number, instructor, status);
                topicSearch.add(topic1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return topicSearch;

    }

}
