package adamoxy.control;

import adamoxy.database.SalaryDataSource;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author adam
 */
public class SalaryControl {

    public static HashMap<String, String> getMonthlySalaryById(String id, String fromDate, String toDate) {
        SalaryDataSource obj = new SalaryDataSource();
        HashMap<String, String> sal = obj.getMonthlySalaryById(id, fromDate, toDate);
        obj.close();
        return sal;
    }

    public static ArrayList<HashMap<String, String>> salaryGroups() {
        SalaryDataSource obj = new SalaryDataSource();
        ArrayList<HashMap<String, String>> list = obj.salaryGroups();
        obj.close();
        return list;
    }

    public static ArrayList<HashMap<String, String>> getAllMonthlySalary(String fromDate, String toDate) {
        SalaryDataSource obj = new SalaryDataSource();
        ArrayList<HashMap<String, String>> sal = obj.getAllMonthlySalary(fromDate, toDate);
        obj.close();
        return sal;
    }

    public static HashMap<String, String> getMonthlySalaryTotal(String fromDate, String toDate) {
        SalaryDataSource obj = new SalaryDataSource();
        HashMap<String, String> sal = obj.getMonthlySalaryTotal(fromDate, toDate);
        obj.close();
        return sal;
    }

    public static boolean insertNewEmpSalary(HashMap<String, String> map) {
        SalaryDataSource obj = new SalaryDataSource();
        boolean flag = obj.insertNewEmpSalary(map);
        obj.close();
        return flag;
    }
}
