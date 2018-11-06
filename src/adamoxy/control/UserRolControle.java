package adamoxy.control;

import adamoxy.database.UserRolDataSource;
import adamoxy.setget.UserRolInfo;
import adamoxy.setget.UsersInfo;

/**
 *
 * @author adam
 */
public class UserRolControle {

    
    public static UserRolInfo getRolById(String id) {
        UserRolDataSource obj = new UserRolDataSource();
        UserRolInfo urol = obj.getRolById(id);
        obj.close();
        return urol;
    }

    public static UsersInfo getAllUsersInRoleInfo(int id) {
        UserRolDataSource obj = new UserRolDataSource();
        UsersInfo userinfo = obj.getAllUsersInRoleInfo(id);
        obj.close();
        return userinfo;
    }

}
