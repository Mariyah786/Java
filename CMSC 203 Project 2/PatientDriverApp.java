package patient;

import java.util.Scanner;

public class PatientDriverApp {
	
	
	public static void displayPatient(Patient patient) {
        System.out.println("Patient Information:");
        System.out.println("Full Name: " + patient.buildFullName());
        System.out.println("Address: " + patient.buildAddress());
        System.out.println("Phone Number: " + patient.getPhoneNumber());
        System.out.println("Emergency Contact: " + patient.buildEmergencyContact());
        System.out.println(); // Blank line for separation
    }

    // Method to display procedure information
    public static void displayProcedure(Procedure procedure) {
        
        System.out.println("\tProcedure Name: " + procedure.getProcedureName());
        System.out.println("\tDate: " + procedure.getDate());
        System.out.println("\tPractitioner: " + procedure.GetPractitioner());
        System.out.println("\tCharges: $" + procedure.GetCharges());
        System.out.println(); // Blank line for separation
    }

    // Method to calculate total charges of procedures
    public static double calculateTotalCharges(Procedure procedure1, Procedure procedure2, Procedure procedure3) {
        double totalCharges = procedure1.GetCharges() + procedure2.GetCharges() + procedure3.GetCharges();
        return totalCharges;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Getting patient information from the user
        System.out.println("Enter patient's first name:");
        String firstName = scanner.nextLine();
        
        System.out.println("Enter patient's middle name:");
        String middleName = scanner.nextLine();
        
        System.out.println("Enter patient's last name:");
        String lastName = scanner.nextLine();
        
        System.out.println("Enter patient's street address:");
        int streetAddress = Integer.parseInt(scanner.nextLine());
        
        System.out.println("Enter patient's city:");
        String city = scanner.nextLine();
        
        System.out.println("Enter patient's state:");
        String state = scanner.nextLine();
        
        System.out.println("Enter patient's ZIP code:");
        int zip = Integer.parseInt(scanner.nextLine());
        
        System.out.println("Enter patient's phone number:");
        String phoneNumber = scanner.nextLine();
        
        System.out.println("Enter emergency contact name:");
        String emergencyContactName = scanner.nextLine();
        
        System.out.println("Enter emergency contact phone number:");
        String emergencyContactNum = scanner.nextLine();

        // Creating an instance of Patient with user-provided data
        Patient patient = new Patient(firstName, middleName, lastName, streetAddress, city, state, zip, phoneNumber, emergencyContactName, emergencyContactNum);

        // Creating instances of Procedure
        // Using no-arg constructor
        Procedure procedure1 = new Procedure(); 
        procedure1.SetProcedureName("MRI");
        procedure1.SetDate("06/15/2025");
        procedure1.SetPractitioner("Dr. Lee");
        procedure1.SetCharges(450.0);
        
        // Using constructor with procedure name and date
        Procedure procedure2 = new Procedure("CT Scan", "01/30/2025"); 
        procedure2.SetPractitioner("Dr. Adams");
        procedure2.SetCharges(1100.0);
        
        // Using constructor with all attributes
        Procedure procedure3 = new Procedure("Ultrasound", "03/11/2024", "Dr. Ken", 1400.0);
        
        //	displayPatient: This method given a patient object will display patient’s information.

        // Displaying patient and procedure information
        displayPatient(patient);
        displayProcedure(procedure1);
        displayProcedure(procedure2);
        displayProcedure(procedure3);
        
        double totalCharges = calculateTotalCharges(procedure1, procedure2, procedure3);
        System.out.println("Total Charges for all procedures: $" + totalCharges);
        
        System.out.println("\n Student Name: Mariyah Shahmalak \n MC#: M21168924 \n Due Date: 01-01-24");
        
        
        scanner.close();
    }
}
