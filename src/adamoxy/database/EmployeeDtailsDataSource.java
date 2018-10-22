package adamoxy.database;

import adamoxy.common.log;
import adamoxy.setget.EmployeeDetailsInfo;
import adamoxy.setget.EmployeeInfo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 *
 * @author adam
 */
public class EmployeeDtailsDataSource extends WamyConnection {
//    int id, empno;
//    String address, addressB, phone, phoneB, email, createdAt;

    public static void main(String[] args) {

        EmployeeDtailsDataSource obj = new EmployeeDtailsDataSource();
        EmployeeInfo empinfo = new EmployeeInfo();
        empinfo.setEmpno(10);
        empinfo.setDepaprtment("2");
        empinfo.setJobTitle("2");
        empinfo.setWorkTime("full");
        empinfo.setFromDate("2018-09-10");
        empinfo.setToDate("2019-09-10");
        System.out.println(obj.registerEmployeeToDepartmente(empinfo));
        
//        
//        ArrayList<EmployeeDetailsInfo> list = obj.getAllEmployeeDetails();
//
//        EmployeeDetailsInfo empdetails;
//
//        System.out.println("--------------------------------------------------------------------------------------------------");
//        System.out.println("check getAllEmployeeDetails method ...");
//        for (EmployeeDetailsInfo prin : list) {
//            if (prin == null) {
//                System.out.println("the arraylist is not holding any thing )-:");
//            } else {
//                System.out.println(prin.getId() + "\t" + prin.getEmpno() + "\t" + prin.getDOB() + "\t" + prin.getNN() + "\t" + prin.getAddress() + "\t" + prin.getAddressB() + "\t" + prin.getGender() + "\t" + prin.getPhone() + "\t" + prin.getPhoneB() + "\t" + prin.getEmail() + "\t" + prin.getCreatedAt());
//            }
//        }
//        System.out.println("--------------------------------------------------------------------------------------------------");
//        System.out.println("check the get EmployeeDetails method");
//        empdetails = obj.getEmployeeDetails("2");
//        System.out.println(empdetails.getEmpno() + "\t" + empdetails.getNN() + "\t" + empdetails.getAddress() + "\t" + empdetails.getAddressB() + "\t" + empdetails.getGender() + "\t" + empdetails.getPhone() + "\t" + empdetails.getPhoneB() + "\t" + empdetails.getCreatedAt());
//        System.out.println("--------------------------------------------------------------------------------------------------");
//        System.out.println("--------------------------------------------------------------------------------------------------");
//        System.out.println("check the get insertEmployeeDetails method");
//
//        EmployeeDetailsInfo employeeData = new EmployeeDetailsInfo();
//        employeeData.setId(empdetails.getId());
//        employeeData.setEmpno(empdetails.getEmpno());
//        employeeData.setNN(empdetails.getNN());
//        employeeData.setNationalityId(empdetails.getNationalityId());
//        employeeData.setGender(empdetails.getGender());
//        employeeData.setAddress(empdetails.getAddress());
//        employeeData.setAddressB(empdetails.getAddressB());
//        employeeData.setPhone(empdetails.getPhone());
//        employeeData.setPhoneB(empdetails.getPhoneB());
//        employeeData.setEmail(empdetails.getEmail());
//        employeeData.setDOB(empdetails.getDOB());
//        employeeData.setCreatedAt("2018-07-16");
//
//        System.out.println(obj.insertEmployeeDetails(employeeData));
//        System.out.println("--------------------------------------------------------------------------------------------------");
//        System.out.println("--------------------------------------------------------------------------------------------------");
//        System.out.println("check the get updateEmployeeDetails method");
//        System.out.println(obj.updateEmployeeDetails(obj.getEmployeeDetails("2")));
    }

