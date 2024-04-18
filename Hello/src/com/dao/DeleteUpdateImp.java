package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class DeleteUpdateImp implements DeleteUpdate {

	private String result;
	private String sql;
	private Connection con;
	private PreparedStatement ps;
	int i;
	
	@SuppressWarnings("finally")
	public String updateinfo(int roll, int id, String fname, String lname, String gender, String email, String edate,
			String dpart, String city, String mob, String fees) {
		try {
			con = ConnectionFactory.getCon();
			sql = "update information set id=?,first_name=?,last_name=?,gender=?,email=?,edate=?"
					+ ",department=?,city=?,mob_no=?,fees=? where roll_no=?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ps.setString(2, fname);
			ps.setString(3, lname);
			ps.setString(4, gender);
			ps.setString(5, email);
			ps.setString(6, edate);
			ps.setString(7, dpart);
			ps.setString(8, city);
			ps.setString(9, mob);
			ps.setString(10, fees);
			ps.setInt(11, roll);

			i = ps.executeUpdate();
			if(i>=1) {
				result="updated";
			}
		} catch (Exception e) {
			System.out.println("updatemsg"+e);
			result="failed";
		}
		finally 
		{
			return result;
		}
	}
	
	@SuppressWarnings("finally")
	public String updatebyfile(int roll, String edate,String filename) {
		try {
			con = ConnectionFactory.getCon();
			sql="update information set filename=?, edate=? where roll_no=? ";
			ps = con.prepareStatement(sql);
			ps.setString(1, filename);
			ps.setString(2, edate);
			ps.setInt(3, roll);
			i = ps.executeUpdate();
			if(i>=1) {
				result="updated";
			}
		}
		catch (Exception e) {
			System.out.println("updateinfo"+e);
			result="failed";
		}
		finally 
		{
			return result;
		}
	}
	
	@SuppressWarnings("finally")
	public String updatebyinfo(int roll, int id, String fname, String lname, String gender, String email, String edate,
			String dpart, String city, String mob, String fees, String password) {
		try {
			con = ConnectionFactory.getCon();
			sql = "update information set id=?, first_name=?,last_name=?,gender=?,email=?,edate=?"
					+ ",department=?,city=?,mob_no=?,fees=?,password=? where roll_no=?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ps.setString(2, fname);
			ps.setString(3, lname);
			ps.setString(4, gender);
			ps.setString(5, email);
			ps.setString(6, edate);
			ps.setString(7, dpart);
			ps.setString(8, city);
			ps.setString(9, mob);
			ps.setString(10, fees);
			ps.setString(11, password);
			ps.setInt(12, roll);

			i = ps.executeUpdate();
			if(i>=1) {
				result="updated";
			}
		} catch (Exception e) {
			System.out.println("updateinfo"+e);
			result="failed";
		}
		finally 
		{
			return result;
		}
	}	
	
	@SuppressWarnings("finally")
	public String updatepass(String username, String password) {
		try 
		{
			con=ConnectionFactory.getCon();
			sql="update admin set password=? where username=?";
			ps=con.prepareStatement(sql);
			ps.setString(1, password);
			ps.setString(2, username);
			
			i=ps.executeUpdate();
			if(i==1)result="updated";
			
		} 
		catch (Exception e)
		{
			System.out.println("updatepass"+e);
			result="failed";
		}
		finally 
		{
			return result;
		}
	}

	@SuppressWarnings("finally")
	public String updatemsg(int msn, String title, String mdate, String description) {
		try {
			con = ConnectionFactory.getCon();
			sql = "update paragraph set title=? , mdate=?, description=? where msn=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, title);
			ps.setString(2, mdate);
			ps.setString(3, description);
			ps.setInt(4, msn);

			i = ps.executeUpdate();
			if(i>=1) {
				result="updated";
			}
		} 
		catch (Exception e) {
			System.out.println("updatemsg"+e);
			result="failed";
		}
		finally 
		{
			return result;
		}
	}

	@SuppressWarnings("finally")
	public String updateimg(int isn, String filename, String idate) {
		try {
			con = ConnectionFactory.getCon();
			sql = "update images set title=? , mdate=?, filename=? where isn=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, filename);
			ps.setString(2, idate);;
			ps.setInt(3, isn);

			i = ps.executeUpdate();
			if(i>=1) {
				result="updated";
			}
		} catch (Exception e) {
			System.out.println("updateimg"+e);
			result="failed";
		}
		finally 
		{
			return result;
		}
	}
	
	@SuppressWarnings("finally")
	public String deleteimg(int isn) {
		try {

			sql="delete from images where isn=?";
			con = ConnectionFactory.getCon();
			ps=con.prepareStatement(sql);
			ps.setInt(1, isn);
			i = ps.executeUpdate();
			if(i==1) {
				result="deleted";
			}
		}
		catch (Exception e) {
			System.out.println("Deleteimg"+e);
			result="failed";
		}
		finally {
			return result;
		}
	}

	@SuppressWarnings("finally")
	public String deletemsg(int msn) {
		try{
		sql="delete from paragraph where msn=?";
		con = ConnectionFactory.getCon();
		ps=con.prepareStatement(sql);
		ps.setInt(1, msn);
		i = ps.executeUpdate();
		if(i==1) {
			result="deleted";
		}
	    }
	    catch (Exception e) {
		System.out.println("Deletemsg"+e);
		result="failed";
	   } 
	   finally {
		return result;
	  }
	}
	@SuppressWarnings("finally")
	public String deleteinfo(int roll) {
		try{
			sql="delete from information where roll_no=?";
			con = ConnectionFactory.getCon();
			ps=con.prepareStatement(sql);
			ps.setInt(1, roll);
			i = ps.executeUpdate();
			if(i==1) {
				result="deleted";
			}
		    }
		    catch (Exception e) {
			System.out.println("Deleteinfo"+e);
			result="failed";
		   } 
		   finally {
			return result;
		  }
	}



}
