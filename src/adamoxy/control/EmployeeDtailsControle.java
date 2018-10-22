package adamoxy.control;

import adamoxy.common.log;
import adamoxy.database.EmployeeDtailsDataSource;
import adamoxy.setget.EmployeeDetailsInfo;
import adamoxy.setget.EmployeeInfo;
import java.util.ArrayList;

/**
 *
 * @author adam
 */
public class EmployeeDtailsControle {

    /*    public ArrayList<EmployeeDetailsInfo> getAllEmployeeDetails() {
     */
    public ArrayList<EmployeeDetailsInfo> getAllEmployeeDetails() {
        EmployeeDtailsDataSource obj = new EmployeeDtailsDataSource();
        ArrayList<EmployeeDetailsInfo> empdetails = null;

        try {
            empdetails = obj.getAllEmployeeDetails();
        } catch (Exception e) {
            log.writeEvent("EmployeeDtailsControle > getAllEmployeeDetails :" + e.toString());
        }
        return empdetails;

    }

    /*
        public EmployeeDetailsInfo getEmployeeDetails(String id){}
     */
    public static EmployeeDetailsInfo getEmployeeDetails(String id) {
        EmployeeDtailsDataSource obj = new EmployeeDtailsDataSource();
        EmployeeDetailsInfo empdetails = null;
        try {
            empdetails = obj.getEmployeeDetails(id);

        } catch (Exception e) {
            log.writeEvent("EmployeeDtailsControle > getEmployeeDetails :" + e.toString());
        }
        return empdetails;
    }

    /*
            public boolean insertEmployeeDetails(EmployeeDetailsInfo emp){}
     */
    public static boolean insertEmployeeDetails(EmployeeDetailsInfo emp) {
        EmployeeDtailsDataSource obj = new EmployeeDtailsDataSource();
        boolean flag = false;
        try {
            flag = obj.insertEmployeeDetails(emp);

        } catch (Exception e) {
            log.writeEvent("EmployeeDtailsControle > insertEmployeeDetails :" + e.toString());
        }
        return flag;
    }

    /*
            public boolean updateEmployeeDetails(EmployeeDetailsInfo emp){}
     */
    public static boolean updateEmployeeDetails(EmployeeDetailsInfo emp) {
        EmployeeDtailsDataSource obj = new EmployeeDtailsDataSource();
        boolean flag = false;
        try {
            flag = obj.updateEmployeeDetails(emp);

        } catch (Exception e) {
            log.writeEvent("EmployeeDtailsControle > updateEmployeeDetails :" + e.toString());
        }
        return flag;
    }

    /*    public boolean registerEmployeeToDepartmente(EmployeeInfo emp) {
     */
    public static boolean registerEmployeeToDepartmente(EmployeeInfo emp) {
        boolean flag = false;
        EmployeeDtailsDataSource obj = new EmployeeDtailsDataSource();
        try {

        } catch (Exception e) {
            log.writeEvent("EmployeeDtailsControle > registerEmployeeToDepartmente :" + e.toString());
        }
        return flag;
    }

    /*
     */
}
