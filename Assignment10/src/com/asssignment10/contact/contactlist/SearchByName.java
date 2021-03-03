package com.asssignment10.contact.contactlist;

import java.sql.*;
import java.sql.Statement;
import java.util.*;

import com.asssignment10.contacts.Contact;
import com.asssignment10.db.ConnectionUtil;
import com.asssignment10.db.ContactNotFoundException;


public class SearchByName {
	/*
	 * Provision for searching by name using database*/
	public static List<Contact> readFromDB()
	{
		Connection cn=ConnectionUtil.getConnection();
		
		List<Contact> m=new ArrayList<Contact>();
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
				String contactNums=rs.getString("contactList");
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
			
	}
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return m;
	}
	
	
	public List<Contact> searchContactByName(String name, List<Contact> contact) throws ContactNotFoundException//keep the return type to void
	{
		//3.	Contact searchContactByName(String name, List<Contact> contact) throws ContactNotFoundException
		/*equals() method is used for comparison of names
		 * 
		 * */
		int flag=0;
		Contact cn=new Contact();
		List<Contact> cntName=new ArrayList<Contact>();
		for(Contact c: contact)
		{
			
			if(c.getContactName().equals(name))
			{
				flag=1;
				cn=c;
				cntName.add(cn);
				
			}

		}
		if(flag==0)
		{
			
			throw new ContactNotFoundException("Ooppss!! ContactName not found");
			
		}
		return cntName;
		
	}
	
	
	public void process(String name1,List<Contact> list)
	{
		
		//List<Contact> list=new ArrayList<Contact>();
	//	list=readFromDB();
		
		SearchByName sm=new SearchByName();
		try {
			List<Contact> cList=sm.searchContactByName(name1, list);
			System.out.println("Contact details");
			for(Contact c: cList)
			{
				if(c!=null)
				{
					System.out.println(c);
				}
				
			}
		} catch (ContactNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}