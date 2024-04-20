package driver;

import userinterface.UserInterface;
import validation.ValidationUtils;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import entity.Doctor;
import entity.Patient;
import operation.Hospital;

	
	public class HospitalManagementSystem {
	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);

	        // Create Hospital object
	        Hospital hospital = new Hospital();

	        int choice;
	        do {
	            // Display menu
	            System.out.println("\nHospital Management System Menu:");
	            System.out.println("1. Add Patient");
	            System.out.println("2. Add Doctor");
	            System.out.println("3. Display All Patients");
	            System.out.println("4. Display All Doctors");
	            System.out.println("5. Schedule Appointment");
	            System.out.println("6. Exit");
	            System.out.print("Enter your choice: ");
	            
	            // Read user choice
	            choice = scanner.nextInt();
	            
	            // Process user choice
	            switch (choice) {
	                case 1:
	                    addPatient(scanner, hospital);
	                    break;
	                case 2:
	                    addDoctor(scanner, hospital);
	                    break;
	                case 3:
	                    hospital.displayAllPatients();
	                    break;
	                case 4:
	                    hospital.displayAllDoctors();
	                    break;
	                case 5:
	                    scheduleAppointment(scanner, hospital);
	                    break;
	                case 6:
	                    System.out.println("Exiting...");
	                    break;
	                default:
	                    System.out.println("Invalid choice. Please enter a number between 1 and 6.");
	            }
	        } while (choice != 6);

	        // Close scanner
	        scanner.close();
	    }

	    private static void addPatient(Scanner scanner, Hospital hospital) {
	        // Prompt user to add patients
	        System.out.println("Enter patient details (ID, Name, Age, Gender, Contact Number):");
	        String patientId = scanner.next();
	        // Validate patient ID
	        if (!ValidationUtils.isValidPatientId(patientId, hospital.getPatients())) {
	            System.out.println("Invalid patient ID. Please enter a unique 4-character alphanumeric ID.");
	            return;
	        }
	        String patientName = scanner.next();
	        int age = scanner.nextInt();
	        String gender = scanner.next();
	        String contactNumber = scanner.next();
	        Patient patient = new Patient(patientId, patientName, age, gender, contactNumber);
	        hospital.addPatient(patient);
	        System.out.println("Patient added successfully.");
	    }

	    private static void addDoctor(Scanner scanner, Hospital hospital) {
	        // Prompt user to add doctors
	        System.out.println("Enter doctor details (ID, Name, Specialization, Contact Number):");
	        String doctorId = scanner.next();
	        // Validate doctor ID
	        if (!ValidationUtils.isValidDoctorId(doctorId, hospital.getDoctors())) {
	            System.out.println("Invalid doctor ID. Please enter a unique 4-character alphanumeric ID.");
	            return;
	        }
	        String doctorName = scanner.next();
	        String specialization = scanner.next();
	        String doctorContactNumber = scanner.next();
	        Doctor doctor = new Doctor(doctorId, doctorName, specialization, doctorContactNumber);
	        hospital.addDoctor(doctor);
	        System.out.println("Doctor added successfully.");
	    }

	    private static void scheduleAppointment(Scanner scanner, Hospital hospital) {
	        // Prompt user to schedule appointments
	        System.out.println("Schedule an appointment (Patient ID, Doctor ID, Appointment Date):");
	        String appointmentDateString = scanner.next();
	        // Validate appointment date
	        if (!ValidationUtils.isValidAppointmentDate(appointmentDateString)) {
	            System.out.println("Invalid appointment date format. Please enter the date in YYYY-MM-DD format.");
	            return;
	        }
	        Date appointmentDate;
	        try {
	            appointmentDate = new SimpleDateFormat("yyyy-MM-dd").parse(appointmentDateString);
	        } catch (ParseException e) {
	            System.out.println("Invalid appointment date format.");
	            return;
	        }
	       
	    }
	
}


