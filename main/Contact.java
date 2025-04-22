package com.main;

public class Contact {
	
	private static final int PhoneNumLength = 10;
	private static final byte IdLength = 10;
	private static final byte FNameLength = 10;
	private static final byte LNameLength = 10;
	private static final byte Addresslength = 30;
	private static final String initial = "FIXME";
	private static final String initialNum = "0000000000";
	private String contactId;
	private String fName;
	private String lName;
	private String phoneNum;
	private String address;
	
	public Contact(){
		this.contactId = initial;
		this.fName = initial;
		this.lName = initial;
		this.phoneNum = initialNum;
		this.address = initial;
	}
	
	public Contact(String contactId){
		updateContactId(contactId);
		this.fName = initial;
		this.lName = initial;
		this.phoneNum = initialNum;
		this.address = initial;
	}
	
	public Contact(String contactId, String fName){
		updateContactId(contactId);
		updateFName(fName);
		this.lName = initial;
		this.phoneNum = initialNum;
		this.address = initial;
	}
	
	public Contact(String contactId, String fName, String lName){
		updateContactId(contactId);
		updateFName(fName);
		updateLName(lName);
		this.phoneNum = initialNum;
		this.address = initial;
	}
	
	public Contact(String contactId, String fName, String lName, String phoneNum){
		updateContactId(contactId);
		updateFName(fName);
		updateLName(lName);
		updatePhoneNum(phoneNum);
		this.address = initial;
	}
	
	public Contact(String contactId, String fName, String lName, String phoneNum, String address){
		updateContactId(contactId);
		updateFName(fName);
		updateLName(lName);
		updatePhoneNum(phoneNum);
		updateAddress(address);
	}
	
	public final String getContactId() {
		return contactId;
	}
	
	public final String getFName() {
		return fName;
	}
	
	public final String getLName() {
		return lName;
	}
	
	public final String getPhoneNum() {
		return phoneNum;
	}
	
	public final String getAddress() {
		return address;
	}
	
	public void updatePhoneNum(String phoneNum) {
		String regex = "[0-9]+";
		if(phoneNum == null) {
			throw new IllegalArgumentException("Invalid Entry. Phone Number cannot be blank");
		}
		else if(!phoneNum.matches(regex)) {
			throw new IllegalArgumentException("Invalid Entry. Phone Number must only consist of numbers");
		}
		else if(phoneNum.length() != PhoneNumLength) {
			throw new IllegalArgumentException("Invalid Entry. Phone Number must be " + PhoneNumLength + " numbers");
		}
		else {
			this.phoneNum = phoneNum;
		}
		
	}
	
	public void updateContactId(String contactId) {
		if(contactId == null) {
			throw new IllegalArgumentException("Invalid Entry. Id cannot be blank.");
		}
		else if(contactId.length() > IdLength) {
			throw new IllegalArgumentException("Invalid Entry. Contact ID must be less then " + IdLength + " characters.");
		}
		else {
			this.contactId = contactId;
		}
	}
	
	public void updateFName(String fName) {
		if(fName == null) {
			throw new IllegalArgumentException("Invalid Entry. Name cannot be blank.");
		}
		else if(fName.length() > FNameLength) {
			throw new IllegalArgumentException("Invalid Entry. First Name cannot be more then " + FNameLength + " characters.");
		}
		else {
			this.fName = fName;
		}
	}
	
	public void updateLName(String lName) {
		if(lName == null) {
			throw new IllegalArgumentException("Invalid Entry. Last Name cannot be blank.");
		}
		else if(lName.length() > LNameLength) {
			throw new IllegalArgumentException("Invalid Entry. Last Name cannot be more then " + LNameLength + " characters.");
		}
		else this.lName = lName;
	}
	
	public void updateAddress(String address) {
		if(address == null) {
			throw new IllegalArgumentException("Invalid Entry. Address cannot be blank");
		}
		else if(address.length() > Addresslength) {
			throw new IllegalArgumentException("Invalid Entry. Address must be less then " + Addresslength + " characters.");
		}
		else {
			this.address = address;
		}
	}


}

