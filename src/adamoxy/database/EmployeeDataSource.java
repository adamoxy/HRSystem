package adamoxy.database;

import adamoxy.common.log;
import adamoxy.setget.EmployeeInfo;
import adamoxy.setget.TempPoJo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author adam
 */
public class EmployeeDataSource extends WamyConnection {

    public ArrayList<EmployeeInfo> getAllEmployees() {
        ArrayList<EmployeeInfo> users = new ArrayList<>();
        String sql = "SELECT * FROM employee";//"#id empno fname restname hireDate bankAccount bankName bankBranch";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultset = statement.executeQuery();
            while (resultset.next()) {//id, fname,restname,hirdDate,banckaccount,bankName,bankBranch,status
                EmployeeInfo empinfo = new EmployeeInfo();
                empinfo.setId(resultset.getInt("id"));
                empinfo.setStatus(Integer.parseInt(resultset.getString("status")));
                empinfo.setFName(resultset.getString("fname"));
                empinfo.setRestname(resultset.getString("restname"));
                empinfo.setHiredate(resultset.getString("hireDate"));
                empinfo.setAccount(resultset.getString("bankAccount"));
                empinfo.setBankname(resultset.getString("bankName"));
                empinfo.setBranch(resultset.getString("bankBranch"));
                users.add(empinfo);
            }
        } catch (SQLException e) {
            log.writeEvent("Error in getAllEmployees : " + e.toString());
        } catch (Exception ex) {
            log.writeEvent("Error in getAllEmployees : " + ex.toString());
        }
        return users;
    }

    public EmployeeInfo getEmployeeInfoById(int id) {
        ResultSet resultset;
        EmployeeInfo empinfo = new EmployeeInfo();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM employee where id= ? ");
            statement.setInt(1, id);
            resultset = statement.executeQuery();
            if (resultset.next()) {//(id,empno,fname,restname,hireDate,bankAccount,bankName,bankBranch)
                empinfo.setId(resultset.getInt("id"));
                empinfo.setFName(resultset.getString("fname"));
                empinfo.setRestname(resultset.getString("restname"));
                empinfo.setHiredate(resultset.getString("hireDate"));
                empinfo.setAccount(resultset.getString("bankAccount"));
                empinfo.setBankname(resultset.getString("bankName"));
                empinfo.setBranch(resultset.getString("bankBranch"));
                empinfo.setget.setSTRING("ThisIsTes");
            }
            resultset.close();
        } catch (Exception e) {
            log.writeEvent("Error in getEmployeeInfo : " + e.toString());
        }
        return empinfo;
    }

    public TempPoJo insertNewEmployee(EmployeeInfo employeeinfo) {
        TempPoJo temp = new TempPoJo();
        String[] empno = {"id"};
        String sqlemployee = "insert into employee (id,fname,restname,hireDate,bankAccount,bankName,bankBranch) values(default,?,?,?,?,?,?);";
        try {
            PreparedStatement prepstatement = connection.prepareStatement(sqlemployee, empno);
            prepstatement.setString(1, employeeinfo.getFName());
            prepstatement.setString(2, employeeinfo.getRestname());
            prepstatement.setString(3, employeeinfo.getHiredate());
            prepstatement.setString(4, employeeinfo.getAccount());
            prepstatement.setString(5, employeeinfo.getBankname());
            prepstatement.setString(6, employeeinfo.getBranch());

            if (prepstatement.executeUpdate() > 0) {
                ResultSet rs = prepstatement.getGeneratedKeys();
                if (rs.next()) {
                    temp.setBOOLEAN(true);
                    temp.setINT(rs.getInt(1));
                    temp.setSTRING(Integer.toString(rs.getInt(1)));
                }
            }
        } catch (Exception e) {
            log.writeEvent(e.toString());
        }
        return temp;
    }

    public boolean UpdateEmployeeInfo(EmployeeInfo empinfo) {
        boolean updateflag = false;
        try {//(id,fname,restname,hireDate,bankAccount,bankName,bankBranch)
            PreparedStatement statement = connection.prepareStatement("UPDATE employee SET fname= ? , restname = ? , hireDate = ? , bankAccount = ? , bankName = ? , bankBranch = ? WHERE id = ? ;");
            statement.setString(1, empinfo.getFName());
            statement.setString(2, empinfo.getRestname());
            statement.setString(3, empinfo.getHiredate());
            statement.setString(4, empinfo.getBankname());
            statement.setString(5, empinfo.getAccount());
            statement.setString(6, empinfo.getBranch());
            statement.setInt(7, empinfo.getId());
            if (statement.executeUpdate() > 0) {
                updateflag = true;
            }
        } catch (SQLException e) {
            log.writeEvent("Error in UpdateEmployeeInfo : " + e.toString());
        } catch (Exception ex) {
            log.writeEvent("Error in UpdateEmployeeInfo : " + ex.toString());
        }
        return updateflag;
    }

    public boolean employeeAttachments(HashMap<String, String> hashmap) {
        boolean flag = false;
        String sql = " insert into employee_attachments (id,attachmentId,empNo) VALUES ( default , ? , ? );";
        try {
            if (!hashmap.isEmpty()) {
                PreparedStatement ps = connection.prepareStatement(sql);
                ps.setString(1, hashmap.get("attachmentId"));
                ps.setString(2, hashmap.get("empNo"));
                if (ps.executeUpdate() > 0) {
                    flag = true;

                }
            }
        } catch (Exception e) {
            log.writeEvent(e.toString());
        }
        return flag;
    }

    public ArrayList< HashMap<String, String>> Attachments() {
        ResultSet resultset;
        ArrayList<HashMap<String, String>> list = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM attachment ");
            resultset = statement.executeQuery();
            while (resultset.next()) {
                HashMap<String, String> map = new HashMap<>();
                map.put("id", resultset.getString("id"));
                map.put("name", resultset.getString("name"));
                map.put("description", resultset.getString("description"));
                list.add(map);
            }
        } catch (SQLException e) {
            log.writeEvent(e.toString());
        } catch (Exception ex) {
            log.writeEvent("Error At Attachments  : " + ex.toString());
        }
        return list;
    }

    public boolean insertAttachment(HashMap<String, String> hashmap) {
        boolean flag = false;
        String sql = " INSERT INTO attachment (name, description,createdAt) VALUES (? , ?,curdate()); ";
        try {
            if (!hashmap.isEmpty()) {
                PreparedStatement statment = connection.prepareStatement(sql);
                statment.setString(1, hashmap.get("name"));
                statment.setString(2, hashmap.get("description"));
                if (statment.executeUpdate() > 0) {
                    flag = true;
                }
            }
        } catch (Exception e) {
            log.writeEvent(e.toString());
        }
        return flag;
    }

    public boolean updateAttachment(HashMap<String, String> hashmap) {
        boolean flag = false;
        String sql = " UPDATE attachment SET name= ? , description =?   WHERE id = ? ;";
        try {

            if (!hashmap.isEmpty()) {
                PreparedStatement statment = connection.prepareStatement(sql);
                statment.setString(1, hashmap.get("name"));
                statment.setString(2, hashmap.get("description"));
                statment.setString(3, hashmap.get("id"));
                if (statment.executeUpdate() > 0) {
                    flag = true;
                }

            }

        } catch (Exception e) {
            log.writeEvent(e.toString());
        }
        return flag;
    }

    public boolean deleteAttachment(String id) {
        boolean flag = false;
        String sql = " DELETE FROM attachment WHERE id= ? ; ";
        try {
            PreparedStatement statment = connection.prepareStatement(sql);
            statment.setString(1, id);
            if (statment.execute()) {
                flag = true;
            }
        } catch (Exception e) {
            log.writeEvent("deleteAttachment : " + e.toString());
        }
        return flag;
    }

    public ArrayList<HashMap<String, String>> retirementCalculator() {
        ArrayList<HashMap<String, String>> list = new ArrayList<>();
        ResultSet rs;
        String sql = " SELECT FLOOR(( DATE_FORMAT(NOW(),'%Y%m%d') - DATE_FORMAT(DOB,'%Y%m%d'))/10000) as years ,  "
                + " FLOOR((1200 + DATE_FORMAT(NOW(),'%m%d') - DATE_FORMAT(DOB,'%m%d'))/100) %12 monthes,  "
                + " (sign(day(NOW()) - day(DOB))+1)/2 * (day(NOW()) - day(DOB)) + (sign(day(DOB) - day(NOW()))+1)/2 * (DAY(STR_TO_DATE(DATE_FORMAT(DOB + INTERVAL 1 MONTH,'%Y-%m-01'),'%Y-%m-%d') - INTERVAL 1 DAY) - day(DOB) + day(NOW())) as 'days',  "
                + " employee.fname as fname , employee.restname as lname, departments.name as department ,jobs.Title as jobTitle , salaries.groupname as groupname,employee.hireDate as hiredate,  "
                + " contact.gender,contact.NN,contact.phone,contact.phoneB,marital_status.MaritalName as marital  "
                + " FROM contact  "
                + " join employee on contact.empno= employee.id  "
                + " JOIN dept_employees on employee.id    =  dept_employees.emp_No  "
                + " JOIN emp_salary 	on employee.id    =  emp_salary.empno  "
                + " JOIN departments 	on departments.id =  dept_employees.dept_No  "
                + " JOIN salaries 		on salaries.id    =  emp_salary.salarygroup_id  "
                + " JOIN jobs 			on jobs.id        =  dept_employees.jobId   "
                + " join marital_status on marital_status.id = contact.MaritalStatusID  "
                + " where FLOOR(( DATE_FORMAT(NOW(),'%Y%m%d') - DATE_FORMAT(DOB,'%Y%m%d'))/10000) = 59 and  "
                + " FLOOR((1200 + DATE_FORMAT(NOW(),'%m%d') - DATE_FORMAT(DOB,'%m%d'))/100) %12 < 5 and  "
                + " (sign(day(NOW()) - day(DOB))+1)/2 * (day(NOW()) - day(DOB)) + (sign(day(DOB) - day(NOW()))+1)/2 * (DAY(STR_TO_DATE(DATE_FORMAT(DOB + INTERVAL 1 MONTH,'%Y-%m-01'),'%Y-%m-%d') - INTERVAL 1 DAY) - day(DOB) + day(NOW())) < 15   "
                + " and contact.empno  NOT IN (select emp_no from job_terminate where job_terminate.reason = 'retirement') ; ";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                // empno,years,monthes,days,fname,lname,department,jobTitle,groupname,hiredate,gender,NN,phone,phoneB,marital
                HashMap<String, String> map = new HashMap();
                map.put("empno", rs.getString("empno"));
                map.put("years", rs.getString("years"));
                map.put("monthes", rs.getString("monthes"));
                map.put("days", rs.getString("days"));
                map.put("fname", rs.getString("fname"));
                map.put("lname", rs.getString("lname"));
                map.put("department", rs.getString("department"));
                map.put("jobTitle", rs.getString("jobTitle"));
                map.put("groupname", rs.getString("groupname"));
                map.put("hiredate", rs.getString("hiredate"));
                map.put("gender", rs.getString("gender"));
                map.put("NN", rs.getString("NN"));
                map.put("phone", rs.getString("phone"));
                map.put("phoneB", rs.getString("phoneB"));
                map.put("marital", rs.getString("marital"));
                list.add(map);
            }
        } catch (Exception e) {
            log.writeEvent("retirementCaculator : " + e.toString());
        }
        return list;
    }

    public HashMap<String, String> retirementCalculatorById(String id) {
        HashMap<String, String> map = null;
        ResultSet rs;
        String sql = " SELECT FLOOR(( DATE_FORMAT(NOW(),'%Y%m%d') - DATE_FORMAT(DOB,'%Y%m%d'))/10000) as years ,  "
                + " FLOOR((1200 + DATE_FORMAT(NOW(),'%m%d') - DATE_FORMAT(DOB,'%m%d'))/100) %12 monthes,  "
                + " (sign(day(NOW()) - day(DOB))+1)/2 * (day(NOW()) - day(DOB)) + (sign(day(DOB) - day(NOW()))+1)/2 * (DAY(STR_TO_DATE(DATE_FORMAT(DOB + INTERVAL 1 MONTH,'%Y-%m-01'),'%Y-%m-%d') - INTERVAL 1 DAY) - day(DOB) + day(NOW())) as 'days',  "
                + " employee.fname as fname , employee.restname as lname, departments.name as department ,jobs.Title as jobTitle , salaries.groupname as groupname,employee.hireDate as hiredate,  "
                + " contact.gender,contact.NN,contact.phone,contact.phoneB,marital_status.MaritalName as marital  "
                + " FROM contact  "
                + " join employee on contact.empno= employee.id  "
                + " JOIN dept_employees on employee.id    =  dept_employees.emp_No  "
                + " JOIN emp_salary 	on employee.id    =  emp_salary.empno  "
                + " JOIN departments 	on departments.id =  dept_employees.dept_No  "
                + " JOIN salaries 		on salaries.id    =  emp_salary.salarygroup_id  "
                + " JOIN jobs 			on jobs.id        =  dept_employees.jobId   "
                + " join marital_status on marital_status.id = contact.MaritalStatusID  "
                + " where employee.id = ? and FLOOR(( DATE_FORMAT(NOW(),'%Y%m%d') - DATE_FORMAT(DOB,'%Y%m%d'))/10000) = 59 and  "
                + " FLOOR((1200 + DATE_FORMAT(NOW(),'%m%d') - DATE_FORMAT(DOB,'%m%d'))/100) %12 < 5 and  "
                + " (sign(day(NOW()) - day(DOB))+1)/2 * (day(NOW()) - day(DOB)) + (sign(day(DOB) - day(NOW()))+1)/2 * (DAY(STR_TO_DATE(DATE_FORMAT(DOB + INTERVAL 1 MONTH,'%Y-%m-01'),'%Y-%m-%d') - INTERVAL 1 DAY) - day(DOB) + day(NOW())) < 15   "
                + " and contact.empno  NOT IN (select emp_no from job_terminate where job_terminate.reason = 'retirement') ; ";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                map = new HashMap();
                map.put("empno", rs.getString("empno"));
                map.put("years", rs.getString("years"));
                map.put("monthes", rs.getString("monthes"));
                map.put("days", rs.getString("days"));
                map.put("fname", rs.getString("fname"));
                map.put("lname", rs.getString("lname"));
                map.put("department", rs.getString("department"));
                map.put("jobTitle", rs.getString("jobTitle"));
                map.put("groupname", rs.getString("groupname"));
                map.put("hiredate", rs.getString("hiredate"));
                map.put("gender", rs.getString("gender"));
                map.put("NN", rs.getString("NN"));
                map.put("phone", rs.getString("phone"));
                map.put("phoneB", rs.getString("phoneB"));
                map.put("marital", rs.getString("marital"));

            }
        } catch (Exception e) {
            log.writeEvent("retirementCaculator : " + e.toString());
        }
        return map;
    }

}
