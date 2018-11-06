/**
 *
 * it contains || control over all the tables that suldemley
 * changes
 */
package adamoxy.control;

import adamoxy.database.EmployeeDataSource;
import adamoxy.database.EmployeeDtailsDataSource;
import adamoxy.database.UserRolDataSource;
import adamoxy.setget.UserRolInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author adam
 *
 */
public class AppManagerControl {

    public static ArrayList<HashMap<String, String>> Attachments() {
        EmployeeDataSource obj = new EmployeeDataSource();
        ArrayList<HashMap<String, String>> map = obj.Attachments();
        obj.close();
        return map;
    }

    public boolean insertAttachment(HashMap<String, String> hashmap) {
        EmployeeDataSource obj = new EmployeeDataSource();
        boolean flag = obj.insertAttachment(hashmap);
        obj.close();
        return flag;
    }

    public static boolean updateAttachment(HashMap<String, String> hashmap) {
        EmployeeDataSource obj = new EmployeeDataSource();
        boolean flag = obj.updateAttachment(hashmap);
        obj.close();
        return flag;
    }

    public static boolean deleteAttachment(String id) {
        EmployeeDataSource obj = new EmployeeDataSource();
        boolean flag = obj.deleteAttachment(id);
        obj.close();
        return flag;
    }

    public static List<HashMap<String, String>> nationality() {
        EmployeeDtailsDataSource obj = new EmployeeDtailsDataSource();
        List<HashMap<String, String>> list = obj.nationality();
        obj.close();
        return list;
    }

    public static ArrayList<UserRolInfo> getAllRols() {
        UserRolDataSource obj = new UserRolDataSource();
        ArrayList<UserRolInfo> list = obj.getAllRols();
        obj.close();
        return list;
    }

    public static boolean insertNewRol(String rolname, String description) {
        UserRolDataSource obj = new UserRolDataSource();
        boolean flag = obj.insertNewRol(rolname, description);
        obj.close();
        return flag;
    }

    public static boolean UpdateRolInfo(String newRolName, int rolId) {
        UserRolDataSource obj = new UserRolDataSource();
        boolean flag = obj.UpdateRolInfo(newRolName, rolId);
        obj.close();
        return flag;
    }

    public static boolean DeleteRol(int rolId) {
        UserRolDataSource obj = new UserRolDataSource();
        boolean flag = obj.DeleteRol(rolId);
        obj.close();
        return flag;
    }
}