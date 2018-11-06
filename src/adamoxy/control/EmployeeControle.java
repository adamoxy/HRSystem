package adamoxy.control;

import adamoxy.database.EmployeeDataSource;
import adamoxy.setget.EmployeeInfo;
import adamoxy.setget.TempPoJo;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author adam
 */
public class EmployeeControle {

    public static ArrayList<EmployeeInfo> getAllEmployees() {
        EmployeeDataSource obj = new EmployeeDataSource();
        ArrayList list = obj.getAllEmployees();
        obj.close();
        return list;
    }

    public static EmployeeInfo getEmployeeInfoById(int id) {
        EmployeeDataSource obj = new EmployeeDataSource();
        EmployeeInfo empinfo = obj.getEmployeeInfoById(id);
        obj.close();
        return empinfo;
    }

    public static TempPoJo insertNewEmployee(EmployeeInfo empinfo) {
        EmployeeDataSource obj = new EmployeeDataSource();
        TempPoJo temp = obj.insertNewEmployee(empinfo);
        obj.close();
        return temp;
    }

    public static boolean UpdateEmployeeInfo(EmployeeInfo empinfo) {
        EmployeeDataSource obj = new EmployeeDataSource();
        boolean flag = obj.UpdateEmployeeInfo(empinfo);
        obj.close();
        return flag;
    }

    public static boolean employeeAttachments(HashMap<String, String> hashmap) {
        EmployeeDataSource obj = new EmployeeDataSource();
        boolean flag = obj.employeeAttachments(hashmap);
        obj.close();
        return flag;
    }

    public static ArrayList<HashMap<String, String>> retirementCalculator() {
        EmployeeDataSource obj = new EmployeeDataSource();
        ArrayList<HashMap<String, String>> list = obj.retirementCalculator();
        obj.close();
        return list;
    }

    public static HashMap<String, String> retirementCalculatorById(String id) {
        EmployeeDataSource obj = new EmployeeDataSource();
        HashMap<String, String> map = obj.retirementCalculatorById(id);
        obj.close();
        return map;
    }
}
