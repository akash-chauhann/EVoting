package com.vote;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.voting.Voter;
import com.voter.dao.VoterDao;

/**
 * Servlet implementation class Insert
 */
@WebServlet("/Insert")
public class Insert extends HttpServlet {
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		   PrintWriter out=response.getWriter();
		   String firstname=request.getParameter("firstname");
		   String lastname=request.getParameter("lastname");
		   String password=request.getParameter("password");
		   String confirmpassword=request.getParameter("confirmpassword");
		   int voterid=Integer.parseInt(request.getParameter("voterid"));
		  //   System.out.println(password.equals(confirmpassword));
		   if(password.equals(confirmpassword)!=true)
		   {
		   	response.sendRedirect("error.jsp");
		   	
		   }
		   Voter v=new Voter(firstname,lastname,password,confirmpassword,voterid);
		   boolean ans=VoterDao.addToDataBase(v);
		   if(ans)
		   {
			  HttpSession s=request.getSession();
			        // s.setAttribute("voterid",voterid);
			         //s.setAttribute("password",password);
			   response.sendRedirect(("success.jsp"));
			  // rd.forward(request, response);
		   }
		   else
		   {
			   response.sendRedirect("error.jsp");
			   
		   }
		
	

		
		
		
		
		}

}
