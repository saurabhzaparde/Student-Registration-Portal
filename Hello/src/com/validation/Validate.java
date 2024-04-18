package com.validation;

import javax.servlet.http.Part;

public class Validate {

	public String result;
	
	public String validateInfo(int id,String fname,String lname,String email,String dpart,String city,String mob,String fees,String password) {
		
		
		
		if(id<1000 && id>3000) {
			
			result="Invalid Id";
		}
		else if(fname.length()<1 && fname.length()>20) {
			
			result="Invalid First Name";
		}
		else if(lname.length()<1 && lname.length()>20) {
			
			result="Invalid Last Name";
		}
		else if(email.length()<10) {
			
			result="Invalid Email";
		}
        else if(city.length()<1 && city.length()>25) {
			
			result="Invalid City Name";
		}
        else if(dpart.length()<1 && dpart.length()>25) {
			
			result="Invalid Department Name";
		}
       else if(mob.length()<10 && mob.length()>10) {
			
			result="Invalid Mob_No.";
		}
       else if(fees.length()<5 && fees.length()>7) {
			
			result="Invalid Fees";
		}
       else if(password.length()<6 && password.length()>10) {
			
			result="Invalid Password";
		}
       else {
    	   result="valid";
       }
		return result;
		
	}
	public String validateResume(Part part) {
		
		
		String type = part.getContentType();
		long size = part.getSize();
		
	    String split[] = type.split(".");
	
	    if(split.length>=2) {
	    	result="Invalid File Format";
	    }	
	    else if(!type.endsWith("pdf"))
		{
			result="Invalid File Format";
		}
		else if(size>512000)
		{
			result="File Exceeded Size";
		}
		else
		{
			result="valid";
		}
		
		return result;
		
	}
	
}
