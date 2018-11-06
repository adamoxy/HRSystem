package adamoxy.database;

import adamoxy.common.log;
import adamoxy.setget.AttendanceInfo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author adam
 */
public class AttendanceDataSource extends WamyConnection {

    public ArrayList<AttendanceInfo> getAllAttendance(String fromDate, String toDate) {
        ResultSet resultset;
        ArrayList<AttendanceInfo> list = new ArrayList<>();
        try {//id empno isAbsent attendDate
            String sql = " SELECT * FROM absence ";
            if (!fromDate.isEmpty() && toDate.isEmpty()|| fromDate.isEmpty() && !toDate.isEmpty()) { //only fromDate param or only toDate param
                sql += " where attendDate = ? ";
            } else if (!fromDate.isEmpty() && !toDate.isEmpty()) {// both params fromDate and toDate
                sql += " where attendDate between ? and ? ";
            }
            PreparedStatement statement = connection.prepareStatement(sql);
            if (!fromDate.isEmpty() && toDate.isEmpty()) { // passing fromDate value
                statement.setString(1, fromDate);
            } else if (fromDate.isEmpty() && !toDate.isEmpty()) { // passing toDate value
                statement.setString(1, toDate);
            } else if (!fromDate.isEmpty() && !toDate.isEmpty()) { // passing Both [ fromDate , toDate ] values 
                statement.setString(1, fromDate);
                statement.setString(2, toDate);
            }
            resultset = statement.executeQuery();
            AttendanceInfo attendancy = null;
            while (resultset.next()) {
                attendancy = new AttendanceInfo();
                attendancy.setId(resultset.getInt("id"));
                attendancy.setEmpno(Integer.parseInt(resultset.getString("empno")));
                attendancy.setIsAbsent(resultset.getString("isAbsent"));
                attendancy.setAttendDate(resultset.getString("attendDate"));
                list.add(attendancy);
            }
            resultset.close();
        } catch (Exception e) {
            log.writeEvent("Error in CheckUserLogin : " + e.toString());
        }
        return list;
    }

    public ArrayList<AttendanceInfo> getEmployeeAttendance(String empNo, String fromDate, String toDate) {
        AttendanceInfo attendanceinfo = null;
        ArrayList<AttendanceInfo> list = new ArrayList<>();
        String sql = "SELECT * FROM absence where empno = ?";
        ResultSet rs;
        try {
            if (!fromDate.isEmpty() && toDate.isEmpty() || fromDate.isEmpty() && !toDate.isEmpty()) {
                sql += " and attendDate >= ? ; ";
            } else if (!fromDate.isEmpty() && !toDate.isEmpty()) {
                sql += " and attendDate between ? and ?";
            }
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, empNo);
            if (!fromDate.isEmpty() && toDate.isEmpty()) { // passing fromDate vale
                statement.setString(2, fromDate);
            } else if (fromDate.isEmpty() && !toDate.isEmpty()) {// passing toDaet value
                statement.setString(2, toDate);
            } else if (!fromDate.isEmpty() && !toDate.isEmpty()) {// passing Both fromDate and toDate values
                statement.setString(2, fromDate);
                statement.setString(3, toDate);
            }

            rs = statement.executeQuery();
            while (rs.next()) {
                attendanceinfo = new AttendanceInfo();
                attendanceinfo.setId(rs.getInt("id"));
                attendanceinfo.setEmpno(Integer.parseInt(rs.getString("empno")));
                attendanceinfo.setIsAbsent(rs.getString("isAbsent"));
                attendanceinfo.setAttendDate(rs.getString("attendDate"));
                list.add(attendanceinfo);
            }
        } catch (Exception e) {
            log.writeEvent("Error in getEmployeeAttendance : " + e.toString());
        }
        return list;
    }

    public boolean inserAttendance(ArrayList<AttendanceInfo> attendanceinfo) {
        boolean insertFlage = false;
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO absence (id,empno,isAbsent,attendDate) VALUES ( default, ?, ?, ?)");
            for (AttendanceInfo emp : attendanceinfo) {
                statement.setInt(1, emp.getEmpno());
                statement.setString(2, emp.getIsAbsent());
                statement.setString(3, emp.getAttendDate());
            }
            if (statement.executeUpdate() > 0) {
                insertFlage = true;
            }
        } catch (Exception ex) {
            log.writeEvent("Error in inserAttendance " + ex.toString());
        }
        return insertFlage;
    }

    public boolean updateAttendance(ArrayList<AttendanceInfo> attendanceinfo) {
        boolean updateflag = false;
        try {
            PreparedStatement statement = connection.prepareStatement("update absence SET isAbsent = ? , attendDate = ? where id = ? and empno = ? ");
            for (AttendanceInfo emp : attendanceinfo) {
                statement.setString(1, emp.getIsAbsent());
                statement.setString(2, emp.getAttendDate());
                statement.setString(3, Integer.toString(emp.getId()));
                statement.setInt(4, emp.getEmpno());
            }
            if (statement.executeUpdate() > 0) {
                updateflag = true;
            }
        } catch (Exception ex) {
            log.writeEvent("Error in inserAttendance " + ex.toString());
        }
        return updateflag;
    }
}
