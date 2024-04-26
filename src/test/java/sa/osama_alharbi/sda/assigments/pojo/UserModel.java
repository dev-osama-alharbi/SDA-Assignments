package sa.osama_alharbi.sda.assigments.pojo;

public class UserModel {
    /*
    {
          "name": "Tenali Ramakrishna",
          "gender": "male",
          "email": "tenali.ramakrishna1@15ce.com",
          "status": "active"
        }
     */

    private String name;
    private String gender;
    private String email;
    private String status;

    public UserModel() {
    }

    public UserModel(String name, String gender, String email, String status) {
        this.name = name;
        this.gender = gender;
        this.email = email;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", email='" + email + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
