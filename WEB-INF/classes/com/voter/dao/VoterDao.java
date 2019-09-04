package com.voter.dao;

import java.sql.Connection;
import java.sql.DriverManager;

import com.bean.voting.Voter;
import com.mysql.jdbc.PreparedStatement;

public class VoterDao {

	
	public static Connection getConnection(){  
	    Connection con=null;  
	    try{  
	        Class.forName("com.mysql.jdbc.Driver");  
	        con=DriverManager.getConnection("jdbc:mysql://localhost:3306/voting","root","root");  
	    
	    }catch(Exception e){System.out.println(e);}  
	    
	    return con;  
	  }  
	
public static boolean addToDataBase(Voter v)
{
	boolean ans=false;
	try
	{
	
	Connection con=getConnection();
	   PreparedStatement ps=(PreparedStatement) con.prepareStatement(
			   "insert into voter(firstname,lastname,password,confirmpassword,voterid) values(?,?,?,?,?)");
	   ps.setString(1,v.getFirstname());
	   ps.setString(2,v.getLastname());
	   ps.setString(3,v.getPassword());
	   ps.setString(4,v.getConfirmpassword());
	   ps.setInt(5,v.getId());
	   
	  int i= ps.executeUpdate();
	    if(i!=0)
	    {
	    	ans=true;
	    	
	    }
	}
	catch (Exception e) {
	
	  }
	return ans;
}
	
	
	
}
