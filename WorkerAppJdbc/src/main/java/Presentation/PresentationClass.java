package Presentation;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.*;
import java.util.Scanner;

public class PresentationClass {
	
	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");

	Connection con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/tracking","root","root");
//    PreparedStatement pt=con.prepareStatement("create table presentation(id integer(5) primary key,name varchar(50),topic_name varchar(60),date varchar(20),start_time varchar(30),end_time varchar(30),photo blob,sealphoto blob)");
	Scanner sc=new Scanner(System.in);
	boolean flag=true;
	while(flag)
	{
		System.out.println("1.Add presentation");
		System.out.println("2.Fetch On Date");
		System.out.println("3.Update On date");
		System.out.println("4.Update Photo");
		System.out.println("5.Delete");
		System.out.println("6.FetchAll");
		System.out.println("7.Exit");
		System.out.println("Enter invalid Option");
		int opt=sc.nextInt();
		
		switch (opt) {
		   case 1: {
		    PreparedStatement pt = con.prepareStatement("insert into presentation values(?,?,?,?,?,?,?,?)");

		    System.out.println("Enter id:");
		    int id = sc.nextInt();

		    System.out.println("enter name");
		    String name = sc.next();

		    System.out.println("Enter topic name");
		    String topic_name = sc.next();

		    System.out.println("enter the date");
//		    String date=sc.next();// p.set(Date.valueOf(sc.next));
		    String date = sc.next();

		    System.out.println("enter Start time");
		    String start_time = sc.next();

		    System.out.println("enter end time");
		    String end_time = sc.next();

		    System.out.println("Enter the photo path");
		    FileInputStream f = new FileInputStream(sc.next());

		    System.out.println("enter the seal pic");
		    FileInputStream f1 = new FileInputStream(sc.next());

		    pt.setInt(1, id);
		    pt.setString(2, name);
		    pt.setString(3, topic_name);
		    pt.setString(4, date);
		    pt.setString(5, start_time);
		    pt.setString(6, end_time);
		    pt.setBinaryStream(7, f,f.available());
		    pt.setBinaryStream(8, f1, f1.available());
		    pt.executeUpdate();
		    System.out.println("Details added");

		   }

		    break;
		   case 2: {
		    PreparedStatement pt = con.prepareStatement("select * from presentation where date=?");
		    System.out.println("enter date");
		    String date = sc.next();

		    pt.setString(1, date);
		    ResultSet e = pt.executeQuery();
		    while (e.next()) {
		     System.out.println("id : " + e.getInt(1));
		     System.out.println("name : " + e.getString(2));
		     System.out.println("topic name: " + e.getString(3));
		     System.out.println("date: " + e.getString(4));
		     System.out.println("start time: " + e.getInt(5));
		     System.out.println("end time: " + e.getInt(6));
		     FileOutputStream f = new FileOutputStream(
		       "C:\\Users\\admin\\Desktop\\SACHIN\\sachin.jpg");
		     FileOutputStream f1 = new FileOutputStream(
		       "C:\\Users\\admin\\Desktop\\SACHIN\\sachin.jpg");
		     Blob b = e.getBlob(7);
		     Blob b1 = e.getBlob(8);
		     f.write(b.getBytes(1, (int) b.length()));
		     f1.write(b1.getBytes(1, (int) b1.length()));
		    }
		   }

		    break;
		   case 3: {
		    PreparedStatement pt = con.prepareStatement("update presentation set date=? where date=?");
		    System.out.println("enter date");
		    pt.setString(1, sc.next());
		    System.out.println("enter previous date");
		    pt.setString(2, sc.next());
		    pt.executeUpdate();
		    con.close();
		    System.out.println("date updated ");

		   }

		    break;
		   case 4: {
		    PreparedStatement pt = con.prepareStatement("update presentation set photo=? where date=?");
		    System.out.println("enter the image path");
		    FileInputStream f = new FileInputStream(sc.next());
		    pt.setBlob(1, f, f.available());
		    System.out.println("enter date");
		    pt.setString(2, sc.next());
		    pt.executeUpdate();
		    con.close();

		   }

		    break;
		   
		   case 5: {
		    System.out.println("enter date");
		    String date = sc.next();
		    PreparedStatement pt = con.prepareStatement("delete from presentation where date=?");
		    pt.setString(1, date);
		    pt.executeUpdate();
		    System.out.println("removed");
		   }

		    break;
		   case 6:{
				
				PreparedStatement pt=con.prepareStatement("select * from presentation");
				
				ResultSet r=pt.executeQuery();
				while(r.next()) {
			    System.out.println(r.getInt(1));
			    System.out.println(r.getString(2));
			    System.out.println(r.getString(3));
			    System.out.println(r.getString(4));
			    System.out.println(r.getString(5));
			    System.out.println(r.getString(6));
			    FileOutputStream f = new FileOutputStream(
					       "C:\\Users\\admin\\Desktop\\SACHIN\\sachin.jpg");
					     FileOutputStream f1 = new FileOutputStream(
					       "C:\\Users\\admin\\Desktop\\SACHIN\\sachin.jpg");
					     Blob b = r.getBlob(7);
					     Blob b1 = r.getBlob(8);
					     f.write(b.getBytes(1, (int) b.length()));
					     f1.write(b1.getBytes(1, (int) b1.length()));
			  
				}
				
			}break;
		   case 7: {
		    flag = false;
		    System.out.println("Thank you......");
		   }
		    break;

		   default:
		    System.out.println("Invalid option");
		    break;
		   }
		  }
		 }
		
		
		
    

	    
	}

