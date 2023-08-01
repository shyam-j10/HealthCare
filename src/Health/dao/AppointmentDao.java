package Health.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Health.Inter.AppointmentInf;
import Health.entity.Appointment;

public class AppointmentDao implements AppointmentInf {
	private static final String DB_URL = "jdbc:mysql://localhost:3306/health";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "Jn&10102003";

    private static final String INSERT_Appointment = "INSERT INTO Appointments (p_id,d_id,date1,time1,duration,type1,symptoms,status1) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String SELECT_ALL_Appointments = "SELECT * FROM Appointments";
    private static final String SELECT_Appointment_BY_ID = "SELECT * FROM Appointments WHERE a_id = ?";
    private static final String UPDATE_Appointment = "UPDATE Appointments SET p_id = ?, d_id = ?, date1 = ?,time1 = ?, duration = ?, type1 = ?, symptoms = ? ,status1= ? WHERE a_id = ?";
    private static final String DELETE_Appointment = "DELETE FROM Appointments WHERE a_id = ?";

    @Override
    public void addAppointment(Appointment Appointment) throws SQLException {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_Appointment)) {
        	
//        	preparedStatement.setInt(1, Appointment.getPid());
            preparedStatement.setInt(1, Appointment.getPid());
            preparedStatement.setInt(2, Appointment.getDid());
            preparedStatement.setDate(3,Appointment.getDate());
            preparedStatement.setTime(4,Appointment.getTime());
            preparedStatement.setTime(5,Appointment.getDuration());
            preparedStatement.setString(6,Appointment.getType());
            preparedStatement.setString(7,Appointment.getSymptoms());
            preparedStatement.setString(8,Appointment.getStatus());
            

            System.out.println("Appointment Added Successfully");
            System.out.println("------------------------");
            preparedStatement.executeUpdate();
        }
    }
    
    
    @Override
    public List<Appointment> getAllAppointments() throws SQLException {
        List<Appointment> appointments = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(SELECT_ALL_Appointments)) {

            while (resultSet.next()) {
                Appointment appointment = new Appointment();
                appointment.setAid(resultSet.getInt("a_id"));
                appointment.setDid(resultSet.getInt("d_id"));
                appointment.setPid(resultSet.getInt("p_id"));
                appointment.setDate(resultSet.getDate("date1"));
                appointment.setTime(resultSet.getTime("time1"));
                appointment.setDuration(resultSet.getTime("duration"));
                appointment.setType(resultSet.getString("type1"));
                appointment.setSymptoms(resultSet.getString("symptoms"));
                appointment.setStatus(resultSet.getString("status1"));
                
                System.out.println("Application ID:"+resultSet.getInt("a_id"));
                System.out.println("Patient ID:"+resultSet.getInt("p_id"));
                System.out.println("Doctor ID:"+resultSet.getInt("d_id"));
                System.out.println("Date:"+resultSet.getDate("date1").toLocalDate());
                System.out.println("Time:"+resultSet.getTime("time1"));
                System.out.println("Duration:"+resultSet.getTime("duration"));
                System.out.println("Type:"+resultSet.getString("type1"));
                System.out.println("Symptoms:"+resultSet.getString("symptoms"));
                System.out.println("Status:"+resultSet.getString("status1"));
                System.out.println("------------------------");

                appointments.add(appointment);
            }
        }
        return appointments;
    }

    @Override
    public Appointment getAppointmentById(int id) throws SQLException {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_Appointment_BY_ID)) {

            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    Appointment appointment = new Appointment();
                   
                    appointment.setAid(resultSet.getInt("a_id"));
                    appointment.setDid(resultSet.getInt("d_id"));
                    appointment.setPid(resultSet.getInt("p_id"));
                    appointment.setDate(resultSet.getDate("date1"));
                    appointment.setTime(resultSet.getTime("time1"));
                    appointment.setDuration(resultSet.getTime("duration"));
                    appointment.setType(resultSet.getString("type1"));
                    appointment.setSymptoms(resultSet.getString("symptoms"));
                    appointment.setStatus(resultSet.getString("status1"));
                    
                    System.out.println("Application ID:"+resultSet.getInt("a_id"));
                    System.out.println("Patient ID:"+resultSet.getInt("p_id"));
                    System.out.println("Doctor ID:"+resultSet.getInt("d_id"));
                    System.out.println("Date:"+resultSet.getDate("date1").toLocalDate());
                    System.out.println("Time:"+resultSet.getTime("time1"));
                    System.out.println("Duration:"+resultSet.getTime("duration"));
                    System.out.println("Type:"+resultSet.getString("type"));
                    System.out.println("Symptoms:"+resultSet.getString("symptoms"));
                    System.out.println("Status:"+resultSet.getString("status1"));
                    System.out.println("------------------------");


                    return appointment;
                }
            }
        }
        return null; // Appointment not found
    }

    @Override
    public void updateAppointment(Appointment Appointment) throws SQLException {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_Appointment)) {
        	
        	preparedStatement.setInt(1, Appointment.getPid());
             preparedStatement.setInt(2, Appointment.getDid());
             preparedStatement.setDate(3,Appointment.getDate());
             preparedStatement.setTime(4,Appointment.getTime());
             preparedStatement.setTime(5,Appointment.getDuration());
             preparedStatement.setString(6,Appointment.getType());
             preparedStatement.setString(7,Appointment.getSymptoms());
             preparedStatement.setString(8,Appointment.getStatus());
            
            preparedStatement.setInt(9, Appointment.getAid());

            preparedStatement.executeUpdate();
            System.out.println("Appointment Updated Successfully");
            System.out.println("------------------------");
        }
    }

    @Override
    public void deleteAppointment(int id) throws SQLException {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_Appointment)) {
            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();
            System.out.print("Appointment deleted successfully");
            System.out.println("------------------------");
        }
    }
}
