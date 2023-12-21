package doctor_management;

public class Doctor extends User {
    private String specialization;
    private String email;

    public Doctor(int id, String fname, String lname, String contactno, String specialization , String email) {
        super(id, fname, lname, contactno);
        this.specialization = specialization;
        this.email = email;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
    
    
}
