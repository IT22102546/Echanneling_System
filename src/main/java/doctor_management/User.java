package doctor_management;

public class User {
    private int id;
    private String fname;
    private String lname;
    private String contactno;

    public User(int id, String fname, String lname, String contactno) {
        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.contactno = contactno;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getContactno() {
        return contactno;
    }

    public void setContactno(String contactno) {
        this.contactno = contactno;
    }
}
