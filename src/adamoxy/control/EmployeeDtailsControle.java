package adamoxy.control;

import adamoxy.database.EmployeeDtailsDataSource;
import adamoxy.setget.EmployeeDetailsInfo;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author adam
 */
public class EmployeeDtailsControle {

    public static ArrayList<EmployeeDetailsInfo> getAllEmployeeDetails() {
        EmployeeDtailsDataSource obj = new EmployeeDtailsDataSource();
        ArrayList<EmployeeDetailsInfo> empdetails = obj.getAllEmployeeDetails();
        obj.close();
        return empdetails;

    }

    public static EmployeeDetailsInfo getEmployeeDetails(String id) {
        EmployeeDtailsDataSource obj = new EmployeeDtailsDataSource();
        EmployeeDetailsInfo empdetails = obj.getEmployeeDetails(id);
        obj.close();
        return empdetails;
    }

    public static boolean insertEmployeeDetails(EmployeeDetailsInfo emp, String id) {
        EmployeeDtailsDataSource obj = new EmployeeDtailsDataSource();
        boolean flag = obj.insertEmployeeDetails(emp, id);
        obj.close();
        return flag;
    }

    public static boolean updateEmployeeDetails(EmployeeDetailsInfo emp) {
        EmployeeDtailsDataSource obj = new EmployeeDtailsDataSource();
        boolean flag = obj.updateEmployeeDetails(emp);
        obj.close();
        return flag;
    }

    public static HashMap<String, String> departmentAndJob(String id) {
        EmployeeDtailsDataSource obj = new EmployeeDtailsDataSource();
        HashMap<String, String> map = obj.departmentAndJob(id);
        obj.close();
        return map;
    }

    public static ArrayList<HashMap<String, String>> EmployeesGeneralInfo() {
        EmployeeDtailsDataSource obj = new EmployeeDtailsDataSource();
        ArrayList<HashMap<String, String>> list = obj.ListAllEmployeesGeneralInfo();
        obj.close();
        return list;

    }

    public static ArrayList<HashMap<String, String>> getMaritalStatus() {
        EmployeeDtailsDataSource obj = new EmployeeDtailsDataSource();
        ArrayList<HashMap<String, String>> list = obj.getMaritalStatus();
        obj.close();
        return list;
    }

    public static boolean insertMaritalStatus(String Marital, String Description) {
        EmployeeDtailsDataSource obj = new EmployeeDtailsDataSource();
        boolean flag = obj.insertMaritalStatus(Marital, Description);
        obj.close();
        return flag;
    }

}
