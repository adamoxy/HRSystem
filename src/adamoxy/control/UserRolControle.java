package adamoxy.control;

import adamoxy.common.log;
import adamoxy.database.UserRolDataSource;
import adamoxy.setget.UserRolInfo;
import adamoxy.setget.UsersInfo;
import java.util.ArrayList;

/**
 *
 * @author adam
 */
public class UserRolControle {

    /*
        public UserRolInfo getRolById(String id) {
     */
    public static UserRolInfo getRolById(String id) {
        UserRolDataSource obj = new UserRolDataSource();
        UserRolInfo urol = null;
        try {
            urol = obj.getRolById(id);
            
        } catch (Exception e) {
            log.writeEvent(e.toString());
        }
        return urol;
    }

    /*    public ArrayList<UserRolInfo> getAllRols() {}
     */
    public static ArrayList<UserRolInfo> getAllRols() {
        UserRolDataSource obj = new UserRolDataSource();
        ArrayList<UserRolInfo> list = null;
        try {
            list = obj.getAllRols();

        } catch (Exception e) {
            log.writeEvent(e.toString());
        }
        return list;
    }

    /*    public UsersInfo getAllUsersInRoleInfo(int id) {}
     */
    public static UsersInfo getAllUsersInRoleInfo(int id) {
        UserRolDataSource obj = new UserRolDataSource();
        UsersInfo userinfo = null;
        try {
            userinfo = obj.getAllUsersInRoleInfo(id);

        } catch (Exception e) {
            log.writeEvent(e.toString());
        }
        return userinfo;
    }

    /*    public boolean insertNewRol(String rolname,String description) {}
     */
    public static boolean insertNewRol(String rolname, String description) {
        UserRolDataSource obj = new UserRolDataSource();
        boolean flag = false;
        try {
            flag = obj.insertNewRol(rolname, description);
        } catch (Exception e) {
            log.writeEvent(e.toString());
        }
        return flag;
    }

    /*    public boolean UpdateRolInfo(String newRolName, int rolId) {}
     */
    public static boolean UpdateRolInfo(String newRolName, int rolId) {
        UserRolDataSource obj = new UserRolDataSource();
        boolean flag = false;
        try {
            flag = obj.UpdateRolInfo(newRolName, rolId);

        } catch (Exception e) {
            log.writeEvent(e.toString());
        }
        return flag;
    }

    /*    public boolean DeleteRol(int rolId) {}
     */
    public static boolean DeleteRol(int rolId) {
        UserRolDataSource obj = new UserRolDataSource();
        boolean flag = false;
        try {
            flag = obj.DeleteRol(rolId);

        } catch (Exception e) {
            log.writeEvent(e.toString());
        }
        return flag;
    }
}
