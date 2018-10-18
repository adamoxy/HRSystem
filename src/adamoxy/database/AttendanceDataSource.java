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
            String sql = "";
            if (fromDate.isEmpty() && toDate.isEmpty()) {
                sql += "SELECT * FROM absence";
            } else if (!fromDate.isEmpty() && toDate.isEmpty()) {
                sql += "SELECT * FROM absence where attendDate >= ? ; ";
            } else if (!fromDate.isEmpty() && !toDate.isEmpty()) {
                sql += "SELECT * FROM absence where attendDate between ? and ?";
            }
            PreparedStatement statement = connection.prepareStatement(sql);
            if (fromDate.isEmpty() && toDate.isEmpty()) {
                // no need for arguments here 
            } else if (!fromDate.isEmpty() && toDate.isEmpty()) {
                statement.setString(1, fromDate);
            } else if (!fromDate.isEmpty() && !toDate.isEmpty()) {
                statement.setString(1, fromDate);
                statement.setString(2, toDate);//statement.setString(2, Config.getMD5(password));
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
        String sql = "";
        ResultSet rs;
        try {
            if (fromDate.isEmpty() && toDate.isEmpty()) {
                sql += "SELECT * FROM absence where empno = ?";
            } else if (!fromDate.isEmpty() && toDate.isEmpty()) {

                sql += "SELECT * FROM absence where empno= ? and attendDate >= ? ; ";

            } else if (!fromDate.isEmpty() && !toDate.isEmpty()) {

                sql += "SELECT * FROM absence where empno = ? attendDate between ? and ?";
            }
            PreparedStatement statement = connection.prepareStatement(sql);

            if (fromDate.isEmpty() && toDate.isEmpty()) {

                statement.setString(1, empNo);
            } else if (!fromDate.isEmpty() && toDate.isEmpty()) {

                statement.setString(1, empNo);
                statement.setString(2, fromDate);
            } else if (!fromDate.isEmpty() && !toDate.isEmpty()) {

                statement.setString(1, empNo);
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

//    public static void main(String[] args) {
//        AttendanceDataSource obj = new AttendanceDataSource();
//        
//        AttendanceInfo attinfo=new AttendanceInfo();
//        ArrayList<AttendanceInfo> list=new ArrayList<>();
//        attinfo.setId(1);
//        attinfo.setEmpno(1);
//        attinfo.setIsAbsent("false");
//        attinfo.setAttendDate("2001-11-10");
//        list.add(attinfo);
//        boolean isupdated= obj.updateAttendance(list);
//        System.out.println(isupdated);
//        
//        
////        ArrayList<AttendanceInfo> attendinfo = obj.getEmployeeAttendance("2","", "");
////        for (AttendanceInfo emp : attendinfo) {
////            System.out.println(emp.getId());
////            System.out.println(emp.getEmpno());
////            System.out.println(emp.getIsAbsent());
////            System.out.println(emp.getAttendDate());
////        }
//    }
}
