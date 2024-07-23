/*
 * Class: CMSC203 
 * Instructor: Professor Grinberg
 * Description: The Property class represents a rental property with attributes like property name, city, rent amount, owner, and plot dimensions. It includes methods for setting and getting these values, as well as constructors for different initialization scenarios and a toString method to represent the property details as a string.
 * Due: 07/23/24
 * Platform/compiler:
 * I pledge that I have completed the programming 
assignment independently. 
 * I have not copied the code from a student or any source. 
 * I have not given my code to any student.
 * Print your Name here: Mariyah Shahmalak
*/

package application;

import java.util.Objects;

public class Property {
    // Instance variables
    private String propertyName;
    private String city;
    private double rentAmount;
    private String owner;
    private Plot plot;

    // Default constructor
    public Property() {
        this.propertyName = "";
        this.city = "";
        this.rentAmount = 0.0;
        this.owner = "";
        this.plot = new Plot();
    }

    // Constructor with basic property details
    public Property(String propertyName, String city, double rentAmount, String owner) {
        this.propertyName = propertyName;
        this.city = city;
        this.rentAmount = rentAmount;
        this.owner = owner;
        this.plot = new Plot(); // Default plot
    }

    // Constructor with all details including Plot
    public Property(String propertyName, String city, double rentAmount, String owner, Plot plot) {
        this.propertyName = propertyName;
        this.city = city;
        this.rentAmount = rentAmount;
        this.owner = owner;
        this.plot = new Plot(plot);
    }

    // Constructor with all details including Plot dimensions
    public Property(String propertyName, String city, double rentAmount, String owner, int x, int y, int width, int depth) {
        this.propertyName = propertyName;
        this.city = city;
        this.rentAmount = rentAmount;
        this.owner = owner;
        this.plot = new Plot(x, y, width, depth);
    }

    // Copy constructor
    public Property(Property otherProperty) {
        this.propertyName = otherProperty.propertyName;
        this.city = otherProperty.city;
        this.rentAmount = otherProperty.rentAmount;
        this.owner = otherProperty.owner;
        this.plot = new Plot(otherProperty.plot);
    }

    // Getter methods
    public String getPropertyName() {
        return propertyName;
    }

    public String getCity() {
        return city;
    }

    public double getRentAmount() {
        return rentAmount;
    }

    public String getOwner() {
        return owner;
    }

    public Plot getPlot() {
        return plot;
    }

    // Setter methods
    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setRentAmount(double rentAmount) {
        this.rentAmount = rentAmount;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public void setPlot(Plot plot) {
        this.plot = plot;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Property other = (Property) obj;
        return Double.compare(other.rentAmount, rentAmount) == 0 &&
               Objects.equals(propertyName, other.propertyName) &&
               Objects.equals(city, other.city) &&
               Objects.equals(owner, other.owner) &&
               Objects.equals(plot, other.plot);
    }

    @Override
    public int hashCode() {
        return Objects.hash(propertyName, city, rentAmount, owner, plot);
    }

    // toString method to represent a Property instance
    @Override
    public String toString() {
        return String.format("Property %s,%s,%s,%.1f", propertyName, city, owner, rentAmount);
    }

}
