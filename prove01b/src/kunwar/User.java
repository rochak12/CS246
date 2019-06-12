package kunwar;

public class User {
    private String password;
    private String salt;
    private String hashvalue;

    User (String initialPassword){
        password = initialPassword;
    }


    public String getSalt() {
        return salt;
    }

    public String getPassword() {
        return password;
    }

    public String getHashedPassword() {
        return hashvalue;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }


    public void setHashedPassword(String hashString) {
        this.hashvalue = hashString;
    }
}
