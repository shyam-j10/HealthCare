package Health.application;

import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.util.Scanner;

import Health.dao.AppointmentDao;
import Health.dao.DoctorDao;
import Health.dao.PatientDao;
import Health.dao.UserDao;
import Health.entity.Appointment;
import Health.entity.Doctor;
import Health.entity.Patient;
import Health.entity.User;


public class Main {

	public static void main(String[] args) throws SQLException {
		
		
		Scanner sc=new Scanner(System.in);
		int pd;
		do{
			System.out.println("----- HEALTHCARE BOOKING SYSTEM -----");
			System.out.println("1. Patient Menu");
			System.out.println("2. Health Care Provider Menu");
			System.out.println("3. Exit");
			
			System.out.print("Enter your choice:");
			pd=Integer.parseInt(sc.nextLine());
			
			
			if(pd==1) {
				System.out.println("----- PATIENT MENU -----");
				System.out.println("1. Add Patient");
				System.out.println("2. Get All Patients");
				System.out.println("3. Get Patient By Id");
				System.out.println("4. Update Patient");
				System.out.println("5. Delete Patient");
				System.out.println("6. Add Appointments");
				System.out.print("Enter your choice:");
				int inp=Integer.parseInt(sc.nextLine());
				
		        //Adding Patient
				Patient patient=new Patient();
				PatientDao patientDao=new PatientDao();
				Appointment appointment=new Appointment();
				AppointmentDao appointmentDao=new AppointmentDao();
				switch(inp) {
					case 1:
						
						System.out.print("Enter firstname:");
						String fname=sc.nextLine();
						
						System.out.print("Enter lastname:");
						String lname=sc.nextLine();
						
						System.out.print("Enter dob:");
						Date date=Date.valueOf(sc.nextLine());
						
						System.out.print("Enter height:");
						int height=Integer.parseInt(sc.nextLine());
						
						System.out.print("Enter weight:");
						int weight=Integer.parseInt(sc.nextLine());
						
						System.out.print("Enter gender:");
						String gender=sc.nextLine();
						
						System.out.print("Enter mobile:");
						String mobile=sc.nextLine();
						
						System.out.print("Enter mail:");
						String mail=sc.nextLine();
						
						System.out.print("Enter address:");
						String address=sc.nextLine();
	
						patient.setFirstName(fname);
						patient.setLastName(lname);
						patient.setDateOfBirth(date);
						patient.setHeight(height);
						patient.setWeight(weight);
						patient.setGender(gender);
						patient.setMobile(mobile);
						patient.setEmail(mail);
						patient.setAddress(address);
						  
						patientDao.addPatient(patient);
						  
						break;
						
					case 2:				
						//GetAllPatients
						patientDao.getAllPatients();
						
						break;
					
					case 3:
						System.out.print("Enter patient id ");
						int check=Integer.parseInt(sc.nextLine());
						//GetById
						patientDao.getPatientById(check);
						break;
					
					case 4:
						System.out.print("Enter firstname:");
						String fname1=sc.nextLine();
						
						System.out.print("Enter lastname:");
						String lname1=sc.nextLine();
						
						System.out.print("Enter dob:");
						Date date1=Date.valueOf(sc.nextLine());
						
						System.out.print("Enter height:");
						int height1=Integer.parseInt(sc.nextLine());
						
						System.out.print("Enter weight:");
						int weight1=Integer.parseInt(sc.nextLine());
						
						System.out.print("Enter gender:");
						String gender1=sc.nextLine();
						
						System.out.print("Enter mobile:");
						String mobile1=sc.nextLine();
						
						System.out.print("Enter mail:");
						String mail1=sc.nextLine();
						
						System.out.print("Enter address:");
						String address1=sc.nextLine();
						
						System.out.print("Enter id to be updated");
						int id=Integer.parseInt(sc.nextLine());
					
						patient.setPid(id);
						patient.setFirstName(fname1);
						patient.setLastName(lname1);
						patient.setDateOfBirth(date1);
						patient.setHeight(height1);
						patient.setWeight(weight1);
						patient.setGender(gender1);
						patient.setMobile(mobile1);
						patient.setEmail(mail1);
						patient.setAddress(address1);
						  
						patientDao.updatePatient(patient);
						  
						break;
						
						
					case 5:
						System.out.println("Enter id to be deleted");
						int id1=sc.nextInt();
						patientDao.deletePatient(id1);
						break;
					
					case 6:
						System.out.print("Enter Patient_Id:");
						int pid=Integer.parseInt(sc.nextLine());
						
						System.out.print("Enter Doctor_Id:");
						int did=Integer.parseInt(sc.nextLine());
						
						System.out.print("Enter date of appointment:");
						Date date2=Date.valueOf(sc.nextLine());
						
						System.out.print("Enter time of appointment:");
						Time time2=Time.valueOf(sc.nextLine());
	
						
						System.out.print("Enter duration of appointment:");
						Time duration=Time.valueOf(sc.nextLine());
						
						System.out.print("Enter type of appointment:");
						String type=sc.nextLine();
						
						System.out.print("Enter symptoms:");
						String symptoms=sc.nextLine();
						
						System.out.print("Enter status:");
						String status=sc.nextLine();
	
						appointment.setPid(pid);
						appointment.setDid(did);
						appointment.setDate(date2);
						appointment.setTime(time2);
						appointment.setDuration(duration);
						appointment.setType(type);
						appointment.setSymptoms(symptoms);
						appointment.setStatus(status);
						  
						appointmentDao.addAppointment(appointment);
					
					 
				}
	        
			}else if(pd==2) {
				System.out.println("----- HEALTHCARE PROVIDER MENU -----");
				System.out.println("1. Add Doctor");
				System.out.println("2. Get All Doctors");
				System.out.println("3. Get Doctor By Id");
				System.out.println("4. Update Doctor");
				System.out.println("5. Delete Doctor");
				System.out.println("6. View Appointments");
				System.out.println("7. Update Appointments");
				System.out.println("8. Delete Appointments");
				
				System.out.print("Enter your choice:");
				int inp=Integer.parseInt(sc.nextLine());
				
				Doctor doctor=new Doctor();
				DoctorDao doctorDao=new DoctorDao();
				Appointment appointment=new Appointment();
				AppointmentDao appointmentDao=new AppointmentDao();
				
				switch(inp) {
				case 1:
					
					System.out.print("Enter firstname:");
					String fname=sc.nextLine();
					
					System.out.print("Enter lastname:");
					String lname=sc.nextLine();
					
					System.out.print("Enter dob:");
					Date date=Date.valueOf(sc.nextLine());
					
					
					System.out.print("Enter gender:");
					String gender=sc.nextLine();
					
					System.out.print("Enter mobile:");
					String mobile=sc.nextLine();
					
					System.out.print("Enter mail:");
					String mail=sc.nextLine();
					
					System.out.print("Enter address:");
					String address=sc.nextLine();
				
					System.out.print("Enter speciality:");
					String specialty=sc.nextLine();
					
					doctor.setFirstName(fname);
					doctor.setLastName(lname);
					doctor.setDateOfBirth(date);
					doctor.setGender(gender);
					doctor.setMobile(mobile);
					doctor.setEmail(mail);
					doctor.setAddress(address);
					doctor.setSpecialty(specialty);
					  
					doctorDao.addDoctor(doctor);
					  
					break;
					
				case 2:				
					//GetAlldoctors
					doctorDao.getAlldoctors();
					
					break;
				
				case 3:
					System.out.println("Enter doctor id ");
					int check=Integer.parseInt(sc.nextLine());
					//GetById
					doctorDao.getDoctorById(check);
					break;
				
				case 4:
					System.out.print("Enter firstname:");
					String fname1=sc.nextLine();
					
					System.out.print("Enter lastname:");
					String lname1=sc.nextLine();
					
					System.out.print("Enter dob:");
					Date date1=Date.valueOf(sc.nextLine());
					
					
					System.out.print("Enter gender:");
					String gender1=sc.nextLine();
					
					System.out.print("Enter mobile:");
					String mobile1=sc.nextLine();
					
					System.out.print("Enter mail:");
					String mail1=sc.nextLine();
					
					System.out.print("Enter address:");
					String address1=sc.nextLine();
					
					System.out.print("Enter specialty:");
					String specialty1=sc.nextLine();
					
					System.out.print("Enter id to be updated");
					int id=Integer.parseInt(sc.nextLine());
				
					doctor.setDid(id);
					doctor.setFirstName(fname1);
					doctor.setLastName(lname1);
					doctor.setDateOfBirth(date1);
					doctor.setGender(gender1);
					doctor.setMobile(mobile1);
					doctor.setEmail(mail1);
					doctor.setAddress(address1);
					doctor.setSpecialty(specialty1);
					  
					doctorDao.updateDoctor(doctor);
					  
					break;
					
					
				case 5:
					System.out.println("Enter doctor id to be deleted");
					int id1=sc.nextInt();
					doctorDao.deleteDoctor(id1);
					break;
					
				case 6:
					appointmentDao.getAllAppointments();
					break;
					
				case 7:
					System.out.print("Enter Patient_Id:");
					int pid=Integer.parseInt(sc.nextLine());
					
					System.out.print("Enter Doctor_Id:");
					int did=Integer.parseInt(sc.nextLine());
					
					System.out.print("Enter date of appointment:");
					Date date2=Date.valueOf(sc.nextLine());
					
					System.out.print("Enter time of appointment:");
					Time time2=Time.valueOf(sc.nextLine());
	
					
					System.out.print("Enter duration of appointment:");
					Time duration=Time.valueOf(sc.nextLine());
					
					System.out.print("Enter type of appointment:");
					String type=sc.nextLine();
					
					System.out.print("Enter symptoms:");
					String symptoms=sc.nextLine();
					
					System.out.print("Enter status:");
					String status=sc.nextLine();
					
					System.out.print("Enter application id to be updated");
					int aid=Integer.parseInt(sc.nextLine());
	
					appointment.setAid(aid);
					appointment.setPid(pid);
					appointment.setDid(did);
					appointment.setDate(date2);
					appointment.setTime(time2);
					appointment.setDuration(duration);
					appointment.setType(type);
					appointment.setSymptoms(symptoms);
					appointment.setStatus(status);
					  
					appointmentDao.updateAppointment(appointment);
					
					break;
					
				case 8:
					System.out.println("Enter application id to be deleted");
					int id2=sc.nextInt();
					appointmentDao.deleteAppointment(id2);
					break;
				}	
				
			}else if(pd==3) {				
				System.out.println("Exiting the Application");
				return;
			}
			else {
				System.out.println("Wrong Choice Entered");
			}
		}while(pd!=3);
        
	}

}
