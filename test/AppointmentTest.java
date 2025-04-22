package com.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Calendar;
import java.util.Date;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.main.Appointment;

public class AppointmentTest {
	
	private String id, desc, longId, longDesc;
	private Date date, pastDate;
	
	@SuppressWarnings("deprecation")
	  @BeforeEach
	  void intitial() {
	    id = "0000000001";
	    desc = "This is a proper Test Description";
	    date = new Date(2026, Calendar.JANUARY, 1);
	    longId = "000000000132";
	    longDesc ="This description is to test the application for entering a description greater then 50 characters.";
	    pastDate = new Date(0);
	  }
	
	@Test
	  void testGetApptId() {
	    Appointment appt = new Appointment(id);
	    assertNotNull(appt.getApptId());
	    assertEquals(appt.getApptId().length(), 10);
	    assertEquals(id, appt.getApptId());
	  }
	
	@Test
	  void testUpdateApptId() {
	    Appointment appt = new Appointment();
	    assertThrows(IllegalArgumentException.class, () -> appt.updateApptId(null));
	    assertThrows(IllegalArgumentException.class, () -> appt.updateApptId(longId));
	    appt.updateApptId(id);
	    assertEquals(id, appt.getApptId());
	  }
	
	@Test
	  void testGetApptDate() {
	    Appointment appt = new Appointment(id, date);
	    assertNotNull(appt.getApptDate());
	    assertEquals(date, appt.getApptDate());
	  }
	
	@Test
	  void testUpdateDate() {
	    Appointment appt = new Appointment();
	    assertThrows(IllegalArgumentException.class, () -> appt.updateDate(null));
	    assertThrows(IllegalArgumentException.class, () -> appt.updateDate(pastDate));
	    appt.updateDate(date);
	    assertEquals(date, appt.getApptDate());
	  }
	
	@Test
	  void testGetDesc() {
	    Appointment appt = new Appointment(id, date, desc);
	    assertNotNull(appt.getDesc());
	    assertTrue(appt.getDesc().length() <= 50);
	    assertEquals(desc, appt.getDesc());
	  }
	
	@Test
	  void testUpdateDesc() {
	    Appointment appt = new Appointment();
	    assertThrows(IllegalArgumentException.class, () -> appt.updateDesc(null));
	    assertThrows(IllegalArgumentException.class, () -> appt.updateDesc(longDesc));
	    appt.updateDesc(desc);
	    assertEquals(desc, appt.getDesc());
	  }

}
