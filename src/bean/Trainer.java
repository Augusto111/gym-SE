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
    private String firstName;
    private String lastName;
    private String Gender;
    private String  age;
    private String speciaity;
    private String password;


    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getGender() {
        return Gender;
    }

    public String  getAge() {
        return age;
    }

    public String getSpeciaity() {
        return speciaity;
    }

    public String getPassword() {
        return password;
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

    public void setAge(String  age) {
        this.age = age;
    }

    public void setSpeciaity(String speciaity) {
        this.speciaity = speciaity;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Trainer(String firstName, String lastName, String Gender, String  age, String speciaity, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.Gender = Gender;
        this.age = age;
        this.speciaity = speciaity;
        this.password = password;
    }

    @Override
    public String toString() {
        return firstName  + "\n" + lastName +"\n"+ Gender + "\n" + age + "\n" + speciaity + "\n" + password;
    }
}

