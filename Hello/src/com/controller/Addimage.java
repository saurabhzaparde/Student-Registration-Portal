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
import com.dao.InsertReadImp;


@SuppressWarnings("serial")
@MultipartConfig
public class Addimage extends HttpServlet {

	 
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String parse = request.getParameter("parse");
		HttpSession session = request.getSession();
		if(parse.equals("add")) {
			
			Part part = request.getPart("img");
			String filename = part.getSubmittedFileName();
			String date = LocalDate.now().toString();
			
			String insertimg=new InsertReadImp().insertimg(filename,date);
			if(insertimg.equals("inserted")) {
				
				InputStream i = part.getInputStream();
				byte[] b = i.readAllBytes();
				
              String path=request.getRealPath("images/improject")+File.separator+filename;
				
			//	String path="C:\\Users\\saura\\CodeX1\\Hello\\WebContent\\images\\improject\\"+filename;
				
				
				FileOutputStream fos = new FileOutputStream(path);
				fos.write(b);
				i.close();
				fos.close();
				
				session.setAttribute("msg", "Image Add Successfully");
				response.sendRedirect("dupdate.jsp");

			}
			else
			{
				session.setAttribute("msg", "Couldn't Add Images");
				response.sendRedirect("dupdate.jsp");
			}
		}
		else if(parse.equals("delete")){
			
			String sn= request.getParameter("sn");
			String filename= request.getParameter("filename");
			
			int isn = Integer.parseInt(sn);
			
			String deleteimg=new DeleteUpdateImp().deleteimg(isn);
			if(deleteimg.equals("deleted")) {
				
				
				
				
//				String path1=request.getRealPath("images/improject")+File.separator+filename;
				
				String path1="C:\\Users\\saura\\CodeX1\\Hello\\WebContent\\images\\improject"+filename;
				
				
					File file = new File(path1);
					file.delete();
					
					session.setAttribute("msg", "Image DELETED SUCCESSFULLY");
					response.sendRedirect("dupdate.jsp");
				}
				else {
					session.setAttribute("msg", "SOMETHING WENT WRONG");
					response.sendRedirect("dupdate.jsp");
			   }
		  }
	  }
  }
