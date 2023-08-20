package com.spring.jdbc;

import org.springframework.context.ApplicationContext;
import java.util.*;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.spring.jdbc.dao.StudentDao;

public class App 
{
	 
    public static void main( String[] args )
    {
    	
        ApplicationContext context=new ClassPathXmlApplicationContext("com/spring/jdbc/config.xml");
   StudentDao studentDao=context.getBean("studentDao",StudentDao.class);
       Student student=new Student();
       int id,ch=0;
       String name,city;
       Scanner sc=new Scanner(System.in);
       System.out.println("Enter your choise");
       System.out.println("1.insert 2.Update 3.Delete 4.Select");
       ch=sc.nextInt();
       switch(ch)
       {
       case 1:
       do {
       System.out.println("Enter studentid,name,city");
       id=sc.nextInt();
       name=sc.next();
       city=sc.next();
       student.setId(id);
       student.setName(city);
       student.setCity(city);
       int result=studentDao.insert(student);
       System.out.println("Student added"+result);
       System.out.println("Do you want to add more record press 1");
       ch=sc.nextInt();
       }while(ch==1);
       System.out.println("========Thank You=========");
       break;
       case 2:
    	   System.out.println("Enter stuednt id previous");
    	   id=sc.nextInt();
    	   System.out.println("Enter student name and city");
    	   name=sc.next();
    	   city=sc.next();
    	   
    	   student.setId(id);
    	   student.setName(name);
    	   student.setCity(city);
    	   int result=studentDao.change(student);
    	   if(result>0)
    	   {
    		   System.out.println("updated Sucessfully");
    	   }
    	   else
    	   {
    		   System.out.println("Enter right id");
    	   }
    	   System.out.println(result);
    	   break;
       case 3:
    	   System.out.println("Enter the student id to delete the record");
    	   id=sc.nextInt();
    	   student.setId(id);
    	   int del=studentDao.delete(id);
    	   if(del>0)
    	   {
    		   System.out.println("Deleted successfully");
    		   System.out.println(del);
    	   }
    	   else
    	   {
    		   System.out.println("enter right id");
    	   }
    	 break;
    	   
} 
}}