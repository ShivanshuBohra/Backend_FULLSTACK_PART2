# Backend_FULLSTACK_PART2
This is backend part of todo application which handles APi calls from frontend


To run this Application
/src/main/resources/application.properties add the password of DB and also create your DB

DB SCRIPT : MySQL

create database crudApi

USE SMALL T IN TABLE NAME AS AWS has same

CREATE TABLE todos (
    Id int NOT NULL auto_increment,
    DESCRIPTION varchar(255),
    DONE varchar(255),
    TARGET_DATE date,
    USERNAME varchar(255),
     PRIMARY KEY (ID)
);

INSERT INTO todos
VALUES (1, "Learn JAvascript", false,"2021-12-15", "Shivanshu");
INSERT INTO todos
VALUES (2, "Learn Angular", false,"2021-12-15", "Shivanshu");
INSERT INTO todos
VALUES (3, "Learn AWS", false,"2021-12-15", "Ayush");

select * from Todos;



API's in this app:
  1> get : to retrive all todos
     http://localhost:8080/users/Shivanshu/todos
  2> Delete : delete a todo in db with id
     http://localhost:8080/deleteTodo/15
  3> Put : to update a todo
     http://localhost:8080/users/Shivanshu/todos/1
       Body : 
         {
        "id": 1,
        "userName": "Shivanshu",
        "description": "Learn Javascript",
        "targetDate": "2021-12-14T18:30:00.000+00:00",
        "isDone": false
     }
    4> Post : to add a new TODO
       http://localhost:8080/users/Shivanshu/todos
        
        Id is not mandatory as it is auto incremented in DB
      {
        "userName": "Shivanshu",
       "description": "Learn AWS",
       "targetDate": "2021-12-14T18:30:00.000+00:00",
       "isDone": false
      }
