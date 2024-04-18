package com.intiate;

import java.sql.Connection;
import java.sql.Statement;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.dao.ConnectionFactory;

public class Autocreate implements ServletContextListener {


	public String sql;
	public String sqlt;

	private Statement st;
	int i;
	
    public void contextDestroyed(ServletContextEvent sce)  { 
    	try {
    		Connection con = ConnectionFactory.getCon();
			sql = "DROP TABLE Admin";
			Statement st = con.createStatement();
			st.executeUpdate(sql);
	
		}
		catch (Exception e) {
			System.out.println("DropAdmin"+e);
		
		}
		finally {
			try {
				Connection con = ConnectionFactory.getCon();
				sql = "DROP TABLE Paragraph";
				sqlt="DROP SQUENCE Msn_seq";
				Statement st = con.createStatement();
				st.executeUpdate(sql);
				st.executeUpdate(sqlt);
				
			}
			catch (Exception e) {
				System.out.println("DropParagraph"+e);
				
			}
			finally {
				try {
					Connection con = ConnectionFactory.getCon();
					sql = "DROP TABLE Images";
					sqlt="DROP SQUENCE Isn_seq";
					Statement st = con.createStatement();
					st.executeUpdate(sql);
					st.executeUpdate(sqlt);
					
				}
				catch (Exception e) {
					System.out.println("DropIMAGES"+e);
					
				}
				finally {
					try {
						Connection con = ConnectionFactory.getCon();
						sql = "DROP TABLE Information";
						sqlt="DROP SQUENCE Roll_No_seq";
						Statement st = con.createStatement();
						st.executeUpdate(sql);
						st.executeUpdate(sqlt);
					
					}
					catch (Exception e) {
						System.out.println("DropInformation"+e);
						
					}
				}
			}
		}
    	System.out.println("All Tables Are Droped Successfully");
    }

    public void contextInitialized(ServletContextEvent sce)  { 
    	try {
    		Connection con = ConnectionFactory.getCon();
			sql = "CREATE TABLE Admin(Username VARCHAR(100) PRIMARY KEY NOT NULL,Password VARCHAR(100))";
			st = con.createStatement();
			st.executeUpdate(sql);
			
		} 
    	catch (Exception e) {
			System.out.println("Createadmin" + e);
			
		}  
    	 finally {
    		      try {
    		    	  Connection con = ConnectionFactory.getCon();
    			sql = "create table Information(Id INTEGER UNIQUE NOT NULL," + "Roll_No INTEGER PRIMARY KEY NOT NULL,"
    					+ "First_Name VARCHAR(100),Last_Name VARCHAR(100)" + ",Gender VARCHAR(50),Email VARCHAR(200),"
    					+ "Edate VARCHAR(100),Department VARCHAR(100),"
    					+ "City VARCHAR(100),Mob_No VARCHAR(100) UNIQUE NOT NULL,"
    					+ "Fees VARCHAR(100),Password VARCHAR(50),Filename VARCHAR(100) UNIQUE NOT NULL)";
    			sqlt="CREATE SEQUENCE Roll_No_seq" + 
    					"  START WITH 1" + 
    					"  INCREMENT BY 1" + 
    					"  CACHE 1000";
    			st = con.createStatement();
    			st.executeUpdate(sql);
    			st.executeUpdate(sqlt);
    			
    		     } 
    		    catch (Exception e) {
    			System.out.println("CreateInfo" + e);
    			
    		     } 
    		      finally {
    			
    			         try {
    			        	 Connection con = ConnectionFactory.getCon();
    				sql = "CREATE TABLE Paragraph(Msn INTEGER PRIMARY KEY NOT NULL, "
    						+ "Title VARCHAR(100),Description VARCHAR(1500),Mdate VARCHAR(100))";
    				
    				sqlt="CREATE SEQUENCE Msn_seq" + 
        					"  START WITH 1" + 
        					"  INCREMENT BY 1" + 
        					"  CACHE 100";
    				st = con.createStatement();
    				st.executeUpdate(sql);
    				st.executeUpdate(sqlt);
    			
    			       } 
    			       catch (Exception e) {
    				   System.out.println("CreateInfo" + e);
    				
    			      } 
    		 
    			finally {
    				
    				try {
    					Connection con = ConnectionFactory.getCon();
    					sql = "CREATE TABLE IMAGES(Isn INTEGER PRIMARY KEY NOT NULL,"
    							+ " Filename VARCHAR(100) UNIQUE NOT NULL,Idate VARCHAR(100))";
    					sqlt="CREATE SEQUENCE Isn_seq" + 
            					"  START WITH 1" + 
            					"  INCREMENT BY 1" + 
            					"  CACHE 100";
    					st = con.createStatement();
    					st.executeUpdate(sql);
    					st.executeUpdate(sqlt);
    					
    				} 
    				catch (Exception e) {
    					System.out.println("CreateImg" + e);
    					
    				} 
    			}
    		}
    	}

  
    try {
    	Connection con = ConnectionFactory.getCon();
		sql = "insert into Admin(username,password) values('admin56','admin22')";
		Statement st= con.createStatement();
		i = st.executeUpdate(sql);
		if(i==1)
		{
			System.out.println("********By Default Admin Login Credentials*******\nUsername.:-admin56\nPassword.:-admin22");
		}
	} 
	catch (Exception e) {
		System.out.println("Insertmsg"+e);
		
	}	
  }
}
