/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package qldt.Model;

/**
 *
 * @author ziplo
 */
public class GroupTopic {
    private int groupID;
    private String GroupName;
    private String studentID;

    public String getGroupName() {
        return GroupName;
    }

    public String getStudentID() {
        return studentID;
    }

    public int getGroupID() {
        return groupID;
    }
    
    public GroupTopic(String GroupName, String studentID) {
        this.GroupName = GroupName;
        this.studentID = studentID;
    }

    public GroupTopic(String GroupName) {
        this.GroupName = GroupName;
    }

    public GroupTopic(int groupID) {
        this.groupID = groupID;
    }

    public GroupTopic(int groupID, String GroupName) {
        this.groupID = groupID;
        this.GroupName = GroupName;
    }
    
    
    public GroupTopic() {
    }
    
    
}
