package adamoxy.database;

import adamoxy.common.log;
import adamoxy.setget.EmployeeDetailsInfo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author adam
 */
public class EmployeeDtailsDataSource extends WamyConnection {

    public ArrayList<EmployeeDetailsInfo> getAllEmployeeDetails() {
        ResultSet resultset;//
        ArrayList<EmployeeDetailsInfo> list = new ArrayList<>();
        String sql = "SELECT contact.id,nationality.name as nationality,empno,NN,nationalityId,gender,marital_status.MaritalName,address,addressB,phone,phoneB , email , TIMESTAMPDIFF(YEAR, DOB ,CURDATE())as age , DOB , createdAt"
                + "  from contact , marital_status , nationality where marital_status.id = contact.MaritalStatusID and nationality.id = contact.nationalityId ";
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
                employeeData.setNationality(resultset.getString("nationality"));
                employeeData.setGender(resultset.getString("gender"));
                employeeData.setMStatus(resultset.getString("MaritalName"));
                employeeData.setAddress(resultset.getString("address"));
                employeeData.setAddressB(resultset.getString("addressB"));
                employeeData.setPhone(resultset.getString("phone"));
                employeeData.setPhoneB(resultset.getString("phoneB"));
                employeeData.setEmail(resultset.getString("email"));
                employeeData.setDOB(resultset.getString("DOB"));
                employeeData.setAge(resultset.getString("age"));
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
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String sql = "SELECT contact.id,empno,nationality.name as 'nationality' ,NN,nationalityId,gender,marital_status.MaritalName,address,addressB,phone,phoneB,email,TIMESTAMPDIFF(YEAR, DOB ,CURDATE())as age, DOB ,createdAt"
                + "  from contact , marital_status , nationality where empno= ? and marital_status.id = contact.MaritalStatusID and nationality.id = contact.nationalityId";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, id);
            resultset = ps.executeQuery();
            if (resultset.next()) {

                employeeData.setId(Integer.parseInt(resultset.getString("id")));
                employeeData.setEmpno(resultset.getInt("empno"));
                employeeData.setNN(resultset.getString("NN"));
                employeeData.setNationalityId(resultset.getString("nationalityId"));
                employeeData.setNationality(resultset.getString("nationality"));
                employeeData.setGender(resultset.getString("gender"));
                employeeData.setMStatus(resultset.getString("MaritalName"));
                employeeData.setAddress(resultset.getString("address"));
                employeeData.setAddressB(resultset.getString("addressB"));
                employeeData.setPhone(resultset.getString("phone"));
                employeeData.setPhoneB(resultset.getString("phoneB"));
                employeeData.setEmail(resultset.getString("email"));
                employeeData.setDOB(format.format(resultset.getDate("DOB")));
                employeeData.setAge(resultset.getString("age"));
                employeeData.setCreatedAt(format.format(resultset.getDate("createdAt")));
            }
        } catch (Exception e) {
            log.writeEvent("method getEmployeeDetails : " + e.toString());
        }
        return employeeData;
    }

    public boolean insertEmployeeDetails(EmployeeDetailsInfo emp, String id) {
        // id,empno,NN,nationalityId,gender,address,addressB,phone,phoneB,email,DOB,createdAt
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        boolean flag = false;//(id,empno,NN,gender,address,addressB,phone,phoneB,email,DOB,createdAt)
        String sql = "insert into contact (contact.id,empno,NN,nationalityId,gender,MaritalStatusID,address,addressB,phone,phoneB,email,DOB,createdAt) VALUES  (Default,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setString(1, id);//empno
            ps.setString(2, emp.getNN());//nn
            ps.setString(3, emp.getNationalityId());//nationalityid
            ps.setString(4, emp.getGender());//gender
            ps.setString(5, emp.getMStatus());//maritalStatusid
            ps.setString(6, emp.getAddress());//address
            ps.setString(7, emp.getAddressB());//addressB
            ps.setString(8, emp.getPhone());
            ps.setString(9, emp.getPhoneB());
            ps.setString(10, emp.getEmail());
            ps.setString(11, emp.getDOB());
            ps.setString(12, emp.getCreatedAt());
            if (ps.executeUpdate() > 0) {
                flag = true;
            }
        } catch (Exception e) {
            log.writeEvent("insetEmployeeDetails :" + e.toString());
        }
        return flag;
    }

    public boolean updateEmployeeDetails(EmployeeDetailsInfo emp) {
        boolean updateflag = false;//
        String sql = " UPDATE contact Set NN = ? , MaritalStatusID = ? , address = ? , addressB = ? , phone = ?  , phoneB = ? , email = ? , DOB = ? where id = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, emp.getNN());
            statement.setString(2, emp.getMStatus());
            statement.setString(3, emp.getAddress());
            statement.setString(4, emp.getAddressB());
            statement.setString(5, emp.getPhone());
            statement.setString(6, emp.getPhoneB());
            statement.setString(7, emp.getEmail());
            statement.setString(8, emp.getDOB());
            statement.setInt(9, emp.getId());
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

    public ArrayList<HashMap<String, String>> getMaritalStatus() {
        ResultSet resultset;
        ArrayList<HashMap<String, String>> list = new ArrayList<>();
        String sql = "SELECT * FROM marital_status;";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            resultset = ps.executeQuery();
            while (resultset.next()) {//id,MaritalName,Description
                HashMap<String, String> map = new HashMap();
                map.put("id", resultset.getString("id"));
                map.put("Marital", resultset.getString("MaritalName"));
                map.put("Description", resultset.getString("Description"));
                list.add(map);
            }
        } catch (Exception e) {
            log.writeEvent("getMaritalStatus : " + e.toString());
        }
        return list;
    }

    public boolean insertMaritalStatus(String Marital, String Description) {
        boolean flag = false;
        String sql = "insert into marital_status ( id , MaritalName , Description ) VALUES  ( Default , ? , ? )";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setString(1, Marital);
            ps.setString(2, Description);
            if (ps.executeUpdate() > 0) {
                flag = true;
            }
        } catch (Exception e) {
            log.writeEvent("insertMaritalStatus :" + e.toString());
        }
        return flag;
    }

    public HashMap<String, String> departmentAndJob(String id) {
        HashMap<String, String> hashmap = new HashMap<>();
        String sql = " SELECT name,Title,dept_employees.emp_No FROM wamy_hr.dept_employees, "
                + " wamy_hr.departments,jobs where dept_employees.dept_No = departments.id  "
                + " and dept_employees.jobId = jobs.id and dept_employees.emp_No = ? group by dept_employees.id; ";
        ResultSet rs;
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                hashmap.put("department", rs.getString(1));
                hashmap.put("jobTitle", rs.getString(2));
                hashmap.put("empNo", rs.getString(3));
            }
        } catch (Exception e) {
            log.writeEvent(e.toString());
        }
        return hashmap;
    }

    public ArrayList<HashMap<String, String>> ListAllEmployeesGeneralInfo() {
        ArrayList<HashMap<String, String>> list = new ArrayList<>();
        String sql = " select employee.id as empno , employee.fname as fname , employee.restname as lname, departments.name as department ,jobs.Title as jobTitle , salaries.groupname as groupname, "
                + " FLOOR(( DATE_FORMAT(NOW(),'%Y%m%d') - DATE_FORMAT(employee.hireDate,'%Y%m%d'))/10000) as years, "
                + " FLOOR((1200 + DATE_FORMAT(NOW(),'%m%d') - DATE_FORMAT(employee.hireDate,'%m%d'))/100) %12 monthes , "
                + " (sign(day(NOW()) - day(employee.hireDate))+1)/2 * (day(NOW()) - day(employee.hireDate)) + (sign(day(employee.hireDate) - day(NOW()))+1)/2 * (DAY(STR_TO_DATE(DATE_FORMAT(employee.hireDate + INTERVAL 1 MONTH,'%Y-%m-01'),'%Y-%m-%d') - INTERVAL 1 DAY) - day(employee.hireDate) + day(NOW())) as 'days' "
                + " , employee.hireDate as hiredate  , employee.status as status "
                + " from employee  "
                + " JOIN dept_employees on employee.id    =  dept_employees.emp_No "
                + " JOIN emp_salary 	on employee.id    =  emp_salary.empno "
                + " JOIN departments 	on departments.id =  dept_employees.dept_No "
                + " JOIN salaries 		on salaries.id    =  emp_salary.salarygroup_id "
                + " JOIN jobs 			on jobs.id        =  dept_employees.jobId ;";
        ResultSet rs;
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                HashMap<String, String> map = new HashMap<>();
                map.put("empno", rs.getString("empno"));
                map.put("fname", rs.getString("fname"));
                map.put("lname", rs.getString("lname"));
                map.put("department", rs.getString("department"));
                map.put("jobTitle", rs.getString("jobTitle"));
                map.put("groupname", rs.getString("groupname"));
                map.put("years", rs.getString("years"));
                map.put("monthes", rs.getString("monthes"));
                map.put("days", rs.getString("days"));
                map.put("hiredate", rs.getString("hiredate"));
                map.put("status", rs.getString("status"));
                list.add(map);
            }

        } catch (Exception e) {
            log.writeEvent(e.toString());
        }

        return list;
    }

    public List<HashMap<String, String>> nationality() {
        List<HashMap<String, String>> list = new ArrayList<>();
        ResultSet rs;
        String sql = "select * from nationality;";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                HashMap<String, String> pairs = new HashMap<>();
                pairs.put("id", rs.getString("id"));
                pairs.put("name", rs.getString("name"));
                list.add(pairs);
            }
        } catch (Exception e) {
            log.writeEvent(e.toString());
        }
        return list;
    }

}
