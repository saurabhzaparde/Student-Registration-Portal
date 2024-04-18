package com.controller;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.DeleteUpdateImp;

@SuppressWarnings("serial")
public class Updatedata extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String filled = request.getParameter("filled");
		String date = LocalDate.now().toString();
		
		if(filled.equals("info")) {
			
			String roll =request.getParameter("roll");
			String id =request.getParameter("id");
			String fname =request.getParameter("fname");
			String lname =request.getParameter("lname");
			String email =request.getParameter("email");
			String gender =request.getParameter("gender");
			String dept =request.getParameter("dept");
			String city =request.getParameter("city");
			String mob =request.getParameter("mob");
			String fees =request.getParameter("fees");
			
			int sid = Integer.parseInt(id);
			int roll_no =Integer.parseInt(roll);
			String updateinfo = new DeleteUpdateImp().updateinfo( roll_no,sid,fname,lname,gender, email,date,
					 dept,city,mob,fees);
			if(updateinfo.equals("updated")) {
				session.setAttribute("msg", "Info. UPDATED SUCCESSFULLY");
				response.sendRedirect("dupdate.jsp");
			}
			else {
				session.setAttribute("msg", "SOMETHING WENT WRONG");
				response.sendRedirect("dupdate.jsp");
			}
			
		}
		else if(filled.equals("msg")) {
			
			String sn =request.getParameter("sn");
			String title =request.getParameter("title");
			String desc =request.getParameter("desc");
			
			int msn = Integer.parseInt(sn);
			String updatemsg = new DeleteUpdateImp().updatemsg(msn,title,date,desc);
			
			if(updatemsg.equals("updated")) {
				session.setAttribute("msg", "MSSG. UPDATED SUCCESSFULLY");
				response.sendRedirect("dupdate.jsp");
			}
			else {
				session.setAttribute("msg", "SOMETHING WENT WRONG");
				response.sendRedirect("dupdate.jsp");
			}
			
		}
        else if(filled.equals("img")) {
        	
        	String sn =request.getParameter("sn");
			String filename =request.getParameter("filename");
			
			int isn = Integer.parseInt(sn);
			String updateimg = new DeleteUpdateImp().updateimg(isn,date,filename);
			
			if(updateimg.equals("updated")) {
				session.setAttribute("msg", "IMG.. UPDATED SUCCESSFULLY");
				response.sendRedirect("dupdate.jsp");
			}
			else {
				session.setAttribute("msg", "SOMETHING WENT WRONG");
				response.sendRedirect("dupdate.jsp");
			}
			
		}
	}
}
