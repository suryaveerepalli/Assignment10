package com.asssignment10.contact.contactlist;

import java.sql.*;
import java.util.*;

import com.asssignment10.contacts.Contact;
import com.asssignment10.db.ConnectionUtil;
import com.asssignment10.db.ContactNotFoundException;


public class SearchPhoneNumbers {
	public static List<Contact> searchDB()
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
				
//				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return m;
	}
	public static List<Contact> searchContactByNumber(String number) throws ContactNotFoundException
	{
		List<Contact> searchList=new ArrayList<Contact>();
		Connection cn=ConnectionUtil.getConnection();
		
			//System.out.println("1");
			Statement st1;
			try {
				
				st1 = cn.createStatement();
				String qry="select * from contact_tbl where contactList like '%"+number+"%';";
				ResultSet rs=st1.executeQuery(qry);
				
				while(rs.next())
				{
				//	System.out.println("2");
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
					//System.out.println(cont);
				}
				else
				{
					n=null;
					conts.add(n);
					cont.setContactNumber(conts);
					throw new ContactNotFoundException("Phone number field empty");
				}
				searchList.add(cont);
				//System.out.println(cont);
				}//try	
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			if(searchList.isEmpty())
			{
				throw new ContactNotFoundException("No matching phone number found");
			}
			return searchList;
		}
	
	
	//List<Contact> SearchContactByNumber(String number, List<Contact> contact) throws ContactNotFoundException
	
	
	public List<Contact> searchContactByNumber(String number, List<Contact> contact) throws ContactNotFoundException
	{
		List<Contact> searchList=new ArrayList<Contact>();
		int flag=1;
		for(Contact c: contact)
		{
			flag=0;
			@SuppressWarnings("unused")
			List<String> nums=new ArrayList<String>();
			List<String> number1=c.getContactNumber();
			int cnt=0;
			for(String str: number1)
			{
				for(int i=0;i<str.length();i++)
				{
					if(str.substring(i).contains(number))
					{
						cnt++;
						//searchList.add(c);
					}
				}
				if(cnt>1)
				{
					flag=1;
					break;
				}
				
				
			}
			if(flag==1)
			{
				
					searchList.add(c);
				
			}
			cnt=0;
//			if(number1.contains(nums))
//			{
//				searchList.add(c);
//			}
			
		}
		
		if(searchList.isEmpty())
		{
			throw new ContactNotFoundException("Could not find the record with this number");
//			for(Contact c: searchList)
//			{
//				System.out.println(c);
//			}
		}
	
		
		
		return searchList;
	}
	
	public void process(String numb, List<Contact> list)
	{
		try {
			List<Contact> li=searchContactByNumber(numb,list );
			for(Contact c: li)
			{
				System.out.println(c);
			}
			
		} catch (ContactNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@SuppressWarnings("unused")
	public void processWithDB()
	{
		SearchPhoneNumbers sp=new SearchPhoneNumbers();
		//sp.search();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the phone number to be search..");
		String number=sc.nextLine();
		List<Contact> list=searchDB();
		sc.close();
		for(Contact c: list)
		{
			//System.out.println(c);
		}
		List<Contact> finalSearchList = null;
		try {
			finalSearchList = searchContactByNumber(number);
		} catch (ContactNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(Contact c: finalSearchList)
		{
			System.out.println(c);
			
		}
	}


}