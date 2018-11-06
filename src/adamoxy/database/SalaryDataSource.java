package adamoxy.database;

import adamoxy.common.log;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author adam
 */
public class SalaryDataSource extends WamyConnection {

    public HashMap<String, String> getMonthlySalaryById(String id, String fromDate, String toDate) {

        ResultSet resultset;
        String sql = "SELECT * FROM wamy_hr.salary_view where  emp_no = ? and from_date= ?  and to_date= ?  ;";
        HashMap< String, String> hashmap = new HashMap<>();
        double gross = 0;
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, id);
            statement.setString(2, fromDate);
            statement.setString(3, toDate);
            resultset = statement.executeQuery();
            if (resultset.next()) {
                hashmap.put("employeeNo", resultset.getString(1));
                hashmap.put("fullName", resultset.getString(2));
                hashmap.put("basicSalary", resultset.getString(3));
                hashmap.put("transport", resultset.getString(4));
                hashmap.put("residence", resultset.getString(5));
                hashmap.put("living", resultset.getString(6));
                hashmap.put("clothing", resultset.getString(7));
                hashmap.put("insurance", resultset.getString(8));
                hashmap.put("netSalary", resultset.getString(9));
                gross = resultset.getInt(9) - resultset.getInt(8);
                hashmap.put("Gross", Double.toString(gross));
                hashmap.put("groupName", resultset.getString(10));
                hashmap.put("fromDate", resultset.getString(11));
                hashmap.put("toDate", resultset.getString(12));
            }
        } catch (Exception ex) {
            log.writeEvent("Error in getMonthlySalaryById : " + ex.toString());
        }
        return hashmap;
    }

    public ArrayList<HashMap<String, String>> salaryGroups() {
        ArrayList<HashMap<String, String>> list = new ArrayList<>();
        ResultSet rs;
        String sql = "select * from salaries ;";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                HashMap<String, String> group = new HashMap<>();
                group.put("id", rs.getString("id"));
                group.put("groupid", rs.getString("groupid"));
                group.put("transport", rs.getString("transport"));
                group.put("Residence", rs.getString("Residence"));
                group.put("Living", rs.getString("Living"));
                group.put("clothing", rs.getString("clothing"));
                group.put("insurance", rs.getString("insurance"));
                group.put("basic_salary", rs.getString("basic_salary"));
                group.put("groupname", rs.getString("groupname"));
                list.add(group);
            }
        } catch (Exception e) {
            log.writeEvent(e.toString());
        }

        return list;
    }

    public ArrayList<HashMap<String, String>> getAllMonthlySalary(String fromDate, String toDate) {
        ResultSet resultset;
        String sql = "SELECT * FROM salary_view  where from_date = ? && to_date = ? ;";
        HashMap< String, String> hashmap = null;
        ArrayList<HashMap<String, String>> list = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, fromDate);
            ps.setString(2, toDate);
            resultset = ps.executeQuery();

            while (resultset.next()) {

                hashmap = new HashMap<>();

                hashmap.put("employeeNo", resultset.getString(1));
                hashmap.put("fullName", resultset.getString(2));
                hashmap.put("basicSalary", resultset.getString(3));
                hashmap.put("transport", resultset.getString(4));
                hashmap.put("residence", resultset.getString(5));
                hashmap.put("living", resultset.getString(6));
                hashmap.put("clothing", resultset.getString(7));
                hashmap.put("insurance", resultset.getString(8));
                hashmap.put("netSalary", resultset.getString(9));
                hashmap.put("groupName", resultset.getString(10));
                hashmap.put("fromDate", resultset.getString(11));
                hashmap.put("toDate", resultset.getString(12));
                list.add(hashmap);
            }
        } catch (Exception ex) {
            log.writeEvent("Error in getAllMonthlySalary : " + ex.toString());
        }
        return list;
    }

    public HashMap<String, String> getMonthlySalaryTotal(String fromDate, String toDate) {

        ResultSet resultset;
        String sql = "SELECT "
                + "SUM(basic_salary) as bsal,SUM(transport) as trnas,SUM(residence) as residen,SUM(living) as live,SUM(clothing) as cloth , SUM(insurance) as insura,"
                + "SUM(net_salary) as net"
                + " FROM wamy_hr.salary_view where from_date = ?  and to_date = ?  ;";
        HashMap< String, String> hashmap = new HashMap<>();
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, fromDate);
            statement.setString(2, toDate);
            resultset = statement.executeQuery();
            if (resultset.next()) {

                hashmap.put("basicSalary", resultset.getString("bsal"));
                hashmap.put("transport", resultset.getString("trnas"));
                hashmap.put("residence", resultset.getString("residen"));
                hashmap.put("living", resultset.getString("live"));
                hashmap.put("clothing", resultset.getString("cloth"));
                hashmap.put("insurance", resultset.getString("insura"));
                hashmap.put("netSalary", resultset.getString("net"));
            }
        } catch (Exception ex) {
            log.writeEvent("Error in getMonthlySalaryById : " + ex.toString());
        }
        return hashmap;
    }

    public boolean insertNewEmpSalary(HashMap<String, String> map) {
        boolean flag = false;
        String sql = "insert into emp_salary (id,empno,salarygroup_id,from_date,to_date) VALUES (default , ? , ? , ? , ? ); ";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, map.get("EmpNo"));
            ps.setString(2, map.get("GroupId"));
            ps.setString(3, map.get("fromDate"));
            ps.setString(4, map.get("toDate"));

            if (ps.executeUpdate() > 0) {
                flag = true;
            }
        } catch (Exception e) {
            log.writeEvent(e.toString());
        }
        return flag;
    }

}
