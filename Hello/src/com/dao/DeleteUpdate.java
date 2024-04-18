package com.dao;

public interface DeleteUpdate {

	public String deleteinfo(int roll);
	public String updateinfo(int roll,int id,String fname,String lname,String gender,String email,
			String edate,String dpart,String city,String mob,String fees);
	
	public String updatebyinfo(int roll,int id,String fname,String lname,String gender,String email,
			String edate,String dpart,String city,String mob,String fees,String password);
	
	public String updatebyfile(int roll,String edate,String filename);
	
	public String updatepass(String username,String password);
	
	public String updatemsg(int msn,String title,String mdate ,String description);
	public String deleteimg(int isn);
	
	public String updateimg(int isn ,String filename,String idate);
	public String deletemsg(int msn);
	
}
