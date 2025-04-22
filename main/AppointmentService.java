package com.main;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class AppointmentService {

	final private List<Appointment> apptList = new ArrayList<>();
	private String uniqueId;
	
	public String newUniqueId(){
	    uniqueId = UUID.randomUUID().toString().replace("-", "").substring(0, 10);
	    return uniqueId;
	}
	
	public void newAppt() {
	    Appointment appt = new Appointment(newUniqueId());
	    apptList.add(appt);
	  }
	
	public void newAppt(Date date) {
	    Appointment appt = new Appointment(newUniqueId(), date);
	    apptList.add(appt);
	  }
	
	public void newAppt(Date date, String desc) {
		Appointment appt = new Appointment(newUniqueId(), date, desc);
		apptList.add(appt);
	  }
	
	public List<Appointment> getApptList() {
		return apptList;
	}
	
	public Appointment searchAppt(String id) throws Exception {
		int index = 0;
	    while (index < apptList.size()) {
	      if (id.equals(apptList.get(index).getApptId())) {
	        return apptList.get(index);
	      }
	      index++;
	    }
	    throw new Exception("The appointment does not exist.");
	}
	
	public void deleteAppt(String id) throws Exception {
	    apptList.remove(searchAppt(id));
	  }
} 
