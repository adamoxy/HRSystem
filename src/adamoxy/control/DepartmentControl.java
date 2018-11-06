package adamoxy.control;

import adamoxy.database.DepartmentDataSource;
import adamoxy.setget.EmployeeInfo;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author adam
 */
public class DepartmentControl {

    public static boolean insertEmpInfo(EmployeeInfo empinfo, String empno) {
        DepartmentDataSource obj = new DepartmentDataSource();
        boolean flag = obj.insertEmpInfo(empinfo, empno);
        obj.close();
        return flag;
    }

    public static ArrayList<HashMap<String, String>> getAllDepartments() {
        DepartmentDataSource obj = new DepartmentDataSource();
        ArrayList<HashMap<String, String>> list = obj.getAllDepartments();
        obj.close();
        return list;
    }

    public static HashMap<String, String> getDepartmentById(String id) {
        DepartmentDataSource obj = new DepartmentDataSource();
        HashMap<String, String> depart = obj.getDepartmentsById(id);
        obj.close();
        return depart;
    }

    public static HashMap<String, ArrayList> getDepartmentPower() {
        DepartmentDataSource obj = new DepartmentDataSource();
        HashMap<String, ArrayList> list = obj.getDepartmentPower();
        obj.close();
        return list;
    }
}