    public ArrayList<EmployeeDetailsInfo> getAllEmployeeDetails() {
        ResultSet resultset;
        ArrayList<EmployeeDetailsInfo> list = new ArrayList<>();
        String sql = "SELECT * from contact ";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            resultset = ps.executeQuery();
            while (resultset.next()) {
                EmployeeDetailsInfo employeeData = new EmployeeDetailsInfo();
                //(id,empno,NN,gender,address,addressB,phone,phoneB,email,DOB,createdAt)    
                employeeData.setId(Integer.parseInt(resultset.getString("id")));
                employeeData.setEmpno(resultset.getInt("empno"));
                employeeData.setNN(resultset.getString("NN"));
                employeeData.setNationalityId(resultset.getString("nationalityId"));
                employeeData.setGender(resultset.getString("gender"));
                employeeData.setAddress(resultset.getString("address"));
                employeeData.setAddressB(resultset.getString("addressB"));
                employeeData.setPhone(resultset.getString("phone"));
                employeeData.setPhoneB(resultset.getString("phoneB"));
                employeeData.setEmail(resultset.getString("email"));
                employeeData.setDOB(resultset.getString("DOB"));
                employeeData.setCreatedAt(resultset.getString("createdAt"));
                list.add(employeeData);
            }
        } catch (Exception e) {
            log.writeEvent("method getAllEmployeeDetails :" + e.toString());
        }
        return list;
    }

    public EmployeeDetailsInfo getEmployeeDetails(String id) {
        ResultSet resultset;
        EmployeeDetailsInfo employeeData = new EmployeeDetailsInfo();
        String sql = "SELECT * from contact where empno= ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, id);
            resultset = ps.executeQuery();
            if (resultset.next()) {

                employeeData.setId(Integer.parseInt(resultset.getString("id")));
                employeeData.setEmpno(resultset.getInt("empno"));
                employeeData.setNN(resultset.getString("NN"));
                employeeData.setNationalityId(resultset.getString("nationalityId"));
                employeeData.setGender(resultset.getString("gender"));
                employeeData.setAddress(resultset.getString("address"));
                employeeData.setAddressB(resultset.getString("addressB"));
                employeeData.setPhone(resultset.getString("phone"));
                employeeData.setPhoneB(resultset.getString("phoneB"));
                employeeData.setEmail(resultset.getString("email"));
                employeeData.setDOB(resultset.getString("DOB"));
                employeeData.setCreatedAt(resultset.getString("createdAt"));
            }
        } catch (Exception e) {
            log.writeEvent("method getEmployeeDetails : " + e.toString());
        }
        return employeeData;
    }

    public boolean insertEmployeeDetails(EmployeeDetailsInfo emp) {

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        boolean flag = false;//(id,empno,NN,gender,address,addressB,phone,phoneB,email,DOB,createdAt)
        String sql = "insert into contact (id,empno,NN,nationalityId,gender,address,addressB,phone,phoneB,email,DOB,createdAt) VALUES  (Default,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setString(1, Integer.toString(emp.getEmpno()));
            ps.setString(2, emp.getNN());
            ps.setString(3, emp.getNationalityId());
            ps.setString(4, emp.getGender());
            ps.setString(5, emp.getAddress());
            ps.setString(6, emp.getAddressB());
            ps.setString(7, emp.getPhone());
            ps.setString(8, emp.getPhoneB());
            ps.setString(9, emp.getEmail());
            ps.setString(10, emp.getDOB());
            ps.setString(11, emp.getCreatedAt());
            if (ps.executeUpdate() > 0) {
                
                flag = true;
            }
        } catch (Exception e) {
            log.writeEvent("insetEmployeeDetails :" + e.toString());
        }
        return flag;
    }

    public boolean updateEmployeeDetails(EmployeeDetailsInfo emp) {
        boolean updateflag = false;
        String sql = " UPDATE contact Set NN = ? , address = ? , addressB = ? , phone = ?  , phoneB = ? , email = ? , DOB = ? where id = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, emp.getNN());
            statement.setString(2, emp.getAddress());
            statement.setString(3, emp.getAddressB());
            statement.setString(4, emp.getPhone());
            statement.setString(5, emp.getPhoneB());
            statement.setString(6, emp.getEmail());
            statement.setString(7, emp.getDOB());
            statement.setInt(8, emp.getId());
            if (statement.executeUpdate() > 0) {
                updateflag = true;
            }
        } catch (SQLException e) {
            log.writeEvent("updateEmployeeDetails" + e.toString());
        } catch (Exception e) {
            log.writeEvent("updateEmployeeDetails" + e.toString());
        }
        return updateflag;
    }

    public boolean registerEmployeeToDepartmente(EmployeeInfo emp) {
        boolean flag = false;
        //
        //# id,emp_No , dept_No,jobId ,workAs,fromDate,toDate

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        String sql = "insert into dept_employees (id,emp_No , dept_No,jobId ,workAs,fromDate,toDate) VALUES  (Default,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setString(1, Integer.toString(emp.getEmpno()));
            ps.setString(2, emp.getDepaprtment());
            ps.setString(3, emp.getJobTitle());
            ps.setString(4, emp.getWorkTime());
            ps.setString(5, emp.getFromDate());
            ps.setString(6, emp.getToDate());
            if (ps.executeUpdate() > 0) {
                flag = true;
            }
        } catch (Exception e) {
            log.writeEvent("registerEmployeeToDepartmente :" + e.toString());
        }
        return flag;

    }
}
