package bean;

import java.io.Serializable;

public class Course_video extends Course implements Serializable{
    private String CourseType;

    public Course_video(String courseName, String trainerName, String courseInfo, String url, String courseType) {
        super(courseName, trainerName, courseInfo, url);
        CourseType = courseType;
    }

    public String getCourseType() {
        return CourseType;
    }

    public void setCourseType(String courseType) {
        CourseType = courseType;
    }


    @Override
    public String toString() {
        return "Course_video{" +
                "CourseType='" + CourseType + '\'' +
                '}';
    }
}
