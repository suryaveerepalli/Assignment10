package com.asssignment10.db;

import java.sql.*;
import java.util.*;

import com.asssignment10.contacts.Contact;



public class PopulateFromDB
{
	Connection cn=ConnectionUtil.getConnection();
	
	//10.	Set<Contact> populateContactFromDb()
		
		public Set<Contact> populateContactFromDb()
		{
			Connection cn=ConnectionUtil.getConnection();
			
			Set<Contact> m=new HashSet<Contact>();
			try {
				
				Statement st=cn.createStatement();
				
				String qry="select * from contact_tbl;";
				ResultSet rs=st.executeQuery(qry);
				
				while(rs.next())
				{
					Contact cont=new Contact();
					int contactId=rs.getInt(1);
					cont.setContactID(contactId);
					String name=rs.getString(2);
					cont.setContactName(name);
					String email=rs.getString(3);
					cont.setEmailAddress(email);
					String contactNums=rs.getString("contactList");//Receiving the input from contactList column
					//of the database"
					List<String> conts=new ArrayList<String>();
					String n="";
					if(contactNums!=null)
					{
						String[] li=contactNums.split(",");
						for(String s: li)
						{
							conts.add(s);
							
							
						}
						cont.setContactNumber(conts);
					}
					else
					{
						n=null;
						conts.add(n);
						cont.setContactNumber(conts);
					}
					m.add(cont); 
					
//					
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return m;
			
			
		}
}