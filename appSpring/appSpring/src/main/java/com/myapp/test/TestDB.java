package com.myapp.test;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;




public class TestDB {
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException
	{
		CallableStatement callSt = null;
		try
		{
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "jose";
		String password = "jose";

		// Load the Connector/J driver
		Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
		Connection conn = DriverManager.getConnection(url, user, password);
        System.out.println("Connect OK");
        callSt = conn.prepareCall("{?= call testdb.testdb(?)}");
		callSt.setLong(2,100);
		callSt.registerOutParameter(1, Types.DOUBLE);
		callSt.execute();
		Double output = callSt.getDouble(1);		
		System.out.println("result "+output);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}
}
