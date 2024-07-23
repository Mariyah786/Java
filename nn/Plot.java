/*
 * Class: CMSC203 
 * Instructor: Professor Grinberg
 * Description: The Plot class represents a rectangular area defined by its x and y coordinates, width, and depth. It includes methods for setting and getting these values, as well as checking for overlaps and encompassment with other Plot objects.
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

public class Plot {
	    // Instance variables
	    private int x;
	    private int y;
	    private int width;
	    private int depth;

	    // Constructors
	    public Plot() {
	        this.x = 0;
	        this.y = 0;
	        this.width = 1;
	        this.depth = 1;
	    }

	    public Plot(int x, int y, int width, int depth) {
	        this.x = x;
	        this.y = y;
	        this.width = width;
	        this.depth = depth;
	    }

	    public Plot(Plot otherPlot) {
	        this.x = otherPlot.x;
	        this.y = otherPlot.y;
	        this.width = otherPlot.width;
	        this.depth = otherPlot.depth;
	    }

	    // Getter methods
	    public int getX() {
	        return x;
	    }

	    public int getY() {
	        return y;
	    }

	    public int getWidth() {
	        return width;
	    }

	    public int getDepth() {
	        return depth;
	    }

	    // Setter methods
	    public void setX(int x) {
	        this.x = x;
	    }

	    public void setY(int y) {
	        this.y = y;
	    }

	    public void setWidth(int width) {
	        this.width = width;
	    }

	    public void setDepth(int depth) {
	        this.depth = depth;
	    }
	    
	    
	    
	    
	    
	    @Override
	    public boolean equals(Object obj) {
	        if (this == obj) {
	            return true;
	        }
	        if (obj == null || getClass() != obj.getClass()) {
	            return false;
	        }
	        Plot plot = (Plot) obj;
	        return x == plot.x &&
	               y == plot.y &&
	               width == plot.width &&
	               depth == plot.depth;
	    }

	    @Override
	    public int hashCode() {
	        return Objects.hash(x, y, width, depth);
	    }

	
	

	    
	    
	    
	    
	    
	    
	    // Method to check if this plot overlaps with another plot
	    public boolean overlaps(Plot otherPlot) {
	        // Check if one rectangle is on left side of other
	        if (this.x + this.width <= otherPlot.x || otherPlot.x + otherPlot.width <= this.x) {
	            return false;
	        }
	        // Check if one rectangle is above other
	        if (this.y + this.depth <= otherPlot.y || otherPlot.y + otherPlot.depth <= this.y) {
	            return false;
	        }
	        return true;
	    }

	    // Method to check if this plot encompasses another plot
	    public boolean encompasses(Plot otherPlot) {
	        return (this.x <= otherPlot.x && this.y <= otherPlot.y &&
	                this.x + this.width >= otherPlot.x + otherPlot.width &&
	                this.y + this.depth >= otherPlot.y + otherPlot.depth);
	    }

	    // toString method to represent the plot instance
	    @Override
	    public String toString() {
	        return x + "," + y + "," + width + "," + depth;
	    }
	}


