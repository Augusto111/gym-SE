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
	private String username;
    private String email, telephone;
    private boolean isPM;

    public String getUserid() {
        return userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public boolean isPM() {
        return isPM;
    }

    public void setPM(boolean isPM) {
        this.isPM = isPM;
    }


    public User(String id, String username, String email, String telephone, boolean isPM, int virtualStamps) {
        this.userid = id;
        this.username = username;
        this.email = email;
        this.telephone = telephone;
        this.isPM = isPM;
    }
    @Override
    public String toString() {
        return "User{" +
                "userid='" + userid + '\'' +
                "username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", telephone='" + telephone + '\'' +
                ", isPM=" + isPM +
                '}';
    }
}

