package com.cg.mps.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection {

	public static Connection getConnection() throws IOException, ClassNotFoundException, SQLException
	{
		
		Properties prop=new Properties();
		
			FileInputStream inputStream=new FileInputStream("resources/Db.properties");
		
		prop.load(inputStream);
		String driver=prop.getProperty("driver");
		String url=prop.getProperty("url");
		String username=prop.getProperty("username");
		String password=prop.getProperty("password");
		
			Class.forName(driver);
		Connection connection=DriverManager.getConnection(url,username,password);
		
		return connection;
	
	}
}
