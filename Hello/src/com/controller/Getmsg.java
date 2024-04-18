package com.controller;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.InsertReadImp;


public class Getmsg extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		String title  = request.getParameter("title");
		String desc  = request.getParameter("desc");
		
		String date = LocalDate.now().toString();
		
		
		String insertmsg = new InsertReadImp().insertmsg(title,date,desc);
		if(insertmsg.equals("inserted")) {
			session.setAttribute("msg", "Paragraph Sent Successfully");
			response.sendRedirect("dupdate.jsp");

		}
		else
		{
			session.setAttribute("msg", "Couldn't Send Data");
			response.sendRedirect("dupdate.jsp");
		}
		
	}

}
