package com.asssignment10.contact.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.asssignment10.contacts.Contact;


@SuppressWarnings("unused")
public class ReadFromFile {
	public static void readContactsFromFile(List<Contact> populateC, String fileName)//List<Contact> contacts, String fileNAme
	{
		
	//String fPath = "C:\\Users\\hp\\eclipse-workspace\\Assignment9\\File1.txt";
	//	List<Contact> populateC=new ArrayList<Contact>();
		File file=new File("E:\\Assignments\\Assignment10\\src\\com\\asssignment10\\contact\\file"+fileName);
		
	    String line;
	    BufferedReader reader = null;
	  
		try {
			//reader = new BufferedReader(new FileReader(fPath));
			
			if(file.isFile())
			{
				FileReader fr=new FileReader(file);
				reader = new BufferedReader(fr);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    try {
	    	
			while ((line = reader.readLine()) != null)
			{
				Contact m=new Contact();
			    String[] parts = line.split(",");
			   int val=Integer.parseInt(parts[0]);
			   String name=parts[1];
			   String email=parts[2];
			   List<String> list=new ArrayList<String>();
			   for(int i=3;i<parts.length;i++)
			   {
				   list.add(parts[i]);
			   }
			   m.setContactID(val);
			   m.setContactName(name);
			   m.setEmailAddress(email);
			   m.setContactNumber(list);
			   populateC.add(m);
			}
			
			
	    } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    try
	    {
	    	reader.close();
	    }
	    catch(Exception e)
	    {
	    	e.printStackTrace();
	    }
	    
	    for(Contact c: populateC)
	    {
	    	System.out.println(c);
	    }
	}
	   
}