/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package qldt.Model;


/**
 *
 * @author ziplo
 */
public class Topic {
    private int topicID;
    private String topicName;
    private String groupName;
    private int number;
    private String instructor;
    private String status;

    public int getTopicID() {
        return topicID;
    }

    public String getTopicName() {
        return topicName;
    }

    public String getGroupName() {
        return groupName;
    }

    public int getNumber() {
        return number;
    }

    public String getInstructor() {
        return instructor;
    }

    public String getStatus() {
        return status;
    }

    

   public Topic(String topicName, String groupName,int number, String instructor, String status) {
        this.topicName = topicName;
        this.groupName = groupName;
        this.number = number;
        this.instructor = instructor;
        this.status = status;
    }

    public Topic(String topicName, String instructor, String Status) {
        this.topicName = topicName;
        this.instructor = instructor;
        this.status = Status;
    }

    public Topic(String topicName, String groupName, String instructor, String status) {
        this.topicName = topicName;
        this.groupName = groupName;
        this.instructor = instructor;
        this.status = status;
    }

    public Topic(String topicName, String instructor) {
        this.topicName = topicName;
        this.instructor = instructor;
    }

    public Topic(int topicID, String topicName, String instructor) {
        this.topicID = topicID;
        this.topicName = topicName;
        this.instructor = instructor;
    }
    
    
    
    

    public Topic() {
    }

    @Override
    public String toString() {
        return "Topic{" + "topicName=" + topicName + ", groupName=" + groupName + ", number=" + number + ", instructor=" + instructor + ", status=" + status + '}';
    }

    
    
    
    
    
}
