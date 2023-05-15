package Presentation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Create {
	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");

	Connection con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/tracking","root","root");
	Statement st=con.createStatement();
	boolean e=st.execute("create table presentation(id integer(5) primary key,name varchar(50),topic_name varchar(60),date varchar(20),start_time varchar(30),end_time varchar(30),photo blob,sealphoto blob)");
	con.close();
	System.out.println("Created");
	}
}
