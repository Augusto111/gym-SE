package bean;
import java.io.Serializable;

public class Course implements Serializable{
    private String CourseName;
    private String TrainerName;
    private String CourseInfo;
    private String url;

    public Course(String courseName, String trainerName, String courseInfo, String url) {
        CourseName = courseName;
        TrainerName = trainerName;
        CourseInfo = courseInfo;
        this.url = url;
    }

    @Override
    public String toString() {
        return "Course{" +
                "CourseName='" + CourseName + '\'' +
                ", TrainerID='" + TrainerName + '\'' +
                ", CourseInfo='" + CourseInfo + '\'' +
                ", url='" + url + '\'' +
                '}';
    }

    public String getCourseName() {
        return CourseName;
    }

    public String getTrainerName() {
        return TrainerName;
    }

    public String getCourseInfo() {
        return CourseInfo;
    }

    public String getUrl() {
        return url;
    }

    public void setCourseName(String courseName) {
        CourseName = courseName;
    }

    public void setTrainerName(String trainerName) {
        TrainerName = trainerName;
    }

    public void setCourseInfo(String courseInfo) {
        CourseInfo = courseInfo;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
