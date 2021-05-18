package bean;

import java.io.Serializable;

public class Course_live extends Course implements Serializable {
    private String Time;
    private String UserName;
    private String AdmName;

    public Course_live(String courseName, String trainerName, String courseInfo, String url, String time, String userName, String admName) {
        super(courseName, trainerName, courseInfo, url);
        Time = time;
        UserName = userName;
        AdmName = admName;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getAdmName() {
        return AdmName;
    }

    public void setAdmName(String admName) {
        AdmName = admName;
    }

    @Override
    public String toString() {
        return "Course_live{" +
                "Time='" + Time + '\'' +
                ", UserID='" + UserName + '\'' +
                ", AdmID='" + AdmName + '\'' +
                '}';
    }
}
