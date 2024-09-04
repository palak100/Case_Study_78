package MyPackage.model;

public class Student {
    private int studentId;
    private String name;
    private String dateOfBirth;
    private String address;
    private String email;

    // Constructor
    public Student() {
    }

    public Student(int studentId, String name, String dateOfBirth, String email, String address) {
        this.studentId = studentId;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.address = address;
    }

    // Getters and Setters
    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name){
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
        return "Student [studentId=" + studentId + ", name=" + name + ", dateOfBirth=" + dateOfBirth + ", address=" + address + ", email=" + email + "]";
    }
}
