package com.asssignment10.db;

@SuppressWarnings("serial")
public class ContactNotFoundException extends Exception {
	public ContactNotFoundException(String string) {
		System.out.println(string);
	}
}