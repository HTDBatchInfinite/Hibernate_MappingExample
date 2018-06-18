package com.infinite.hibernate.customgenerator;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.hibernate.HibernateException;
import org.hibernate.engine.SessionImplementor;


public class BookIdGenerator {
	
	 public Serializable generate(SessionImplementor sessionImpl, Object data) throws HibernateException, SQLException
	 {
		 
		 System.out.println("Inside Generator Class.........");
		 
		 String name="hibernate_sequence" ;
		 
		   String prefix = "Emp";
		 
		 Serializable result = null;
	        java.sql.Connection connection = null;
	        java.sql.Statement statement = null;
	        ResultSet resultSet = null;
	        
	      
	        connection=sessionImpl.connection();
	        statement =connection.createStatement();
	        
	        resultSet = statement.executeQuery("SELECT "+name+".NEXTVAL FROM DUAL"); 
	        
	        System.out.println("Before Result  method..........");
	        
	        if(resultSet.next())
	        {
	        	 int nextValue=resultSet.getInt(1);
	        	   String suffix = String.format("%05d", nextValue + 1);   
	        	   
	        	   result = prefix.concat(suffix);
	        }
			return result;
		 
	 }

}
