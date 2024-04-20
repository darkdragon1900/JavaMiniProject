package userinterface;

import entity.Patient;

public class UserInterface {
	
	public void run() {
		Patient patient = new Patient("1", "Shivam", 15, "M","9960493185");
		Patient.addPatient(patient);
		
		System.out.println("Details of patients in system");
		Patient.displayAllPatients();
		
	}
}
