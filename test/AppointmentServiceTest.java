package com.test;


import static org.junit.jupiter.api.Assertions.*;

import java.util.Calendar;
import java.util.Date;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.main.AppointmentService;

public class AppointmentServiceTest {
	
	private String id, desc, longDesc;
	private Date date, pastDate;
	
	@SuppressWarnings("deprecation")
	  @BeforeEach
	  void intitial() {
	    id = "0000000001";
	    desc = "This is a proper Test Description";
	    date = new Date(2026, Calendar.JANUARY, 1);
	    longDesc ="This description is to test the application for entering a description greater then 50 characters.";
	    pastDate = new Date(0);
	  }
	
	@Test
	  void testNewAppt() {
	    AppointmentService service = new AppointmentService();

	    service.newAppt();
	    assertNotNull(service.getApptList().get(0).getApptId());
	    assertNotNull(service.getApptList().get(0).getApptDate());
	    assertNotNull(service.getApptList().get(0).getDesc());

	    service.newAppt(date);
	    assertNotNull(service.getApptList().get(1).getApptId());
	    assertEquals(date, service.getApptList().get(1).getApptDate());
	    assertNotNull(service.getApptList().get(1).getDesc());

	    service.newAppt(date, desc);
	    assertNotNull(service.getApptList().get(2).getApptId());
	    assertEquals(date, service.getApptList().get(2).getApptDate());
	    assertEquals(desc, service.getApptList().get(2).getDesc());

	    assertNotEquals(service.getApptList().get(0).getApptId(), service.getApptList().get(1).getApptId());
	    assertNotEquals(service.getApptList().get(0).getApptId(), service.getApptList().get(2).getApptId());
	    assertNotEquals(service.getApptList().get(1).getApptId(), service.getApptList().get(2).getApptId());

	    assertThrows(IllegalArgumentException.class, () -> service.newAppt(pastDate));
	    assertThrows(IllegalArgumentException.class, () -> service.newAppt(date, longDesc));
	  }
	
	@Test
	  void deleteAppointment() throws Exception {
	    AppointmentService service = new AppointmentService();

	    service.newAppt();
	    service.newAppt();
	    service.newAppt();

	    String Id1 = service.getApptList().get(0).getApptId();
	    String Id2 = service.getApptList().get(1).getApptId();
	    String Id3 = service.getApptList().get(2).getApptId();

	    assertNotEquals(Id1, Id2);
	    assertNotEquals(Id1, Id3);
	    assertNotEquals(Id2, Id3);
	    assertNotEquals(id, Id1);
	    assertNotEquals(id, Id2);
	    assertNotEquals(id, Id3);

	    assertThrows(Exception.class, () -> service.deleteAppt(id));

	    service.deleteAppt(Id1);
	    assertThrows(Exception.class, () -> service.deleteAppt(Id1));
	    assertNotEquals(Id1, service.getApptList().get(0).getApptId());
	  }

}
