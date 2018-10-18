
package adamoxy.setget;

/**
 *
 * @author adam
 */
public class DepartmentInfo {

    public String departname, description;
    public int id, power;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setDeptname(String departname) {
        this.departname = departname;
    }

    public String getDeptname() {
        return departname;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getPower() {
        return power;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
