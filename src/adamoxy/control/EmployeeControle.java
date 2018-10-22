package adamoxy.control;

import adamoxy.common.log;
import adamoxy.database.EmployeeDataSource;
import adamoxy.setget.EmployeeInfo;
import adamoxy.setget.TempPoJo;
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
    public static EmployeeInfo getEmployeeInfoById(int id) {
        EmployeeDataSource obj = new EmployeeDataSource();
        EmployeeInfo empinfo = null;
        try {
            empinfo = obj.getEmployeeInfoById(id);
        } catch (Exception e) {
            log.writeEvent(e.toString());
        }
        return empinfo;
    }

    /*
        public boolean insertNewEmployee(UsersInfo userInfo) {}
     */
    public static TempPoJo insertNewEmployee(EmployeeInfo empinfo) {
        EmployeeDataSource obj = new EmployeeDataSource();
        TempPoJo temp = new TempPoJo();
        int flag = 0;
        try {
            temp = obj.insertNewEmployee(empinfo);

        } catch (Exception e) {
            log.writeEvent("EmployeeControle > insertNewEmployee : " + e.toString());
        }

        return temp;
    }

    /*
        public boolean UpdateEmployeeInfo(UsersInfo userInfo) {}
     */
    public static boolean UpdateEmployeeInfo(EmployeeInfo empinfo) {
        EmployeeDataSource obj = new EmployeeDataSource();
        boolean flag = false;
        try {
            flag = obj.UpdateEmployeeInfo(empinfo);

        } catch (Exception e) {
            log.writeEvent(e.toString());
        }
        return flag;
    }
    /*
    
     */
}
