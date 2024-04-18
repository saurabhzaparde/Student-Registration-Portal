package com.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.dao.DeleteUpdateImp;
import com.validation.Validate;


@SuppressWarnings("serial")
@MultipartConfig
public class Updateown extends HttpServlet {
	
  

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String space =request.getParameter("space");
		String roll =request.getParameter("roll");
		String oldf =request.getParameter("old");
		String date = LocalDate.now().toString();
		
		int roll_no =Integer.parseInt(roll);
		

		
		if(space.equals("Uinfo")) {
		
		String id =request.getParameter("id");
		String fname =request.getParameter("fname");
		String lname =request.getParameter("lname");
		String email =request.getParameter("email");
		String gender =request.getParameter("gender");
		String dept =request.getParameter("dept");
		String city =request.getParameter("city");
		String mob =request.getParameter("mob");
		String fees =request.getParameter("fees");
		String password =request.getParameter("password");
		
		int sid = Integer.parseInt(id);	
				
		String validateInfo = new Validate().validateInfo(sid,fname,lname,email,dept,city,mob,fees,password);
		
		if(validateInfo.equals("valid")) {
		
		
		String updatebyinfo = new DeleteUpdateImp().updatebyinfo( roll_no,sid,fname,lname,gender, email,date,
				 dept,city,mob,fees,password);
		
           if(updatebyinfo.equals("updated")) {
			
			session.setAttribute("msg", "Successfully Update Information");
			response.sendRedirect("useracc.jsp");
			
		    }
			else {
				session.setAttribute("msg", "Couldn't Update Information");
				response.sendRedirect("useracc.jsp");
			}
		 }
		else {
			session.setAttribute("msg", validateInfo);
			response.sendRedirect("useracc.jsp");
		}
		
		}
		else if(space.equals("Uinfoor")) {
			
			Part part = request.getPart("resu");
			String filename = part.getSubmittedFileName();
			String path=request.getRealPath("Resume")+File.separator;
			File file = new File(path+oldf);
			file.delete();
			String updatebyfile =new DeleteUpdateImp(). updatebyfile(roll_no,date,filename);
			   if(updatebyfile.equals("updated")) {
			
					String validateResume = new Validate().validateResume(part);
					
					if(validateResume.equals("valid")) {
				   
			    InputStream i = part.getInputStream();
			     byte[] b = i.readAllBytes();
	
			     FileOutputStream fos = new FileOutputStream(path+filename);
			     fos.write(b);
			     i.close();
			     fos.close();
			
			   session.setAttribute("msg", "Successfully Update Information");
			   response.sendRedirect("useracc.jsp");
					}
					else {
						session.setAttribute("msg", validateResume);
						   response.sendRedirect("useracc.jsp");
					}
			
			   }
				else {
					session.setAttribute("msg", "Couldn't Update Information");
					response.sendRedirect("useracc.jsp");
				}
		}	
    }
}
