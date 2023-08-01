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

import Health.abs.PatientAbs;
import Health.entity.Patient;

public class PatientDao extends PatientAbs {
	
	private static final String DB_URL = "jdbc:mysql://localhost:3306/health";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "Jn&10102003";

    private static final String INSERT_PATIENT = "INSERT INTO patients (first_name, last_name, date_of_birth,height,weight,gender, mobile, email, address) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String SELECT_ALL_PATIENTS = "SELECT * FROM patients";
    private static final String SELECT_PATIENT_BY_ID = "SELECT * FROM patients WHERE p_id = ?";
    private static final String UPDATE_PATIENT = "UPDATE patients SET first_name = ?, last_name = ?, date_of_birth = ?, height = ?,weight= ?,gender = ?, mobile = ?, email = ?, address = ? WHERE p_id = ?";
    private static final String DELETE_PATIENT = "DELETE FROM patients WHERE p_id = ?";

    public void addPatient(Patient patient) throws SQLException {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PATIENT)) {
        	
//        	preparedStatement.setInt(1, patient.getPid());
            preparedStatement.setString(1, patient.getFirstName());
            preparedStatement.setString(2, patient.getLastName());
            preparedStatement.setDate(3,patient.getDateOfBirth());
            preparedStatement.setInt(4, patient.getHeight());
            preparedStatement.setInt(5,patient.getWeight() );
            
            preparedStatement.setString(6, patient.getGender());
            preparedStatement.setString(7, patient.getMobile());
            preparedStatement.setString(8, patient.getEmail());
            preparedStatement.setString(9, patient.getAddress());

            System.out.println("Patient Added Successfully");
            System.out.println("------------------------");
            preparedStatement.executeUpdate();
        }
    }

    public List<Patient> getAllPatients() throws SQLException {
        List<Patient> patients = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(SELECT_ALL_PATIENTS)) {

            while (resultSet.next()) {
                Patient patient = new Patient();
                patient.setPid(resultSet.getInt("p_id"));
                patient.setFirstName(resultSet.getString("first_name"));
                patient.setLastName(resultSet.getString("last_name"));
                patient.setDateOfBirth(resultSet.getDate("date_of_birth"));
                patient.setHeight(resultSet.getInt("height"));
                patient.setWeight(resultSet.getInt("weight"));
                patient.setGender(resultSet.getString("gender"));
                patient.setMobile(resultSet.getString("mobile"));
                patient.setEmail(resultSet.getString("email"));
                patient.setAddress(resultSet.getString("address"));
                
                System.out.println("ID:"+resultSet.getInt("p_id"));
                System.out.println("First Name:"+resultSet.getString("first_name"));
                System.out.println("Last Name:"+resultSet.getString("last_name"));
                System.out.println("DOB:"+resultSet.getDate("date_of_birth").toLocalDate());
                System.out.println("Height:"+resultSet.getInt("height"));
                System.out.println("Weight:"+resultSet.getInt("weight"));
                System.out.println("Gender:"+resultSet.getString("gender"));
                System.out.println("Mobile:"+resultSet.getString("mobile"));
                System.out.println("Email:"+resultSet.getString("email"));
                System.out.println("Address:"+resultSet.getString("address"));
                System.out.println("------------------------");

                patients.add(patient);
            }
        }
        return patients;
    }

    public Patient getPatientById(int id) throws SQLException {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PATIENT_BY_ID)) {

            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    Patient patient = new Patient();
                    patient.setPid(resultSet.getInt("p_id"));
                    patient.setFirstName(resultSet.getString("first_name"));
                    patient.setLastName(resultSet.getString("last_name"));
                    patient.setDateOfBirth(resultSet.getDate("date_of_birth"));
                    patient.setHeight(resultSet.getInt("height"));
                    patient.setWeight(resultSet.getInt("weight"));
                    patient.setGender(resultSet.getString("gender"));
                    patient.setMobile(resultSet.getString("mobile"));
                    patient.setEmail(resultSet.getString("email"));
                    patient.setAddress(resultSet.getString("address")); 
                    
                    System.out.println("ID:"+resultSet.getInt("p_id"));
                    System.out.println("First Name:"+resultSet.getString("first_name"));
                    System.out.println("Last Name:"+resultSet.getString("last_name"));
                    System.out.println("DOB:"+resultSet.getDate("date_of_birth").toLocalDate());
                    System.out.println("Height:"+resultSet.getInt("height"));
                    System.out.println("Weight:"+resultSet.getInt("weight"));
                    System.out.println("Gender:"+resultSet.getString("gender"));
                    System.out.println("Mobile:"+resultSet.getString("mobile"));
                    System.out.println("Email:"+resultSet.getString("email"));
                    System.out.println("Address:"+resultSet.getString("address"));
                    System.out.println("------------------------");
                    return patient;
                }
            }
        }
        return null; // Patient not found
    }

    public void updatePatient(Patient patient) throws SQLException {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_PATIENT)) {
            preparedStatement.setString(1, patient.getFirstName());
            preparedStatement.setString(2, patient.getLastName());
            preparedStatement.setDate(3,patient.getDateOfBirth());
            preparedStatement.setInt(4, patient.getHeight());
            preparedStatement.setInt(5,patient.getWeight() );
            
            preparedStatement.setString(6, patient.getGender());
            preparedStatement.setString(7, patient.getMobile());
            preparedStatement.setString(8, patient.getEmail());
            preparedStatement.setString(9, patient.getAddress());
           
            preparedStatement.setInt(10, patient.getPid());

            preparedStatement.executeUpdate();
            System.out.println("Patient Updated Successfully");
            System.out.println("------------------------");
        }
    }

    public void deletePatient(int id) throws SQLException {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_PATIENT)) {
            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();
            System.out.print("Patient deleted successfully");
            System.out.println("------------------------");
        }
    }

}
