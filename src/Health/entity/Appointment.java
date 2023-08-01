package Health.entity;

import java.sql.Date;
import java.sql.Time;

public class Appointment {
	private int aid;
	private int pid;
	private int did;
	
	private Date date;
	private Time time;
	private Time duration;
	private String type;
	private String symptoms;
	private String status;
	

	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public int getDid() {
		return did;
	}

	public void setDid(int did) {
		this.did = did;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}

	public Time getDuration() {
		return duration;
	}

	public void setDuration(Time duration) {
		this.duration = duration;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSymptoms() {
		return symptoms;
	}

	public void setSymptoms(String symptoms) {
		this.symptoms = symptoms;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}


	public Appointment(int aid, int pid, int did, Date date, Time time, Time duration, String type,
			String symptoms, String status) {
		super();
		this.aid = aid;
		this.pid = pid;
		this.did = did;
		this.date = date;
		this.time = time;
		this.duration = duration;
		this.type = type;
		this.symptoms = symptoms;
		this.status = status;
	}

	public Appointment() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Appointment [aid=" + aid + ", pid=" + pid + ", did=" + did + ", date=" + date + ", time=" + time
				+ ", duration=" + duration + ", type=" + type + ", symptoms=" + symptoms + ", status=" + status
				+ "]";
	}
	
	
}
