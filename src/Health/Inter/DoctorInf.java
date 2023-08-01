package Health.Inter;

import java.sql.SQLException;
import java.util.List;

import Health.entity.Doctor;

public interface DoctorInf {
	
	 public void addDoctor(Doctor Doctor) throws SQLException;
	 
	 public List<Doctor> getAlldoctors() throws SQLException;
	 
	 public Doctor getDoctorById(int id) throws SQLException ;
	 
	 public void updateDoctor(Doctor doctor) throws SQLException;
	 
	 public void deleteDoctor(int id) throws SQLException;

}
