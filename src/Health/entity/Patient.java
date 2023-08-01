package Health.entity;

import java.sql.Date;
import java.time.LocalDate;

public class Patient {
	private int pid;
	private String firstName;
	private String lastName;
	private Date dateOfBirth;

	private int height;
	private int weight;
	private String gender;
	private String mobile;
	private String email;
	private String address;
	
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	
	
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String mail) {
		this.email = mail;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	


	@Override
	public String toString() {
		return "Patient [pid=" + pid + ", firstName=" + firstName + ", lastName=" + lastName + ", dateOfBirth="
				+ dateOfBirth + ", height=" + height + ", weight=" + weight + ", gender=" + gender + ", mobile="
				+ mobile + ", email=" + email + ", address=" + address + "]";
	}
	public Patient(int pid, String firstName, String lastName, Date dateOfBirth, int height, int weight,
			String gender, String mobile, String email, String address) {
		super();
		this.pid = pid;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.height = height;
		this.weight = weight;
		this.gender = gender;
		this.mobile = mobile;
		this.email = email;
		this.address = address;
	}
	public Patient() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
