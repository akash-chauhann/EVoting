package com.vote;
import com.voter.dao.VoterDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
			PrintWriter out=response.getWriter();
		int voterid=Integer.parseInt(request.getParameter("voterid"));
		//out.println(voterid);
		String password=request.getParameter("password");
	    //out.println(password);
		Connection con=VoterDao.getConnection();
	    try
	    {
	    
	    ResultSet rs= (ResultSet) con.createStatement();
	    int id=rs.getInt("voterid");
	    out.println(id);
	    String pass=rs.getString("password");
	     out.println(pass);
	    if(voterid==id&&password.equals(pass))
	    {
	    	HttpSession session=request.getSession();
	    	session.setAttribute(password, "password");
	    	//session.setAttribute(voterid, "voterid");
	    	response.sendRedirect("doVote.jsp");
	    	
	    }
	    else
	    {
	    	
	    	response.sendRedirect("registration.jsp");
	    }
	    
	    
	    }
	    catch (Exception e) {
			
	    
	    
	    }
		
		
		
		
		
		}

}
