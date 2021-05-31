package bean;

import java.io.Serializable;

public class BookCourse implements Serializable {
    private static final long serialVersionUID = -5075336075423229986L;
    private String userid;
    private String coursename;

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getCoursename() {
        return coursename;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename;
    }

    @Override
    public String toString() {
        return "BookCourse{" +
                "userid='" + userid + '\'' +
                ", coursename='" + coursename + '\'' +
                '}';
    }
}
