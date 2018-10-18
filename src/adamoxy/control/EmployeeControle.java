
package adamoxy.control;

import adamoxy.common.log;
import adamoxy.database.EmployeeDataSource;
import adamoxy.setget.UsersInfo;
import java.util.ArrayList;

/**
 *
 * @author adam
 */
public class EmployeeControle {

    /*
        public ArrayList<UsersInfo> getAllEmployees() {}
     */
    public static ArrayList<UsersInfo> getAllEmployees() {
        EmployeeDataSource obj = new EmployeeDataSource();
        ArrayList list = null;
        try {
            list = obj.getAllEmployees();

        } catch (Exception e) {
            log.writeEvent(e.toString());
        }
        return list;
    }

    /*
        public UsersInfo getEmployeeInfo(int id) {}
     */
    public static UsersInfo getEmployeeInfo(int id) {
        EmployeeDataSource obj = new EmployeeDataSource();
        UsersInfo userinfo = null;
        try {
            userinfo = obj.getEmployeeInfo(id);
        } catch (Exception e) {
            log.writeEvent(e.toString());
        }
        return userinfo;
    }

    /*
        public boolean insertNewEmployee(UsersInfo userInfo) {}
     */
    public static boolean insertNewEmployee(UsersInfo userInfo) {
        EmployeeDataSource obj = new EmployeeDataSource();
        boolean flag = false;
        try {
            flag = obj.insertNewEmployee(userInfo);

        } catch (Exception e) {
            log.writeEvent(e.toString());
        }

        return flag;
    }

    /*
        public boolean UpdateEmployeeInfo(UsersInfo userInfo) {}
     */
    public static boolean UpdateEmployeeInfo(UsersInfo userInfo) {
        EmployeeDataSource obj = new EmployeeDataSource();
        boolean flag = obj.UpdateEmployeeInfo(userInfo);
        try {

        } catch (Exception e) {
            log.writeEvent(e.toString());
        }
        return flag;
    }
    /*
    
     */
}
