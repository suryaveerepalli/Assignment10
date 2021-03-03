package com.asssignment10.db;

import java.util.*;
import java.util.List;
import java.util.Scanner;

import com.asssignment10.contacts.Contact;


//static //1.	Add contacts :- void addContact(Contact contact,List<Contact> contacts)
//List<Contact> contacts=new ArrayList<Contact>();
public class AddContactToDB
{
	public List<Contact> addContact(Contact contact, List<Contact> contacts)
	{
		
	//:- void addContact(Contact contact,List<Contact> contacts)	
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the contactId");
		int id=sc.nextInt();contact.setContactID(id);
		sc.nextLine();
		System.out.println("Enter Contact Name");
		String contactName=sc.nextLine();
		contact.setContactName(contactName);
		System.out.println("Enter Contact Email address");
		String contactEmail=sc.nextLine();
		contact.setEmailAddress(contactEmail);
		System.out.println("How many contact numbers do you want to add?");
		int n=sc.nextInt();
		sc.nextLine();
		List<String> contactNumbers=new ArrayList<String>();
		sc.close();
		for(int i=0;i<n;i++)
		{
			System.out.println("Enter Contact phonenumber:"+i);
			String contactNum=sc.nextLine();
			contactNumbers.add(contactNum);
		}
		contact.setContactNumber(contactNumbers);
		contacts.add(contact);//Added the contact to the list
		//printAddedContact(contacts);
		@SuppressWarnings("unused")
		AddContactToDB cdb=new AddContactToDB();
		//cdb.insertContact(contacts);
		return contacts;
	}

	public static void printAddedContact(List<Contact> l)
	{
		
		for(Contact c: l)
		{
			System.out.println(c);
			System.out.println("Above contact is added successfully");
		}
	}


}