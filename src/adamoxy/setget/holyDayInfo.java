
package adamoxy.setget;

/**
 *
 * @author adam
 */
public class holyDayInfo {
//username email password rolid status createdAt
    public String username;
    public String email;
    public String password;
    public int rolid,id;//1,2,3,4
    public String status;//active or inactive
    public String createdAt;//date

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public int getRolid() {
        return rolid;
    }

    public void setRolid(int rolid) {
        this.rolid = rolid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getCreatedAt() {
        return createdAt;
    }
}
