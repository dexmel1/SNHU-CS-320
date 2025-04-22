package com.main;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ContactService {
	
	private String uniqueId;
	private List<Contact> contactList = new ArrayList<Contact>();
	
	public void newContact() {
		Contact contact = new Contact(newId());
		contactList.add(contact);
	}
	
	public void newContact(String fName) {
		Contact contact = new Contact(newId(), fName);
		contactList.add(contact);		
	}
	
	public void newContact(String fName, String lName) {
		Contact contact = new Contact(newId(), fName, lName);
		contactList.add(contact);
	}
	
	public void newContact(String fName, String lName, String phoneNum) {
		Contact contact = new Contact(newId(), fName, lName, phoneNum);
		contactList.add(contact);
	}
	
	public void newContact(String fName, String lName, String phoneNum, String address) {
		Contact contact = new Contact(newId(), fName, lName, phoneNum, address);
		contactList.add(contact);
	}
	
	public List<Contact> getContactList(){
		return contactList;
	}
	
	public Contact searchContact(String id) throws Exception {
		for(Contact contact: contactList) {
			if(id.equals(contact.getContactId())) {
				return contact;
			}
		}
		throw new IllegalArgumentException("No contact exists by that ID");
	}
	
	public String newId(){
	    uniqueId = UUID.randomUUID().toString().replace("-", "").substring(0, 10);
	    return uniqueId;
	}
	
	public void deleteContact(String id) throws Exception {
		contactList.remove(searchContact(id));
	}
	
	public void updatePhoneNum(String id, String phoneNum) throws Exception{
		searchContact(id).updatePhoneNum(phoneNum);
	}
	
	public void updateFName(String id, String fName) throws Exception{
		searchContact(id).updateFName(fName);
	}
	
	public void updateLName(String id, String lName) throws Exception{
		searchContact(id).updateLName(lName);
	}

	public void updateAddress(String id, String address) throws Exception{
		searchContact(id).updateAddress(address);
	}

}
