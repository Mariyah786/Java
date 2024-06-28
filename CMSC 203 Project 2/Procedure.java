package patient;

public class Procedure {
	private String procedureName;
	private String date;
	private String practitioner;
	private double charges;
	//a no-arg constructor
	public Procedure(){
		this.procedureName = "Unknown";
		this.date = "00/00/00";
		this.practitioner = "Unknown";
		this.charges = 0.0;
}
	
	//	a parametrized constructor that initializes procedure’s name and date to the given values
	
	public Procedure(String procedureName, String date) {
		this.procedureName = procedureName;
		this.date = date;
		this.practitioner = "Unknown";
		this.charges = 0.0;
	}
	
	// a parametrized constructor that initializes all attributes of the procedure to the given values
	
	public Procedure(String procedureName, String date, String practitioner, double charges) {
		this.procedureName = procedureName;
		this.date = date;
		this.practitioner = practitioner;
		this.charges = charges; 
	}
	
	//	an accessor for each attribute
	
	public String getProcedureName() {
		return procedureName;
	}
	public String getDate() {
		return date;
	}
	public String GetPractitioner() {
		return practitioner;
	}
	public double GetCharges() {
		return charges;
	}
	
	//a mutator for each attribute 
	
	public void SetProcedureName(String procedureName) {
		this.procedureName = procedureName;
	}
	public void SetDate(String date) {
		this.date = date;
	}
	public void SetPractitioner(String practitioner) {
		this.practitioner = practitioner;
	}
	public void SetCharges(double charges) {
		this.charges = charges;
	}
	
	// a toString method that display all information of a procedure
	
	
	public String toString() {
        return "Procedure{" +
                "procedureName='" + procedureName + '\'' +
                ", Date='" + date + '\'' +
                ", practitioner='" + practitioner + '\'' +
                ", charges=" + charges +
                '}';
    }
}