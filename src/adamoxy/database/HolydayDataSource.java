package adamoxy.database;

import adamoxy.common.log;
import adamoxy.setget.holyDayInfo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author adam
 */
public class HolydayDataSource extends WamyConnection {
    
    public ArrayList<holyDayInfo> getAllHolydaySummery(String department, String fromDate, String toDate) {
        ResultSet rs;
        String sqlholday = " SELECT employee.id as empno,employee.fname,employee.restname ,holyday.type, "
                + "	IF(holyday.period IS NULL, 'N/A', holyday.period) period, "
                + "	holydaysschedule.startat,holydaysschedule.endat,holydaysschedule.summry , "
                + "	datediff(holydaysschedule.endat ,holydaysschedule.startat) as realperiod , "
                + "	if(holyday.period < datediff(holydaysschedule.endat ,holydaysschedule.startat),concat('استهلكت و زيادة ' , ' ',holyday.period - datediff(holydaysschedule.endat ,holydaysschedule.startat)) , if(holyday.period = datediff(holydaysschedule.endat ,holydaysschedule.startat) , ' لم يتبقى شي ',ifnull(holyday.period, 0 ) - datediff(holydaysschedule.endat ,holydaysschedule.startat))) as still, "
                + "	if(curdate() > holydaysschedule.endat,if(holydaysschedule.status = 'consumed',holydaysschedule.status,'Should Be Consumed !'),holydaysschedule.status) as status "
                + " FROM employee  "
                + "	join holydaysschedule on holydaysschedule.empno=employee.id "
                + "	join holyday on holyday.id=holydaysschedule.holydayid  ";
        ArrayList<holyDayInfo> list = new ArrayList<>();
        try {
            if (!fromDate.equals("") && fromDate != null && !toDate.equals("") && toDate != null) {
                sqlholday += " where  ' ? '  between holydaysschedule.startat and holydaysschedule.endat  and  ' ? '  between holydaysschedule.startat and holydaysschedule.endat ";
                if (!department.equals("") && department != null) {
                    if (!department.equalsIgnoreCase("all")) {
                        sqlholday += "  and  employee.id  in (SELECT dept_employees.emp_No FROM wamy_hr.dept_employees where dept_employees.dept_No = ? ) ;";
                    }
                }
            } else if (!department.equals("") && department != null) {
                if (!department.equalsIgnoreCase("all")) {
                    sqlholday += " where  employee.id  in (SELECT dept_employees.emp_No FROM wamy_hr.dept_employees where dept_employees.dept_No = ? ) ;";
                }
            }
            PreparedStatement ps = connection.prepareStatement(sqlholday);
            if (!fromDate.equals("") && fromDate != null && !toDate.equals("") && toDate != null) {
                ps.setString(1, fromDate);
                ps.setString(2, toDate);
                if (!department.equals("") && department != null) {
                    if (!department.equalsIgnoreCase("all")) {
                        ps.setString(3, department);
                    }
                }
            } else if (!department.equals("") && department != null) {//if there is no start date nither endDate but there is a department 
                if (!department.equalsIgnoreCase("all")) {
                    ps.setString(1, department);
                }
            }
            rs = ps.executeQuery();
            while (rs.next()) {
                holyDayInfo holyday = new holyDayInfo();
                holyday.setEmpno(rs.getString("empno"));
                holyday.setFname(rs.getString("fname"));
                holyday.setRestname(rs.getString("restname"));
                holyday.setType(rs.getString("type"));
                holyday.setPeriod(rs.getString("period"));
                holyday.setStartat(rs.getString("startat"));
                holyday.setEndat(rs.getString("endat"));
                holyday.setSummry(rs.getString("summry"));
                holyday.setRealperiod(rs.getString("realperiod"));
                holyday.setRest(rs.getString("still"));
                holyday.setStatus(rs.getString("status"));
                list.add(holyday);
            }
        } catch (Exception e) {
            log.writeEvent("holyDaySummery : " + e.toString());
        }

        return list;
    }

    public ArrayList<holyDayInfo> getHolydaySummeryById(String id, String fromDate, String toDate) {
        ResultSet rs;
        String sqlholday = " SELECT employee.id as empno,employee.fname,employee.restname ,holyday.type, "
                + "	IF(holyday.period IS NULL, 'N/A', holyday.period) period, "
                + "	holydaysschedule.startat,holydaysschedule.endat,holydaysschedule.summry , "
                + "	datediff(holydaysschedule.endat ,holydaysschedule.startat) as realperiod , "
                + "	if(holyday.period < datediff(holydaysschedule.endat ,holydaysschedule.startat),concat('استهلكت و زيادة ' , ' ',holyday.period - datediff(holydaysschedule.endat ,holydaysschedule.startat)) , if(holyday.period = datediff(holydaysschedule.endat ,holydaysschedule.startat) , ' لم يتبقى شي ',ifnull(holyday.period, 0 ) - datediff(holydaysschedule.endat ,holydaysschedule.startat))) as still, "
                + "	if(curdate() > holydaysschedule.endat,if(holydaysschedule.status = 'consumed',holydaysschedule.status,'Should Be Consumed !'),holydaysschedule.status) as status "
                + " FROM employee  "
                + "	join holydaysschedule on holydaysschedule.empno=employee.id "
                + "	join holyday on holyday.id=holydaysschedule.holydayid "
                + "     where employee.id = ? ";

        ArrayList<holyDayInfo> list = new ArrayList<>();
        try {
            if (!fromDate.equals("") && fromDate != null) {
                sqlholday += " and '?' between holydaysschedule.startat and holydaysschedule.endat ";
                if (!toDate.equals("") && toDate != null) {
                    sqlholday += " and '?' between holydaysschedule.startat and holydaysschedule.endat ; ";
                }
            } else if (!toDate.equals("") && toDate != null) {
                sqlholday += " and '?' between holydaysschedule.startat and holydaysschedule.endat ; ";
            }
            PreparedStatement ps = connection.prepareStatement(sqlholday);
            ps.setString(1, id);
            if (!fromDate.equals("") && fromDate != null) {
                ps.setString(2, fromDate);
                if (!toDate.equals("") && toDate != null) {
                    ps.setString(3, toDate);
                }
            } else if (!toDate.equals("") && toDate != null) {
                ps.setString(2, toDate);
            }
            rs = ps.executeQuery();
            while (rs.next()) {
                holyDayInfo holyday = new holyDayInfo();
                holyday.setEmpno(rs.getString("empno"));
                holyday.setFname(rs.getString("fname"));
                holyday.setRestname(rs.getString("restname"));
                holyday.setType(rs.getString("type"));
                holyday.setPeriod(rs.getString("period"));
                holyday.setStartat(rs.getString("startat"));
                holyday.setEndat(rs.getString("endat"));
                holyday.setSummry(rs.getString("summry"));
                holyday.setRealperiod(rs.getString("realperiod"));
                holyday.setRest(rs.getString("still"));
                holyday.setStatus(rs.getString("status"));
                list.add(holyday);
            }
        } catch (Exception e) {
            log.writeEvent("holyDaySummery : " + e.toString());
        }
        return list;
    }
}
