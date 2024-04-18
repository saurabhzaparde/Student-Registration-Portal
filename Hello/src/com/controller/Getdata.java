package com.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;


import com.dao.InsertReadImp;
import com.validation.Validate;


@SuppressWarnings("serial")
@MultipartConfig
public class Getdata extends HttpServlet {
	
 

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String path=request.getRealPath("Resume")+File.separator;
//		String path="C:\\Users\\saura\\CodeX1\\Hello\\WebContent\\Resume\\";
		
		HttpSession session = request.getSession();
		String hammer =request.getParameter("hammer");	
		
		if(hammer==null) {
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
		String cpassword =request.getParameter("cpassword");
		
		Part part = request.getPart("resu");
		String filename = part.getSubmittedFileName();
		
		//System.out.println(id+" "+fname+" "+lname+" "+email+" "+gender+" "+dept+" "+city+" "+mob+" "+fees+" "+password+" "+cpassword);
		
		if(password.equals(cpassword)) {
			
			int sid = Integer.parseInt(id);
			String date = LocalDate.now().toString();
			
			String validateInfo = new Validate().validateInfo(sid,fname,lname,email,dept,city,mob,fees,password);
			
		if(validateInfo.equals("valid")) {
			
		String insertinfo = new InsertReadImp().insertinfo(sid,fname,lname,gender,email,date,dept,city,mob,fees,password,filename);
		
		if(insertinfo.equals("inserted")) {
			
			String validateResume = new Validate().validateResume(part);
				
			if(validateResume.equals("valid")) {
				
			InputStream i = part.getInputStream();
			byte[] b = i.readAllBytes();
		     String path1=path+filename;
			FileOutputStream fos = new FileOutputStream(path1);
			fos.write(b);
			i.close();
			fos.close();
			
			session.setAttribute("msg", "Information Sent Successfully");
			response.sendRedirect("register.jsp");
			}
			else {
				session.setAttribute("msg",validateResume);
				response.sendRedirect("register.jsp");
			}

		}
		else
		{
			session.setAttribute("msg", "Couldn't Send Information");
			response.sendRedirect("register.jsp");
		}
			}
		else {
			session.setAttribute("msg", validateInfo);
			response.sendRedirect("register.jsp");
		}
		}
		else {
			session.setAttribute("msg", "Password & Confirm Password Must Be Same");
			response.sendRedirect("register.jsp");
		}
		}
		else if(hammer.equals("download")) {
			
			String filename =request.getParameter("resu");
			
			 FileInputStream fis = new FileInputStream(path+filename);
	            byte[] b = fis.readAllBytes();
	            
	            ServletOutputStream os = response.getOutputStream();
	            response.setHeader("content-disposition","filename="+ filename);
	            response.setContentType("application/octet-stream");//octet-stream ->unknown file
	            
	            os.write(b);
	            fis.close();
	            os.close();
		}
	}

}
