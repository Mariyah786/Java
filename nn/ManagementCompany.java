/*
 * Class: CMSC203 
 * Instructor: Professor Grinberg
 * Description:The ManagementCompany class manages properties, handling their addition, removal, and calculation of total rent. It also provides functionalities to retrieve information about properties, validate the management fee, and represent the company and its properties as a string. 
 * Due: 07/23/24
 * Platform/compiler:
 * I pledge that I have completed the programming 
assignment independently. 
 * I have not copied the code from a student or any source. 
 * I have not given my code to any student.
 * Print your Name here: Mariyah Shahmalak
*/
package application;

import java.util.Arrays;
import java.util.Objects;

public class ManagementCompany {

    // Instance variables
    private String name;
    private String taxID;
    private double managementFee;
    private Property[] properties;
    private Plot plot;
    private int numberOfProperties;

    // Constant class variables
    public static final int MAX_PROPERTY = 5;
    public static final int MGMT_WIDTH = 10;
    public static final int MGMT_DEPTH = 10;

    // Constructors
    public ManagementCompany() {
        this.name = "";
        this.taxID = "";
        this.managementFee = 0;
        this.plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
        this.properties = new Property[MAX_PROPERTY];
        this.numberOfProperties = 0;
    }

    public ManagementCompany(String name, String taxID, double managementFee) {
        this.name = name;
        this.taxID = taxID;
        this.managementFee = managementFee;
        this.plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
        this.properties = new Property[MAX_PROPERTY];
        this.numberOfProperties = 0;
    }

    public ManagementCompany(String name, String taxID, double managementFee, int x, int y, int width, int depth) {
        this.name = name;
        this.taxID = taxID;
        this.managementFee = managementFee;
        this.plot = new Plot(x, y, width, depth);
        this.properties = new Property[MAX_PROPERTY];
        this.numberOfProperties = 0;
    }

    // Getter and Setter methods
    public String getName() {
        return name;
    }

    public String getTaxID() {
        return taxID;
    }

    public double getManagementFee() {
        return managementFee;
    }

    public Plot getPlot() {
        return new Plot(0, 0, 1, 1); // Ensure these default values are correct
    }


    public int getNumberOfProperties() {
        return numberOfProperties;
    }

    // Method to add property
    public int addProperty(Property property) {
        if (numberOfProperties >= MAX_PROPERTY) return -1;
        if (property == null) return -2;
        if (!plot.encompasses(property.getPlot())) return -3;
        for (int i = 0; i < numberOfProperties; i++) {
            if (properties[i].getPlot().overlaps(property.getPlot())) return -4;
        }
        properties[numberOfProperties] = property;
        numberOfProperties++;
        return numberOfProperties - 1;
    }

    public int addProperty(String name, String city, double rent, String owner) {
        return addProperty(new Property(name, city, rent, owner));
    }

    public int addProperty(String name, String city, double rent, String owner, int x, int y, int width, int depth) {
        return addProperty(new Property(name, city, rent, owner, x, y, width, depth));
    }

    // Method to get total rent
    public double getTotalRent() {
        double totalRent = 0;
        for (int i = 0; i < numberOfProperties; i++) {
            totalRent += properties[i].getRentAmount();
        }
        return totalRent;
    }

    // Method to get the property with the highest rent
    public Property getHighestRentProperty() {
        if (numberOfProperties == 0) return null;
        Property highestRentProperty = properties[0];
        for (int i = 1; i < numberOfProperties; i++) {
            if (properties[i].getRentAmount() > highestRentProperty.getRentAmount()) {
                highestRentProperty = properties[i];
            }
        }
        return highestRentProperty;
    }

    // Method to remove the last property
    public void removeLastProperty() {
        if (numberOfProperties > 0) {
            properties[numberOfProperties - 1] = null;
            numberOfProperties--;
        }
    }

    // Method to check if properties array is full
    public boolean isPropertiesFull() {
        return numberOfProperties >= MAX_PROPERTY;
    }

    // Method to get the count of properties
    public int getPropertiesCount() {
        return numberOfProperties;
    }

    // Method to check if management fee is valid
    public boolean isManagementFeeValid() {
        return managementFee >= 0 && managementFee <= 100;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        ManagementCompany that = (ManagementCompany) obj;
        return Double.compare(that.managementFee, managementFee) == 0 &&
                name.equals(that.name) &&
                taxID.equals(that.taxID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, taxID, managementFee);
    }
    
    // toString method to get information of all properties
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("List of the properties for ").append(name).append(", taxID: ").append(taxID).append("\n");
        sb.append("______________________________________________________\n");
        for (int i = 0; i < numberOfProperties; i++) {
            sb.append(properties[i].getPropertyName()).append(",")
              .append(properties[i].getCity()).append(",")
              .append(properties[i].getOwner()).append(",")
              .append(String.format("%.2f", properties[i].getRentAmount())).append("\n");
        }
        sb.append("______________________________________________________\n");
        sb.append(" total management Fee: ").append(String.format("%.2f", getTotalRent() * (managementFee / 100))).append("\n");
        return sb.toString();
    }


}
