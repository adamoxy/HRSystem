
package adamoxy.setget;

/**
 *
 * @author adam
 */
public class UserRolInfo {

    public String name,description;
    public int id;//1,2,3,4

    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getRolname() {
        return name;
    }
    
    public void setRolname(String name) {
        this.name = name;
    }
    public String getRolDescription() {
        return description;
    }
    
    public void setRolDescription(String description) {
        this.description = description;
    }
    
}
