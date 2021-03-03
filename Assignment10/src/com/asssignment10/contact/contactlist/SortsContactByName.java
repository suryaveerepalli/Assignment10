package com.asssignment10.contact.contactlist;

import java.util.*;

import com.asssignment10.contacts.Contact;


public class SortsContactByName {
	

	public void sortContactsByName(List<Contact> contactList) {
		// TODO Auto-generated method stub
		Collections.sort(contactList, Contact.comparator1);
		for(Contact c: contactList)
		{
			System.out.println(c);
		}
		
	}
}