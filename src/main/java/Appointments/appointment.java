package Appointments;

public class appointment {
	
	String name;
	String email;
	String mobile;
	String date;
	String dep;
	String dname;
	
	public appointment(String name, String email, String mobile, String date, String dep, String dname) {
		
		this.name = name;
		this.email = email;
		this.mobile = mobile;
		this.date = date;
		this.dep = dep;
		this.dname = dname;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getMobile() {
		return mobile;
	}

	public String getDate() {
		return date;
	}

	public String getDep() {
		return dep;
	}

	public String getDname() {
		return dname;
	}
}
