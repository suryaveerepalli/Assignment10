package com.asssignment10.contact.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.asssignment10.contacts.Contact;

/*This is class is deliberately created separately for ease in accessing the elements in the file 
 * 
 * */
public class ReadSerialize {
	
	public static List<Contact> readContactsFromFile(List<Contact> populateC, String fileName)//List<Contact> contacts, String fileNAme
	{
	File file=new File("C:\\Users\\hp\\eclipse-workspace\\Ass10_Apoorva_Dharadhar\\src\\com\\psl\\contact\\file\\"+fileName);
	
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
    
 
    return populateC;
}
	
}