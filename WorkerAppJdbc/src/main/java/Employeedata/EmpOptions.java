package Employeedata;
import java.sql.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

import com.mysql.cj.xdevapi.PreparableStatement;

public class EmpOptions {
		public static void main(String[] args) throws Exception {
			Class.forName("com.mysql.cj.jdbc.Driver");
	
		Connection con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/workers","root","root");
		Scanner sc=new Scanner(System.in);
		boolean flag=true;
		while(flag)
		{
			System.out.println("1.Add Employee");
			System.out.println("2.Update");
			System.out.println("3.Remove");
			System.out.println("4.Fetch");
			System.out.println("5.FetchAll");
			System.out.println("6.Exit");
			System.out.println("Enter invalid Option");
			int opt=sc.nextInt();
			
			switch(opt) {
			case 1:{
				System.out.println("Enter id");
				int id=sc.nextInt();
				System.out.println("Enter name");
				String name=sc.next();
				System.out.println("Enter salary");
				double sal=sc.nextDouble();
				System.out.println("Enter age");
				int age=sc.nextInt();
				
				PreparedStatement pt=con.prepareStatement("insert into employee values(?,?,?,?)");
				pt.setInt(1, id);
				pt.setString(2, name);
				pt.setDouble(3, sal);
				pt.setInt(4, age);
				pt.executeUpdate();
				System.out.println("Successfully added");
			}break;
			
			case 2:{
				System.out.println("Enter name ");
				String name=sc.next();
				System.out.println("Enter new salary");
				double newsal=sc.nextDouble();
				PreparedStatement pt=con.prepareStatement("update employee set sal=? where name=?");
				pt.setDouble(1, newsal);
				pt.setString(2, name);
				pt.executeUpdate();
				System.out.println("Updated successfully");
				
			}break;
			
            case 3:{
            	System.out.println("Enter name ");
				String name=sc.next();
			
				PreparedStatement pt=con.prepareStatement("delete from employee where name=?");
				pt.setString(1, name);
				pt.executeUpdate();
			    System.out.println("Removed successfully");
				
			}break;
			
           case 4:{
        	   System.out.println("Enter name ");
				String name=sc.next();
			
				PreparedStatement pt=con.prepareStatement("select * from employee where name=?");
				pt.setString(1, name);
				ResultSet r=pt.executeQuery();
				while(r.next()) {
			    System.out.println(r.getInt(1));
			    System.out.println(r.getString(2));
			    System.out.println(r.getDouble(3));
			    System.out.println(r.getInt(4));
				}
			}break;
			
           case 5:{
			
				PreparedStatement pt=con.prepareStatement("select * from employee");
				
				ResultSet r=pt.executeQuery();
				while(r.next()) {
			    System.out.println(r.getInt(1));
			    System.out.println(r.getString(2));
			    System.out.println(r.getDouble(3));
			    System.out.println(r.getInt(4));
				}
				
			}break;
			
			case 6:{
				flag=false;
				System.out.println("Thank you...");
				
			}break;
			
			default:System.out.println("Invalid option");
			         break;
			}
			}
	    
	}
}
