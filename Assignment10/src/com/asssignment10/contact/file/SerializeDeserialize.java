package com.asssignment10.contact.file;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import com.asssignment10.contacts.Contact;


public class SerializeDeserialize {
	
	public void serializeContacts(List<Contact> contact, String fileName)
	{
		try {
			FileOutputStream fileOut = new FileOutputStream(fileName);
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(contact);
			out.close();
			fileOut.close();
			System.out.println("\nSerialization Successful... Checkout your specified output file..\n");
 
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
 
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<Contact> deserializeContact(String fileName)
	{
		ArrayList<Contact> contacts=new ArrayList<Contact>();
		try {
			FileInputStream fileIn = new FileInputStream(fileName);
			ObjectInputStream in = new ObjectInputStream(fileIn);
			try {
				contacts=(ArrayList<Contact>)in.readObject();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			in.close();
			fileIn.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return contacts;
	}
}