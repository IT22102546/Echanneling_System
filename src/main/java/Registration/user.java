package Registration;

public class user {

	
	protected String fname;
	protected String lname;
	protected String uname;
	protected String address;
	protected String email;
	protected String mobile;
	protected String password;
	
	
	public user(String fname, String lname, String uname, String address, String email, String mobile,String password) {
		
		this.fname = fname;
		this.lname = lname;
		this.uname = uname;
		this.address = address;
		this.email = email;
		this.mobile = mobile;
		this.password = password;
	}
	
	
	
	public String getFname() {
		return fname;
	}

	public String getLname() {
		return lname;
	}

	public String getUname() {
		return uname;
	}

	public String getAddress() {
		return address;
	}

	public String getEmail() {
		return email;
	}

	public String getMobile() {
		return mobile;
	}

	public String getPassword() {
		return password;
	}

	
}
