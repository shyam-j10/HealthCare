package Health.abs;

import java.sql.SQLException;
import java.util.List;

import Health.entity.Patient;

public abstract class PatientAbs {
	public abstract void addPatient(Patient patient) throws SQLException;
	
	public abstract List<Patient> getAllPatients() throws SQLException;
	
	public abstract Patient getPatientById(int id) throws SQLException;
	

	public  abstract void updatePatient(Patient patient) throws SQLException ;
	 
	public abstract void deletePatient(int id) throws SQLException;
}
