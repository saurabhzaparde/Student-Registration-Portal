package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.DeleteUpdateImp;
import com.model.Verify;

@SuppressWarnings("serial")
public class Adminlog extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String check = request.getParameter("check");
		HttpSession session = request.getSession();
		//System.out.println(check);
		if(check==null) 
		{
		String username =request.getParameter("username");
		String password =request.getParameter("password");
		
	//    System.out.println(username+" "+password);

		String checked =new Verify().checked(username,password);
		System.out.println(checked);
		if(checked.equals("login")) {
			 session.setAttribute("check", username);
			 response.sendRedirect("admin.jsp");
		}
		else {
		 session.setAttribute("msg", "Invalid Credentials");
		 response.sendRedirect("adlog.jsp");
	//	 System.out.println("Login Failed");
		}
	}
		else if(check.equals("logout")) {
			session.removeAttribute("check");
			session.setAttribute("msg", "Logout Successful");
			response.sendRedirect("adlog.jsp");
		}
		else if(check.equals("changepass")) 
		{
			String username = request.getParameter("username");
			String oldpassword = request.getParameter("oldpass");
			String newpassword = request.getParameter("newpass");
			String confirmpassword = request.getParameter("confirmpass");
		//	System.out.println(username);
			  
			if(!newpassword.equals(confirmpassword))
			{
				session.setAttribute("msg", "N..pass Must Be Same As ConfirmPass..");
				response.sendRedirect("changepass.jsp");
			}
			else
			{
				String checked = new Verify().checked(username, oldpassword);
			    if(checked.equals("login"))
			    {
			 
			    	String res=new DeleteUpdateImp().updatepass(username,newpassword);
			    	 if(res.equals("updated"))
			    	 {
			    		session.setAttribute("msg", "Change Credentials Successfully");
						response.sendRedirect("admin.jsp");
			    	 }
			    	 else
			    	 {
			    		session.setAttribute("msg", "Couldn't Updated Password");
						response.sendRedirect("changepass.jsp");
			    	 }
			    }
			    else
			    {
			    	session.setAttribute("msg", "please check old pass");
					response.sendRedirect("changepass.jsp");
			    }
			}
		}
	}

}
