package MyPackage.model;

public class Course {
    private int courseId;
    private String title;
    private String description;
    private int teacherId;

    // Constructor
    public Course(){}

    public Course(int courseId, String title, String description, int teacherId){
        this.courseId = courseId;
        this.title = title;
        this.description = description;
        this.teacherId = teacherId;
    }

    // Getters and Setters
    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    @Override
    public String toString() {
        return "Course [courseId=" + courseId + ", title=" + title + ", description=" + description + ", teacherId=" + teacherId + "]";
    }
}
