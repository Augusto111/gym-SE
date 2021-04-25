package bean;

import java.io.Serializable;

/**
 * @author Viskaz
 * @date 2020-03-31 11:35
 */
public class User implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = -5075336075423229986L;
    private String userid;
    private String firstname;
	private String lastname;
    private String sex;
    private Integer age;
    private String interested;
    private String password;
    private String telephone;
    private Integer cardType;
    private Integer courseBalance;
    private Integer type;
    private Integer balance;

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getInterested() {
        return interested;
    }

    public void setInterested(String interested) {
        this.interested = interested;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Integer getCardType() {
        return cardType;
    }

    public void setCardType(Integer cardType) {
        this.cardType = cardType;
    }

    public Integer getCourseBalance() {
        return courseBalance;
    }

    public void setCourseBalance(Integer courseBalance) {
        this.courseBalance = courseBalance;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "userid='" + userid + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", interested='" + interested + '\'' +
                ", password='" + password + '\'' +
                ", telephone='" + telephone + '\'' +
                ", cardType=" + cardType +
                ", courseBalance=" + courseBalance +
                ", type=" + type +
                ", balance=" + balance +
                '}';
    }
}

