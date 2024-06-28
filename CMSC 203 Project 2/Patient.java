package patient;

public class Patient {
    // First name, middle name, and last name
    private String firstName;
    private String middleName;
    private String lastName; 

    // Street Address, city, state, and ZIP code
    private int streetAddress;
    private String city;
    private String state; 
    private int zip;

    // Phone number (example 301-123-4567)
    private String phoneNumber;

    // Name and phone number of emergency contact
    private String emergencyContactName;
    private String emergencyContactNum;

    // No-arg constructor
    public Patient(){
        this.firstName = "Jane";
        this.middleName = "Larry";
        this.lastName = "Doe";
        this.streetAddress = 12345;
        this.city = "city";
        this.state = "zz";
        this.zip = 12345;
        this.phoneNumber = "000-000-0000";
        this.emergencyContactName = "Jane Doe";
        this.emergencyContactNum = "000-000-0000";
    }

    // Parameterized constructor that initializes patient’s first, middle and last name to the given values
    public Patient(String firstName, String middleName, String lastName) {
        this.firstName = firstName;
        this.middleName = middleName; 
        this.lastName = lastName;
        this.streetAddress = 12345;
        this.city = "city";
        this.state = "zz";
        this.zip = 12345;
        this.phoneNumber = "000-000-0000";
        this.emergencyContactName = "Jane Doe";
        this.emergencyContactNum = "000-000-0000";
    }

    // Parameterized constructor that initializes all attributes of the patient to the given values
    public Patient(String firstName, String middleName, String lastName, int streetAddress, String city, String state, int zip, String phoneNumber, String emergencyContactName, String emergencyContactNum) {
        this.firstName = firstName;
        this.middleName = middleName; 
        this.lastName = lastName;
        this.streetAddress = streetAddress;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phoneNumber = phoneNumber;
        this.emergencyContactName = emergencyContactName;
        this.emergencyContactNum = emergencyContactNum;
    }

    // Accessor for each attribute
    public String getFirstName() {
        return firstName; 
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName; 
    }

    public int getStreetAddress() {
        return streetAddress;
    }

    public String getCity() {
        return city;
    }

    public String getState(){
        return state;
    }

    public int getZip() {
        return zip;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmergencyContactName() {
        return emergencyContactName;
    }

    public String getEmergencyContactNum() {
        return emergencyContactNum;
    }

    // Mutator for each attribute
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setStreetAdress(int streetAddress) {
        this.streetAddress = streetAddress;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmergencyContactName(String emergencyContactName) {
        this.emergencyContactName = emergencyContactName;
    }

    public void setEmergencyContactNum(String emergencyContactNum) {
        this.emergencyContactNum = emergencyContactNum;
    }

    // Method to build the full name
    public String buildFullName() {
        return firstName + " " + middleName + " " + lastName;
    }

    // Method to build the address
    public String buildAddress() {
        return streetAddress + " " + city + " " + state + " " + zip;
    }

    // Method to build the emergency contact
    public String buildEmergencyContact() {
        return emergencyContactName + " " + emergencyContactNum;
    }

    // toString method that displays all information of a patient
    @Override
    public String toString() {
        return "Patient Information:\n" +
               "Full Name: " + buildFullName() + "\n" +
               "Address: " + buildAddress() + "\n" +
               "Phone Number: " + phoneNumber + "\n" +
               "Emergency Contact: " + buildEmergencyContact();
    }
}
