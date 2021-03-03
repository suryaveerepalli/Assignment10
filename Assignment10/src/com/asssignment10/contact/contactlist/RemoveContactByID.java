package com.asssignment10.contact.contactlist;

import java.sql.*;
import java.util.*;

import com.asssignment10.contacts.Contact;
import com.asssignment10.db.ConnectionUtil;
import com.asssignment10.db.ContactNotFoundException;


public class RemoveContactByID {
	public static List<Contact> getContactInfor()
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
	
	
	public static void updateDB(int id)
	{
		Connection cn=ConnectionUtil.getConnection();
		
		try
		{
			Statement st=cn.createStatement();
			String qry="delete from contact_tbl where contactId="+id+";";
			st.executeUpdate(qry);
			
		}catch(Exception e)
		{
			
		}
		
		
	}
	
//	public void removeContact(Contact contact, )
	
	
	//2.	Void Remove contact(Contact contact, List<contact> contacts) throws ContactNotFoundException
	
	/*
	 * This function takes Contact object which is to be removed as an input
	 * With the help of getter() the ID is compared with all the objects of Contact class 
	 * in the List of Contacts and when the match is found, with the help of iterator the onject is 
	 * removed
	 * */
	public static void removeContact(Contact contact, List<Contact> contacts) throws ContactNotFoundException
	{
		
		int flag=0;
		Iterator<Contact> itr=contacts.iterator();
		while(itr.hasNext())
		{
			int cid=contact.getContactID();
			Contact c=itr.next();
			if(c.getContactID()==cid)
			{
				flag=1;
				itr.remove();
				break;
			}
			else
			{
				flag=0;
			}
		}
		if(flag==0)
		{
			throw new ContactNotFoundException("Contact Not Found!!");
		}
		else
		{
			System.out.println("Successfully removed from the list");
			System.out.println("The list now is:");
			for(Contact c: contacts)
			{
				System.out.println(c);
			}
			
		}
		
		
		
		
	}
	
	public  static void removeUsingIteratorAndAlterDatabase(List<Contact> list, int id) throws ContactNotFoundException
	{
		Iterator<Contact> itr=list.iterator();
		int flag=0;
		while(itr.hasNext())
		{
			flag=0;
			Contact c=itr.next();
		//	removeContact(c, list);
		
			
			int cid=c.getContactID();
			if(cid==id)
			{
				//System.out.println("Hello");
				updateDB(id);
				itr.remove();
				flag=0;
				break;
			}
			else
			{
				flag=1;
				//throw new ContactNotFoundException("Contact Not Found!!");
				
			}
		}
		if(flag==1)
		{
			throw new ContactNotFoundException("Contact Not Found!!");
		}
		else
		{
			System.out.println("Contact successfully deleted");
			System.out.println("Current contacts->");
			for(Contact c: list)
			{
				System.out.println(c.getContactID()+","+c.getContactName()+","+c.getEmailAddress()+","+c.getContactNumber());
			}
		}
	}
	
	//Main Function
	
	public void processContactRemoval(List<Contact> list) throws ContactNotFoundException
	{
	//	List<Contact> list=new ArrayList<Contact>();
	//	list=getContactInfor();
		
		System.out.println("Enter the contact Id for the contact you wish to remove");
		
		Scanner sc=new Scanner(System.in);
		Contact c1=new Contact();
		int id=sc.nextInt();
		sc.close();
		for(Contact c: list)
		{
			if(c.getContactID()==id)
			{
				c1=c;
			}
		}
		if(c1!=null)
		{
			removeContact(c1,list);
		}
		
		//removeUsingIteratorAndAlterDatabase(list, id);

		
	}
//		public static void main(String[] args) throws ContactNotFoundException
//		{
			
//			List<Contact> list=new ArrayList<Contact>();
//			list=getContactInfor();
//			
//			System.out.println("Enter the contact Id for the contact you wish to remove");
//			
//			Scanner sc=new Scanner(System.in);
//			Contact c1=new Contact();
//			int id=sc.nextInt();
//			for(Contact c: list)
//			{
//				if(c.getContactID()==id)
//				{
//					c1=c;
//				}
//			}
//			if(c1!=null)
//			{
//				removeContact(c1,list);
//			}
//			
			//removeUsingIteratorAndAlterDatabase(list, id);

			
//			

}
