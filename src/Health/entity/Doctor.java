package Health.entity;

import java.sql.Date;
import java.time.LocalDate;

public class Doctor {
	private int did;
	private String firstName;
	private String lastName;
	private Date dateOfBirth;

	private String gender;
	private String mobile;
	private String email;
	private String address;
	private String specialty;
	public int getDid() {
		return did;
	}
	public void setDid(int did) {
		this.did = did;
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
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getSpecialty() {
		return specialty;
	}
	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}
	
	@Override
	public String toString() {
		return "Doctor [did=" + did + ", firstName=" + firstName + ", lastName=" + lastName + ", dateOfBirth="
				+ dateOfBirth + ", gender=" + gender + ", mobile=" + mobile + ", email=" + email + ", address="
				+ address + ", specialty=" + specialty + "]";
	}
	public Doctor(int did, String firstName, String lastName, Date dateOfBirth, String gender, String mobile,
			String email, String address, String specialty) {
		super();
		this.did = did;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.mobile = mobile;
		this.email = email;
		this.address = address;
		this.specialty = specialty;
	}
	public Doctor() {
		super();
		// TODO Auto-generated constructor stub
	}
	



	
	
	
	
}
