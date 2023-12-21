package Contactus;

public class contact {
	
	String uname;
	String email;
	String subject;
	String message;
	public contact(String uname, String email, String subject, String message) {
		
		this.uname = uname;
		this.email = email;
		this.subject = subject;
		this.message = message;
	}
	public String getUname() {
		return uname;
	}
	public String getEmail() {
		return email;
	}
	public String getSubject() {
		return subject;
	}
	public String getMessage() {
		return message;
	}
	

}
