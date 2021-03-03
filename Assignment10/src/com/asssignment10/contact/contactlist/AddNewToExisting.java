package com.asssignment10.contact.contactlist;

import java.util.*;

import com.asssignment10.contacts.Contact;



public class AddNewToExisting {
	public boolean addContacts(List<Contact> existingContact, Set<Contact> newContacts)
	{
		for(Contact c: newContacts)
		{
			existingContact.add(c);
		}
		for(Contact c: existingContact)
		{
			System.out.println(c);
		}
		return true;
	}

}
