package com.model;

import java.util.ArrayList;

import com.dao.InsertReadImp;
import com.pojo.Admin;
import com.pojo.Information;

public class Verify {
	String res;
	int count=0;

	public String checked(String userid,String password) {
		InsertReadImp edi = new InsertReadImp();
	    ArrayList<Admin> al = edi.readadm();
		
		for(Admin a:al)	{
		//System.out.println(a.getUsername()+a.getApassword());
		if(userid.equals(a.getUsername()) && password.equals(a.getApassword())) {
			res="login";
			count++;
		}
		}if(count!=1)res="failed";
	return res;
	}
	
	public String checkeduser(int userid,String password) {
		InsertReadImp edi = new InsertReadImp();
	    ArrayList<Information> al = edi.readinfo();
		
		for(Information i:al)	{
		//System.out.println(a.getUsername()+a.getApassword());
		if(userid==i.getId() && password.equals(i.getIpassword())) {
			res="login";
			count++;
		}
		}if(count!=1)res="failed";
	return res;
	}
	
}

