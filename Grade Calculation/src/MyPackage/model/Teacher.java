package MyPackage.model;

public class Teacher {
    private int teacherId;
    private String name;
    private String address;
    private String email;
    private String dateOfBirth;

    // Constructor
    public Teacher(){}
    
    public Teacher(int teacherId, String name, String address, String email, String dateOfBirth){
        this.teacherId = teacherId;
        this.name = name;
        this.address = address;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
    }

    // Getters and Setters
    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Teacher [teacherId=" + teacherId + ", name=" + name + ", dateOfBirth=" + dateOfBirth + ", address=" + address + ", email=" + email + "]";
    }
}
