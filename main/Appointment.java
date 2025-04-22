package com.main;

import java.util.Date;

public class Appointment{
	
	final private byte Appt_ID_Length;
	final private byte Appt_Desc_Length;
	final private String Initial;
	private String apptId;
	private Date apptDate;
	private String desc;
	
	{
	Appt_ID_Length = 10;
	Appt_Desc_Length = 50;
	Initial = "FIX ME";
	}
	
	public Appointment() {
		Date today = new Date();
		apptId = Initial;
		apptDate = today;
		desc = Initial;
	}
	
	public Appointment(String id) {
		Date today = new Date();
		updateApptId(id);
		apptDate = today;
		desc = Initial;
	}
	
	public Appointment(String id, Date date) {
		updateApptId(id);
		updateDate(date);
		desc = Initial;
	}
	
	public Appointment(String id, Date date, String desc) {
		updateApptId(id);
		updateDate(date);
		updateDesc(desc);
	}
	
	public String getApptId() {
		return apptId;
	}
	
	public void updateApptId(String id) {
		if(id == null) {
			throw new IllegalArgumentException("Appointment ID cannot be blank");
		}
		else if(id.length() > Appt_ID_Length) {
			throw new IllegalArgumentException("Appointment ID must not be more then " + Appt_ID_Length + " characters.");
		}
		else {
			this.apptId = id;
		}
	}
	
	public Date getApptDate() {
		return apptDate;
	}
	
	public void updateDate(Date date) {
		if (date == null) {
		      throw new IllegalArgumentException("Appointment date cannot be empty.");
		    } 
		else if (date.before(new Date())) {
		      throw new IllegalArgumentException("Cannot make appointment in the past.");
		    } 
		else {
		      this.apptDate = date;
		    }
	}
	
	public String getDesc() {
		return desc;
	}
	
	public void updateDesc(String desc) {
		if (desc == null) {
		      throw new IllegalArgumentException("Appointment description cannot be empty.");
		    } 
		else if (desc.length() > Appt_Desc_Length) {
		      throw new IllegalArgumentException("Appointment description must not be more then " + Appt_Desc_Length + " characters.");
		    } 
		else {
		      this.desc = desc;
		    }
	}
}