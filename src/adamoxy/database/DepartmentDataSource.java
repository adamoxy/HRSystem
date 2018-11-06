package adamoxy.database;

import adamoxy.common.log;
import adamoxy.setget.EmployeeInfo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author adam
 */
public class DepartmentDataSource extends WamyConnection {

    public boolean insertEmpInfo(EmployeeInfo empinfo, String empno) {
        String sql = "insert into dept_employees (id,emp_No,dept_No,jobId,workAs,fromDate,toDate,note) VALUES (default , ? , ? , ? , ? , ? , ? , ? ) ; ";
        boolean flag = false;
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, empno);
            ps.setString(2, empinfo.getDepaprtment());
            ps.setString(3, empinfo.getJobTitle());
            ps.setString(4, empinfo.getWorkTime());
            ps.setString(5, empinfo.getFromDate());
            ps.setString(6, empinfo.getToDate());
            ps.setString(7, empinfo.getNote());
            if (ps.executeUpdate() > 0) {
                flag = true;
            }
        } catch (Exception e) {
            log.writeEvent(e.toString());
        }
        return flag;
    }

    public ArrayList<HashMap<String, String>> getAllDepartments() {
        ArrayList<HashMap<String, String>> list = new ArrayList<>();
        ResultSet rs;
        String sql = "select * from departments ";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                HashMap<String, String> depart = new HashMap<>();
                depart.put("id", rs.getString("id"));
                depart.put("name", rs.getString("name"));
                list.add(depart);
            }
        } catch (Exception e) {
            log.writeEvent(e.toString());
        }
        return list;
    }

    public HashMap<String, String> getDepartmentsById(String id) {
        HashMap<String, String> depart = new HashMap<>();
        ResultSet rs;
        String sql = "select * from departments where id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                depart.put("id", rs.getString("id"));
                depart.put("name", rs.getString("name"));
            }
        } catch (Exception e) {
            log.writeEvent(e.toString());
        }
        return depart;
    }

    public HashMap<String, ArrayList> getDepartmentPower() {

        ArrayList<HashMap> listN = new ArrayList();
        ArrayList<HashMap> listR = new ArrayList();
        HashMap<String, String> neededP = null;
        HashMap<String, String> actualP = null;
        ResultSet rspower, rsreal;
        String neededpower = "SELECT * FROM wamy_hr.departments;";
        String actualpower = "SELECT count(emp_No) , departments.id as id,name FROM wamy_hr.dept_employees , departments where departments.id=dept_employees.dept_No group by dept_No;";
        HashMap<String, ArrayList> mapper = new HashMap<>();

        try {
            PreparedStatement ps = connection.prepareStatement(neededpower);
            PreparedStatement statment = connection.prepareStatement(actualpower);
            rspower = ps.executeQuery();
            while (rspower.next()) {
                neededP = new HashMap<>();
                neededP.put("id", rspower.getString("id"));
                neededP.put("name", rspower.getString("name"));
                neededP.put("power", rspower.getString("power"));
                listN.add(neededP);
            }
            mapper.put("NeededPower", listN);
            ps.close();
            rsreal = statment.executeQuery();
            while (rsreal.next()) {
                actualP = new HashMap<>();
                actualP.put("id", rsreal.getString(2));
                actualP.put("name", rsreal.getString(3));
                actualP.put("Total", rsreal.getString(1));
                listR.add(actualP);
            }
            statment.close();
            mapper.put("actualpower", listR);
        } catch (Exception e) {
            log.writeEvent(e.toString());
        }
        return mapper;
    }
}
