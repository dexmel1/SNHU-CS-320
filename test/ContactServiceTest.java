package com.test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.main.ContactService;


public class ContactServiceTest {
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
	void newContactTest() {
		ContactService service = new ContactService();
		
		service.newContact();
		assertAll("Service Void Test",
			() -> assertNotNull(service.getContactList().get(0).getContactId()),
			() -> assertEquals("FIXME", service.getContactList().get(0).getFName()),
			() -> assertEquals("FIXME", service.getContactList().get(0).getLName()),
			() -> assertEquals("0000000000", service.getContactList().get(0).getPhoneNum()),
			() -> assertEquals("FIXME", service.getContactList().get(0).getAddress()));
		
		service.newContact(testFName);
		assertAll("Service FName Test",
			() -> assertNotNull(service.getContactList().get(1).getContactId()),
			() -> assertEquals(testFName, service.getContactList().get(1).getFName()),
			() -> assertEquals("FIXME", service.getContactList().get(1).getLName()),
			() -> assertEquals("0000000000", service.getContactList().get(1).getPhoneNum()),
			() -> assertEquals("FIXME", service.getContactList().get(1).getAddress()));
			
		service.newContact(testFName, testLName);
		assertAll("Service FName/LName Test",
			() -> assertNotNull(service.getContactList().get(2).getContactId()),
			() -> assertEquals(testFName, service.getContactList().get(2).getFName()),
			() -> assertEquals(testLName, service.getContactList().get(2).getLName()),
			() -> assertEquals("0000000000", service.getContactList().get(2).getPhoneNum()),
			() -> assertEquals("FIXME", service.getContactList().get(2).getAddress()));
			
		service.newContact(testFName, testLName, testPhoneNum);
		assertAll("Service FName/LName/PhoneNum Test",
			() -> assertNotNull(service.getContactList().get(3).getContactId()),
			() -> assertEquals(testFName, service.getContactList().get(3).getFName()),
			() -> assertEquals(testLName, service.getContactList().get(3).getLName()),
			() -> assertEquals(testPhoneNum, service.getContactList().get(3).getPhoneNum()),
			() -> assertEquals("FIXME", service.getContactList().get(3).getAddress()));

		service.newContact(testFName, testLName, testPhoneNum, testAddress);
		assertAll("Service FName/LName/PhoneNum/Address Test",
			() -> assertNotNull(service.getContactList().get(4).getContactId()),
			() -> assertEquals(testFName, service.getContactList().get(4).getFName()),
			() -> assertEquals(testLName, service.getContactList().get(4).getLName()),
			() -> assertEquals(testPhoneNum, service.getContactList().get(4).getPhoneNum()),
			() -> assertEquals(testAddress, service.getContactList().get(4).getAddress()));
	}
	
	@Test
	void updateFNameTest() throws Exception {
		ContactService service = new ContactService();
		service.newContact();
		service.updateFName(service.getContactList().get(0).getContactId(), testFName);
		
		assertEquals(testFName, service.getContactList().get(0).getFName());
		assertThrows(IllegalArgumentException.class, () -> service.updateFName(service.getContactList().get(0).getContactId(), badTestFName));
		assertThrows(IllegalArgumentException.class, () -> service.updateFName(service.getContactList().get(0).getContactId(), null));
		assertThrows(IllegalArgumentException.class, () -> service.updateFName(contactId, testFName));
	}
	
	@Test
	void updateLNameTest() throws Exception {
		ContactService service = new ContactService();
		service.newContact();
		service.updateLName(service.getContactList().get(0).getContactId(), testLName);
		
		assertEquals(testLName, service.getContactList().get(0).getLName());
		assertThrows(IllegalArgumentException.class, () -> service.updateLName(service.getContactList().get(0).getContactId(), badTestLName));
		assertThrows(IllegalArgumentException.class, () -> service.updateLName(service.getContactList().get(0).getContactId(), null));
		assertThrows(IllegalArgumentException.class, () -> service.updateLName(contactId, testLName));
	}
		
	@Test
	void updatePhoneNumTest() throws Exception {
		ContactService service = new ContactService();
		service.newContact();
		service.updatePhoneNum(service.getContactList().get(0).getContactId(), testPhoneNum);
		
		assertEquals(testPhoneNum, service.getContactList().get(0).getPhoneNum());
		assertThrows(IllegalArgumentException.class, () -> service.updatePhoneNum(service.getContactList().get(0).getContactId(), shortTestPhoneNum));
		assertThrows(IllegalArgumentException.class, () -> service.updatePhoneNum(service.getContactList().get(0).getContactId(), longTestPhoneNum));
		assertThrows(IllegalArgumentException.class, () -> service.updatePhoneNum(service.getContactList().get(0).getContactId(), letterPhoneNum));
		assertThrows(IllegalArgumentException.class, () -> service.updatePhoneNum(service.getContactList().get(0).getContactId(), null));
	}
	
	@Test
	void updateAddressTest() throws Exception {
		ContactService service = new ContactService();
		service.newContact();
		service.updateAddress(service.getContactList().get(0).getContactId(), testAddress);
		
		assertEquals(testAddress, service.getContactList().get(0).getAddress());
		assertThrows(IllegalArgumentException.class, () -> service.updateAddress(service.getContactList().get(0).getContactId(), badTestAddress));
		assertThrows(IllegalArgumentException.class, () -> service.updateAddress(service.getContactList().get(0).getContactId(), null));
		assertThrows(IllegalArgumentException.class, () -> service.updateAddress(contactId, testAddress));
	}
	
	@Test
	void deleteContactTest() throws Exception {
		ContactService service = new ContactService();
		service.newContact();
		
		service.deleteContact(service.getContactList().get(0).getContactId());
		assertEquals(0, service.getContactList().size());
	}
}
	
