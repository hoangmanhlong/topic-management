DROP DATABASE IF EXISTS qldt;
CREATE DATABASE qldt;
use qldt;

DROP TABLE IF EXISTS `Account`;
CREATE TABLE `Account`(
    Username nvarchar(20) primary key,
    `Password` nvarchar(20) not null,
    `Status` boolean default TRUE
   );
drop table if exists `Topic`;
CREATE TABLE `Topic`(
    TopicID tinyint unsigned auto_increment primary key,
    TopicName NVARCHAR(100) not null default "New Topic",
    Instructor nvarchar(20),
    `Status` nvarchar(20) default "OK",
    FULLTEXT(TopicName)
);
drop table if exists `GroupTopic`;
create table  `GroupTopic`(
	GroupID tinyint auto_increment primary key,
	GroupName nvarchar(50) DEFAULT "Group Default",
    TopicID tinyint unsigned,
    foreign key (TopicID) references Topic(TopicID) ON delete cascade on update cascade
    );
drop table if exists `Student`;
create table  `Student`(
	StudentID int unsigned auto_increment primary key,
    StudentName Nvarchar(50) not null,
    GroupID tinyint,
    `Status` nvarchar(20) default "Chưa có nhóm",
    foreign key (GroupID) references `GroupTopic`(GroupID) ON delete cascade on update cascade
    );

insert into `Account` values ("long", 1234, TRUE);
insert into `Account` values ("admin", "admin", TRUE);


insert into `Topic` values(1, "Machine Learning", "Tran Hung Cuong", "OK");
insert into `Topic` values(2, "Computer Vision", "Tran Thi Thuy", "OK");
insert into `Topic` values(3, "Testing", "Hoang Quang Huy", "OK");
insert into `Topic` values(4, "Computer Network", "Tran Van Hiep", "OK");
insert into `Topic` values(5, "Nghiên cứu DVM trong XML", "Mai Anh Bao", "Hết hạn");
insert into `Topic` values(6, "Bệnh IT", "Long đẹp trai", "OK");

insert into `GroupTopic` values (1, "Vua Quỷ", 1);
insert into `GroupTopic` values (2, "2", 2);
insert into `GroupTopic` values (3, "3", 3);
insert into `GroupTopic` values (4, "4", 4);
insert into `GroupTopic` values (5, "5", 5);

insert into `Student` values (1, "Hoang Manh Long", 1, "OK"); 
insert into `Student` values (3, "Le Tien Dat", 1, "OK"); 
insert into `Student` values (4, "Dang Xuan Hieu", 1, "OK"); 
insert into `Student` values (5, "Pham Tuan Thanh", 2, "OK"); 
insert into `Student` values (6, "Nguyen Van Son", 3, "OK"); 
insert into `Student` values (7, "Tran Thai Hoang", 3, "OK"); 
insert into `Student` values (8, "Cao Tien Nguyen", 2, "OK"); 
insert into `Student` values (9, "Hoang Thuy Linh", 1, "OK"); 
insert into `Student` values (10, "Nguyen Phuong Thao", 1, "OK"); 
insert into `Student` values (11, "Nguyen Thi Phuong Thao", 4, "OK"); 
insert into `Student` values (8888, "Admin", 5, "OK"); 
insert into `Student`(StudentID, StudentName) values (6886, "Yêu Thảo"); 
insert into `Student`(StudentID, StudentName) values (1234, "Yêu Linh"); 
insert into `Student`(StudentID, StudentName) values (8668, "Yêu Linh Chi"); 
insert into `Student`(StudentID, StudentName) values (6666, "Yêu Phương Thảo"); 

/* Lấy ra danh sách topic
SELECT * FROM qldt.topic;
use qldt;
select Topic.TopicName, Topic.Instructor, GroupTopic.GroupName,COUNT(Student.GroupName) `Number`, Topic.`Status`
from GroupTopic
join Topic USING (TopicID)
join Student Using (GroupName)
Group by Student.GroupName;
*/

/* lấy thông tin view GroupTopic
select Student.StudentId, Student.StudentName, Student.GroupName, Topic.TopicName, Topic.Instructor, Topic.`Status`
FROM GroupTopic
Join Topic Using(TopicID)
Join Student using(GroupName)
where Student.GroupName = 1;
*/

/*
use qldt;
update Topic
join GroupTopic using (TopicID) 
SET TopicName = "@", Instructor = "@", `Status` = "@"
where GroupTopic.GroupName = 2;
*/

/* cap nhat sinh vien vao nhom
With getGroupID AS(
	Select groupID 
    FRom GroupTopic
    Where GroupName = "Vua Quỷ"
    )
Update Student
Set GroupID = (Select GroupID From getGroupID)
Where Student.StudentID = 6886;
*/

/* tạo topic mới và thêm sinh viên vào nhóm topic
use qldt;
Insert into Topic(TopicName, Instructor) VALUES ("HIHI", "Hoang long");
SET @last_idTopic = LAST_INSERT_ID(); -- lấy ra id mới insert
INSERT INTO GroupTopic(TopicID) VALUES (@last_idTopic);
SET @last_idGroup = last_insert_id();
Update `Student`
SET Student.GroupID = @last_idGroup
Where Student.StudentID = 6886;
*/

/*
Insert into Topic( Instructor) VALUES ("");
SET @last_idTopic = LAST_INSERT_ID(); 
INSERT INTO GroupTopic(TopicID) VALUES (@last_idTopic);

SELECT GroupID 
                FROM GroupTopic
                WHERE GroupName = "New Group";
SET SQL_SAFE_UPDATES = 0;
delete from Topic
where TopicName = "New Topic";



Select GroupName
FROM GroupTopic
WHERE GroupName = "New Group";
*/
/* Search
USE qldt;
SELECT Topic.TopicName, Topic.Instructor, GroupTopic.GroupName,COUNT(Student.GroupID) `Number`, Topic.`Status`
from GroupTopic
join Topic USING (TopicID)
join Student Using (GroupID)
WHERE MATCH(TopicName) AGAINST ("computer")
Group by Student.GroupID;
*/