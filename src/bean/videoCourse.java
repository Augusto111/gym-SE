package bean;

import java.io.Serializable;

public class videoCourse implements Serializable{
    private String CourseName;
    private String CourseType;
    private String CourseInfo;
    private String url;

    public videoCourse(String courseName, String courseType, String courseInfo, String url) {
        this.CourseName = courseName;
        CourseType = courseType;
        CourseInfo = courseInfo;
        this.url = url;
    }

    public String getCourseName() {
        return CourseName;
    }

    public String getCourseType() {
        return CourseType;
    }

    public String getCourseInfo() {
        return CourseInfo;
    }

    public String getUrl() {
        return url;
    }

    public void setCourseName(String courseName) {
        this.CourseName = courseName;
    }

    public void setCourseType(String courseType) {
        CourseType = courseType;
    }

    public void setCourseInfo(String courseInfo) {
        CourseInfo = courseInfo;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Video{" +
                "PMname='" + CourseName + '\'' +
                ", CourseType='" + CourseType + '\'' +
                ", CourseInfo='" + CourseInfo + '\'' +
                ", ImagePath='" + url + '\'' +
                '}';
    }
}
