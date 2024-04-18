package com.dao;

import java.util.ArrayList;

import com.pojo.Admin;
import com.pojo.Image;
import com.pojo.Information;
import com.pojo.Message;


public interface InsertRead {

	public ArrayList<Information> readinfo();
	public ArrayList<Message> readmsg();
	public ArrayList<Admin> readadm();
	public ArrayList<Image> readimg();
	
	public String insertinfo(int id,String fname,String lname,String gender,String email,String edate,String dpart,String city,String mob,String fees,String filename,String password);
	public String insertmsg(String title,String mdate ,String description);
	public String insertadm();
	public String insertimg(String filename,String idate);
	
}
