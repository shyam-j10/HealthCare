package Health.Inter;

import java.sql.SQLException;
import java.util.List;

import Health.entity.Appointment;

public interface AppointmentInf {
	public void addAppointment(Appointment Appointment) throws SQLException;
	
	public List<Appointment> getAllAppointments() throws SQLException;
	
	public Appointment getAppointmentById(int id) throws SQLException ;
	
	public void updateAppointment(Appointment Appointment) throws SQLException ;
	
	public void deleteAppointment(int id) throws SQLException;
}
