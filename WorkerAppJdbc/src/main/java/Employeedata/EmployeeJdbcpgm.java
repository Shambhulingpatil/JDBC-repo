package Employeedata;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class EmployeeJdbcpgm {
	public static void main(String[] args) throws Exception {
	Connection con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/workers","root","root");
    PreparedStatement pt=con.prepareStatement("create table employee(id integer(5) primary key,name varchar(50),sal double, age integer)");
    pt.execute();
    con.close();
    
}
}
