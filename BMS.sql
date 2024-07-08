create database bankmanagementsystem;
 
show databases;
 
use bankmanagementsystem;
 
create table signup(formno varchar(20),name varchar(20),father_name varchar(20),DOB varchar(20),gender varchar(20),email varchar(50),Marital_Status varchar(20),Address varchar(50),city varchar(20),PinCode varchar(20),State varchar(20));
 
show tables;
 
select * from signup;
 
create table signuptwo(formno varchar(20),Religion varchar(20),Category varchar(20),Income varchar(20),Education varchar(20),Occupation varchar(20),Pan_Number varchar(20),Aahar_Number varchar(20),Senior_Citizen varchar(20),Existing_Account varchar(20));

select * from signuptwo;

create table signupthree(formno varchar(20),Account_Type varchar(40),Card_Number varchar(50),Pin_Number varchar(20),Facility varchar(200));

select * from signupthree;
 
create table login(formno varchar(20),Card_Number varchar(25),Pin_Number varchar(10));

select * from login;

create table Bank(Pin_Number varchar(10),date varchar(100),type varchar(20),amount varchar(20));  

 select * from Bank;