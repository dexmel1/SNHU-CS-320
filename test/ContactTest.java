package com.test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.main.Contact;


public class ContactTest {
    protected String contactId, testFName, testLName, testPhoneNum, testAddress;
	protected String longContactId, badTestFName, badTestLName, longTestPhoneNum, shortTestPhoneNum, letterPhoneNum, badTestAddress;
	
	@BeforeEach
	void initialize() {
		contactId = "0000000001";
		testFName = "Test";
		testLName = "User";
		testPhoneNum = "1324657890";
		testAddress = "123 Street City St 01234";
		longContactId = "00000000001";
		badTestFName = "Test Subject";
		badTestLName = "User Person";
		longTestPhoneNum = "9876543210987";
		shortTestPhoneNum ="987654";
		letterPhoneNum = "132abc4657";
		badTestAddress = "123 Test Street Rd Test City Test State Test 01234";
	}
	
	@Test
	void contactTest() {
		Contact contact = new Contact();
		
		assertAll("Void Constructor",
			() -> assertNotNull(contact.getContactId()),
			() -> assertNotNull(contact.getFName()),
			() -> assertNotNull(contact.getLName()),
			() -> assertNotNull(contact.getPhoneNum()),
			() -> assertNotNull(contact.getAddress()));
	}
	
	@Test
	void contactIdTest() {
		Contact contact = new Contact(contactId);
		
		assertAll("ContactId Constructor",
			() -> assertEquals(contactId, contact.getContactId()),
			() -> assertNotNull(contact.getFName()),
			() -> assertNotNull(contact.getLName()),
			() -> assertNotNull(contact.getPhoneNum()),
			() -> assertNotNull(contact.getAddress()));
	}
	
	@Test
	void contactIDFNameTest() {
		Contact contact = new Contact(contactId, testFName);
		
		assertAll("ContactID/FName Constructor",
			() -> assertEquals(contactId, contact.getContactId()),
			() -> assertEquals(testFName, contact.getFName()),
			() -> assertNotNull(contact.getLName()),
			() -> assertNotNull(contact.getPhoneNum()),
			() -> assertNotNull(contact.getAddress()));
	}
	
	@Test
	void contactIDFNameLNameTest() {
		Contact contact = new Contact(contactId, testFName, testLName);
		
		assertAll("ContactID/FName Constructor",
			() -> assertEquals(contactId, contact.getContactId()),
			() -> assertEquals(testFName, contact.getFName()),
			() -> assertEquals(testLName, contact.getLName()),
			() -> assertNotNull(contact.getPhoneNum()),
			() -> assertNotNull(contact.getAddress()));
	}
	
	@Test
	void contactIDFNameLNamePhoneTest() {
		Contact contact = new Contact(contactId, testFName, testLName, testPhoneNum);
		
		assertAll("ContactID/FName Constructor",
			() -> assertEquals(contactId, contact.getContactId()),
			() -> assertEquals(testFName, contact.getFName()),
			() -> assertEquals(testLName, contact.getLName()),
			() -> assertEquals(testPhoneNum, contact.getPhoneNum()),
			() -> assertNotNull(contact.getAddress()));
	}
	
	@Test
	void contactIDFNameLNamePhoneAddressTest() {
		Contact contact = new Contact(contactId, testFName, testLName, testPhoneNum, testAddress);
		
		assertAll("ContactID/FName Constructor",
			() -> assertEquals(contactId, contact.getContactId()),
			() -> assertEquals(testFName, contact.getFName()),
			() -> assertEquals(testLName, contact.getLName()),
			() -> assertEquals(testPhoneNum, contact.getPhoneNum()),
			() -> assertEquals(testAddress, contact.getAddress()));
	}
	
	@Test
	void updateContactIdTest(){
		Contact contact = new Contact();
		contact.updateContactId(contactId);
		
		assertAll("ContactID Test",
			() -> assertEquals(contactId, contact.getContactId()),
			() -> assertThrows(IllegalArgumentException.class, () -> contact.updateContactId(null)),
			() -> assertThrows(IllegalArgumentException.class, () -> contact.updateContactId(longContactId)));
			
	}
	
	@Test
	void updateFNameTest() {
		Contact contact = new Contact();
		contact.updateFName(testFName);
		
		assertAll("FName Test",
			() -> assertEquals(testFName, contact.getFName()),
			() -> assertThrows(IllegalArgumentException.class, () -> contact.updateFName(null)),
			() -> assertThrows(IllegalArgumentException.class, () -> contact.updateFName(badTestFName)));
	}
	
		@Test
	void updateLNameTest() {
		Contact contact = new Contact();
		contact.updateLName(testLName);
		
		assertAll("LName Test",
			() -> assertEquals(testLName, contact.getLName()),
			() -> assertThrows(IllegalArgumentException.class, () -> contact.updateLName(null)),
			() -> assertThrows(IllegalArgumentException.class, () -> contact.updateLName(badTestLName)));
	}
	
	@Test
	void updatePhoneNumTest() {
		Contact contact = new Contact();
		contact.updatePhoneNum(testPhoneNum);
		
		assertAll("Phone Num Test",
			() -> assertEquals(testPhoneNum, contact.getPhoneNum()),
			() -> assertThrows(IllegalArgumentException.class, () -> contact.updatePhoneNum(null)),
			() -> assertThrows(IllegalArgumentException.class, () -> contact.updatePhoneNum(longTestPhoneNum)),
			() -> assertThrows(IllegalArgumentException.class, () -> contact.updatePhoneNum(shortTestPhoneNum)),
			() -> assertThrows(IllegalArgumentException.class, () -> contact.updatePhoneNum(letterPhoneNum)));
	}
	
	@Test
	void updateAddressTest() {
		Contact contact = new Contact();
		contact.updateAddress(testAddress);
		
		assertAll("Address Test",
			() -> assertEquals(testAddress, contact.getAddress()),
			() -> assertThrows(IllegalArgumentException.class, () -> contact.updateAddress(null)),
			() -> assertThrows(IllegalArgumentException.class, () -> contact.updateAddress(badTestAddress)));
	}
}

