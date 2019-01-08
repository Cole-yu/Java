package com.yfx.demo;

import java.sql.*;

public class Demo2 {
	public static void main(String args[]){
	     try {
	          Class.forName("com.mysql.cj.jdbc.Driver");     //加载MYSQL JDBC驱动程序   
	          System.out.println("Success loading Mysql Driver!");
	        }
	      catch (Exception e) {
	          System.out.print("Error loading Mysql Driver!");
	          e.printStackTrace();
	      }
     
		  try {
		      Connection connect = DriverManager.getConnection( "jdbc:mysql://localhost:3306/user_cmx?&serverTimezone=GMT","root","");
		     
		       int num=100;
		       PreparedStatement Statement=connect.prepareStatement("INSERT INTO user VALUES(?,?)");
		       for(int i=0;i<num;i++)        //定义个100次的循环，往表里插入一百条信息。
		      {
		           Statement.setString(1,"chongshi"+i);
		           Statement.setString(2, String.valueOf(i));
		           Statement.executeUpdate();
		      }
		   }
		  // catch (ClassNotFoundException e) {
		  // 	TODO Auto-generated catch block
		  // 	System.out.println("An error has occurred:"+e.toString());
		  //  	e.printStackTrace();
		  // }
		  catch(SQLException e){
		  //    TODO
		   }
  
	}
}
