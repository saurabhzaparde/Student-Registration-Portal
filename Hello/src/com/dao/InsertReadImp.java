package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.pojo.Admin;
import com.pojo.Image;
import com.pojo.Information;
import com.pojo.Message;

public class InsertReadImp implements InsertRead {

	private ArrayList<Information> al=new ArrayList<Information>();
	private ArrayList<Admin> al0=new ArrayList<Admin>();
	private ArrayList<Message> al1=new ArrayList<Message>();
	private ArrayList<Image> al3=new ArrayList<Image>();
	private String result;
	private String sql;
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	int i;
	
	@SuppressWarnings("finally")
	public ArrayList<Information> readinfo() {
		try 
		{
			al.clear();
			sql="select * from Information";
			con = ConnectionFactory.getCon();
			ps=con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next())
			{
				Information info = new Information();
				info.setId(rs.getInt("id"));
				info.setRoll(rs.getInt("roll_no"));
				info.setFname(rs.getString("first_name"));
				info.setLname(rs.getString("last_name"));
				info.setGender(rs.getString("gender"));
				info.setEmail(rs.getString("email"));
				info.setEdate(rs.getString("edate"));
				info.setDpart(rs.getString("department"));
				info.setCity(rs.getString("city"));
				info.setMob(rs.getString("mob_no"));
				info.setFees(rs.getString("fees"));
				info.setIpassword(rs.getString("password"));
				info.setFilename(rs.getString("filename"));

				al.add(info);
			}
		} 
		catch (Exception e) {
			System.out.println("ReadInfo"+e);	
		}
		finally {
			
			return al;
		}
	}

	@SuppressWarnings("finally")
	public ArrayList<Message> readmsg() {
		try 
		{
			al1.clear();
			sql="select *from Paragraph";
			con = ConnectionFactory.getCon();
			ps=con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next())
			{
				Message mg = new Message();
			    mg.setMsn(rs.getInt("msn"));
				mg.setTitle(rs.getString("title"));
				mg.setDecription(rs.getString("description"));
				mg.setMdate(rs.getString("mdate"));
				
				al1.add(mg);
			}
		} 
		catch (Exception e) {
			System.out.println("readMsg"+e);	
		}
		finally {
			return al1;
		}
	}

	@SuppressWarnings("finally")
	public ArrayList<Admin> readadm() {
		try {
			al0.clear();
			sql="select *from admin";
			con = ConnectionFactory.getCon();
			ps=con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				Admin ad = new Admin();
				ad.setUsername(rs.getString("username"));
				ad.setApassword(rs.getString("password"));
				al0.add(ad);
		//		System.out.println(al0.size());
		//		System.out.println(al0);
			}
		} 
		catch (Exception e) {
			System.out.println("ReadAdm"+e);	
		}
		finally {
			return al0;
		}
	}

	@SuppressWarnings("finally")
	public ArrayList<Image> readimg() {
		try {
			al3.clear();
			sql="select * from Images";
			con = ConnectionFactory.getCon();
			ps=con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				Image im = new Image();
				im.setIsn(rs.getInt("isn"));
				im.setFilename(rs.getString("filename"));
				im.setIdate(rs.getString("idate"));
				al3.add(im);
			}
		} 
		catch (Exception e) {
			System.out.println("ReadImages"+e);	
		}
		finally {
			return al3;
		}
	}
	
	@SuppressWarnings("finally")
	public String insertinfo(int id, String fname, String lname, String gender, String email, String edate,
			String dpart, String city, String mob, String fees, String password,String filename) {
		try {
			con = ConnectionFactory.getCon();
			sql = "insert into Information(id,roll_no,first_name,last_name,gender,email,edate,department,city,mob_no,fees,password,filename) values(?,roll_no_seq.nextval,?,?,?,?,?,?,?,?,?,?,?)";
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
			ps.setString(11,password);
			ps.setString(12, filename);
			
			
			i = ps.executeUpdate();
			if(i==1)
			{
				result="inserted";
			}
		} 
		catch (Exception e) {
			System.out.println("InsertData"+e);
			result="failed";
		}
		finally {
			return result;
		}
	}

	@SuppressWarnings("finally")
	public String insertmsg(String title,String mdate, String description) {
		try {
			con = ConnectionFactory.getCon();
			sql = "insert into Paragraph(msn,title,mdate,description) values(roll_no_seq.nextval,?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, title);
			ps.setString(2, mdate);
			ps.setString(3, description);
			
			i = ps.executeUpdate();
			if(i==1)
			{
				result="inserted";
			}
		} 
		catch (Exception e) {
			System.out.println("Insertmsg"+e);
			result="failed";
		}
		finally {
			return result;
		}	
	}

	@SuppressWarnings("finally")
	public String insertadm() {
		try {
			con = ConnectionFactory.getCon();
			sql = "insert into Admin(username,password) values('admin56','admin22')";
			Statement st= con.createStatement();
			i = st.executeUpdate(sql);
			if(i==1)
			{
				result="inserted";
			}
		} 
		catch (Exception e) {
			System.out.println("Insertmsg"+e);
			result="failed";
		}
		finally {
			return result;
		}	
	}

	@SuppressWarnings("finally")
	public String insertimg(String filename, String idate) {
		try {
			con = ConnectionFactory.getCon();
			sql = "insert into Images(isn,filename,idate) values(roll_no_seq.nextval,?,?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, filename);
			ps.setString(2, idate);
			
			i = ps.executeUpdate();
			if(i==1)
			{
				result="inserted";
			}
		} 
		catch (Exception e) {
			System.out.println("Insertmsg"+e);
			result="failed";
		}
		finally {
			return result;
		}	
	}

}
