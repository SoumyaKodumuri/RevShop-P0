package utils;

import java.io.IOException;


import java.io.FileReader;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {
	
	private static final ConnectionFactory connectfactory = new ConnectionFactory();
	
	
	private Properties prop=new Properties();
	
	private ConnectionFactory(){
		
		 try {
			 prop.load(new FileReader("C:\\Users\\SOUMYA\\git\\Revshop-P0\\Ecommerce-RevShop-P0\\resources\\db_properites"));
	      }
		 catch (IOException e) {
			 e.printStackTrace(); 
	     }
	 }
	 
	 public static ConnectionFactory getConnectionFactory() {
		return connectfactory;
		 
	 }
	 
	 public Connection getConnection() {
		 try {
			  return DriverManager.getConnection(
					 prop.getProperty("url"),
					 prop.getProperty("username"),
					 prop.getProperty("password")
					 );
	
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
		
		
	 }
	 

}
