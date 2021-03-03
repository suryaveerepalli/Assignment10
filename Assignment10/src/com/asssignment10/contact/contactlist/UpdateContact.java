package com.asssignment10.contact.contactlist;

import java.util.List;

import com.asssignment10.contacts.Contact;


public class UpdateContact {
	public void addContactNumber(int contactId, String contactNo, List<Contact> contacts)
	{
		for(Contact c: contacts)
		{
			int cId=c.getContactID();
			if(cId==contactId)
			{
				List<String> cn=c.getContactNumber();
				cn.add(contactNo);
				c.setContactNumber(cn);
			}
		}
		for(Contact c: contacts)
		{
			System.out.println(c);
		}
		System.out.println();
	}
	public void process()
	{
		
		//addContact(id,newNum);
	}
}