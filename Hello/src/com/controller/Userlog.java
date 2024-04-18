package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.Verify;

@SuppressWarnings("serial")
public class Userlog extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String check1 = request.getParameter("check1");
		HttpSession session = request.getSession();
		if(check1==null) 
		{
		String id =request.getParameter("id");
		String password =request.getParameter("pass");
		
		   int userid=Integer.parseInt(id);
	//    System.out.println(username+" "+password);

		String checkeduser =new Verify().checkeduser(userid,password);
		System.out.println(checkeduser);
		if(checkeduser.equals("login")) {
			 session.setAttribute("check1", id);
			 response.sendRedirect("useracc.jsp");
		}
		else {
		 session.setAttribute("msg", "Invalid Credentials");
		 response.sendRedirect("login.jsp");
	//	 System.out.println("Login Failed");
		}
	   }
		else if(check1.equals("logout")) {
		session.removeAttribute("check1");
		session.setAttribute("msg", "Logout Successful");
		response.sendRedirect("login.jsp");
	}		
  }
}
