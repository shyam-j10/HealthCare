package Health.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Health.Inter.DoctorInf;
import Health.entity.Doctor;

public class DoctorDao implements DoctorInf{
	
	private static final String DB_URL = "jdbc:mysql://localhost:3306/health";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "Jn&10102003";

    private static final String INSERT_Doctor = "INSERT INTO doctors (first_name, last_name, date_of_birth,gender, mobile, email, address, specialty) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String SELECT_ALL_doctors = "SELECT * FROM doctors";
    private static final String SELECT_Doctor_BY_ID = "SELECT * FROM doctors WHERE d_id = ?";
    private static final String UPDATE_Doctor = "UPDATE doctors SET first_name = ?, last_name = ?, date_of_birth = ?,gender = ?, mobile = ?, email = ?, address = ?,specialty= ? WHERE d_id = ?";
    private static final String DELETE_Doctor = "DELETE FROM doctors WHERE d_id = ?";

    @Override
    public void addDoctor(Doctor Doctor) throws SQLException {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_Doctor)) {
        	
//        	preparedStatement.setInt(1, Doctor.getPid());
            preparedStatement.setString(1, Doctor.getFirstName());
            preparedStatement.setString(2, Doctor.getLastName());
            preparedStatement.setDate(3,Doctor.getDateOfBirth());
            
            preparedStatement.setString(4, Doctor.getGender());
            preparedStatement.setString(5, Doctor.getMobile());
            preparedStatement.setString(6, Doctor.getEmail());
            preparedStatement.setString(7, Doctor.getAddress());
            preparedStatement.setString(8, Doctor.getSpecialty());

            System.out.println("Doctor Added Successfully");
            System.out.println("------------------------");
            preparedStatement.executeUpdate();
        }
    }

    @Override
    public List<Doctor> getAlldoctors() throws SQLException {
        List<Doctor> doctors = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(SELECT_ALL_doctors)) {

            while (resultSet.next()) {
                Doctor doctor = new Doctor();
                doctor.setDid(resultSet.getInt("d_id"));
                doctor.setFirstName(resultSet.getString("first_name"));
                doctor.setLastName(resultSet.getString("last_name"));
                doctor.setDateOfBirth(resultSet.getDate("date_of_birth"));
                doctor.setGender(resultSet.getString("gender"));
                doctor.setMobile(resultSet.getString("mobile"));
                doctor.setEmail(resultSet.getString("email"));
                doctor.setAddress(resultSet.getString("address"));
                doctor.setSpecialty(resultSet.getString("specialty"));
                
                System.out.println("ID:"+resultSet.getInt("d_id"));
                System.out.println("First Name:"+resultSet.getString("first_name"));
                System.out.println("Last Name:"+resultSet.getString("last_name"));
                System.out.println("DOB:"+resultSet.getDate("date_of_birth").toLocalDate());
                System.out.println("Gender:"+resultSet.getString("gender"));
                System.out.println("Mobile:"+resultSet.getString("mobile"));
                System.out.println("Email:"+resultSet.getString("email"));
                System.out.println("Address:"+resultSet.getString("address"));
                System.out.println("Specialty:"+resultSet.getString("specialty"));
                System.out.println("------------------------");

                doctors.add(doctor);
            }
        }
        return doctors;
    }

    @Override
    public Doctor getDoctorById(int id) throws SQLException {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_Doctor_BY_ID)) {

            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    Doctor doctor = new Doctor();
                    doctor.setDid(resultSet.getInt("d_id"));
                    doctor.setFirstName(resultSet.getString("first_name"));
                    doctor.setLastName(resultSet.getString("last_name"));
                    doctor.setDateOfBirth(resultSet.getDate("date_of_birth"));
                    doctor.setGender(resultSet.getString("gender"));
                    doctor.setMobile(resultSet.getString("mobile"));
                    doctor.setEmail(resultSet.getString("email"));
                    doctor.setAddress(resultSet.getString("address"));
                    doctor.setSpecialty(resultSet.getString("specialty"));
                    
                    System.out.println("ID:"+resultSet.getInt("d_id"));
                    System.out.println("First Name:"+resultSet.getString("first_name"));
                    System.out.println("Last Name:"+resultSet.getString("last_name"));
                    System.out.println("DOB:"+resultSet.getDate("date_of_birth").toLocalDate());
                    System.out.println("Gender:"+resultSet.getString("gender"));
                    System.out.println("Mobile:"+resultSet.getString("mobile"));
                    System.out.println("Email:"+resultSet.getString("email"));
                    System.out.println("Address:"+resultSet.getString("address"));
                    System.out.println("Specialty:"+resultSet.getString("specialty"));
                    System.out.println("------------------------");
                    
                    return doctor;
                }
            }
        }
        return null; // Doctor not found
    }

    @Override
    public void updateDoctor(Doctor doctor) throws SQLException {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_Doctor)) {
        	preparedStatement.setString(1, doctor.getFirstName());
            preparedStatement.setString(2, doctor.getLastName());
            preparedStatement.setDate(3,doctor.getDateOfBirth());
            
            preparedStatement.setString(4, doctor.getGender());
            preparedStatement.setString(5, doctor.getMobile());
            preparedStatement.setString(6, doctor.getEmail());
            preparedStatement.setString(7, doctor.getAddress());
            preparedStatement.setString(8, doctor.getSpecialty());
            
            preparedStatement.setInt(9, doctor.getDid());

            preparedStatement.executeUpdate();
            System.out.println("Doctor Updated Successfully");
            System.out.println("------------------------");
        }
    }

    @Override
    public void deleteDoctor(int id) throws SQLException {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_Doctor)) {
            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();
            System.out.print("Doctor deleted successfully");
            System.out.println("------------------------");
        }
    }

}
