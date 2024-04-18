package com.controller;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.DeleteUpdateImp;


@SuppressWarnings("serial")
public class Deletedata extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String space = request.getParameter("space");
		
		if(space.equals("Uinfo")) {
		String roll = request.getParameter("roll");
		String filename = request.getParameter("filename");
		
		int roll_no = Integer.parseInt(roll);
		
		
		String deleteinfo = new DeleteUpdateImp().deleteinfo(roll_no);
		
		if(deleteinfo.equals("deleted")) {
	
		String path=request.getRealPath("Resume")+File.separator;
			
		//	System.out.println(path);
			
			File file = new File(path+filename);
			file.delete();
			
			session.removeAttribute("check1");
			session.setAttribute("msg", "ACCOUNT DELETED SUCCESSFULLY");
			response.sendRedirect("register.jsp");
		}
		else {
			session.setAttribute("msg", "SOMETHING WENT WRONG");
			response.sendRedirect("useracc.jsp");
		}
		}
		else if(space.equals("Ainfo")) {
			String roll = request.getParameter("roll");
			String filename = request.getParameter("filename");
			
			int roll_no = Integer.parseInt(roll);
			
			String deleteinfo = new DeleteUpdateImp().deleteinfo(roll_no);
			
			if(deleteinfo.equals("deleted")) {
				
				
			//	String path=request.getRealPath("images/myprojects")+File.separator+filename;
				String path =request.getRealPath("Resume")+File.separator;
				
			//	System.out.println(path);
				
				File file = new File(path+filename);
				file.delete();
				
				session.setAttribute("msg", "ACCOUNT DELETED SUCCESSFULLY");
				response.sendRedirect("dupdate.jsp");
			}
			else {
				session.setAttribute("msg", "SOMETHING WENT WRONG");
				response.sendRedirect("dupdate.jsp");
			}
		}
		else if(space.equals("msg")) {
			
			String sn = request.getParameter("sn");
			
			int msn = Integer.parseInt(sn);
			String deletemsg = new DeleteUpdateImp().deletemsg(msn);
			
			if(deletemsg.equals("deleted")) {
				
				session.setAttribute("msg", "Msg. DELETED SUCCESSFULLY");
				response.sendRedirect("dupdate.jsp");
			}
			else {
				
				session.setAttribute("msg", "SOMETHING WENT WRONG");
				response.sendRedirect("dupdate.jsp");
			}
			
		}
		else if (space.equals("img")) {
            String sn = request.getParameter("sn");
			
			int isn = Integer.parseInt(sn);
		}
	}

}
