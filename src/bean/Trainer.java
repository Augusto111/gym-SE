package bean;

import java.io.Serializable;

/**
 * @author GeAo&ZhaoYiFan
 * @date 2021-4-23
 */
public class Trainer implements Serializable {
    /**
     *
     */
//    private static final long serialVersionUID = -5075336075423229986L;
    private String PtID;
    private String firstName;
    private String lastName;
    private String Gender;
    private int age;
    private String speciaity;
    private String password;

    public String getPtID() {
        return PtID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getGender() {
        return Gender;
    }

    public int getAge() {
        return age;
    }

    public String getSpeciaity() {
        return speciaity;
    }

    public String getPassword() {
        return password;
    }

    public void setPtID(String ptID) {
        this.PtID = ptID;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setGender(String gender) {
        this.Gender = gender;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSpeciaity(String speciaity) {
        this.speciaity = speciaity;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Trainer(String PtID, String firstName, String lastName, String Gender, int age, String speciaity, String password) {
        this.PtID = PtID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.Gender = Gender;
        this.age = age;
        this.speciaity = speciaity;
        this.password = password;
    }

    @Override
    public String toString() {
        return firstName  + lastName +"\n"+ Gender + "\n" + age + "\n" + speciaity + "\n" + password;
    }
}

