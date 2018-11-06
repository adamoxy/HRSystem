package adamoxy.control;

import adamoxy.database.AttendanceDataSource;
import adamoxy.setget.AttendanceInfo;
import java.util.ArrayList;

/**
 *
 * @author adam
 */
public class AttendanceContorle {

    public static ArrayList<AttendanceInfo> getAllAttendance(String fromDate, String toDate) {
        AttendanceDataSource obj = new AttendanceDataSource();
        ArrayList<AttendanceInfo> attendinfo = obj.getAllAttendance(fromDate, toDate);
        obj.close();
        return attendinfo;
    }

    public static ArrayList<AttendanceInfo> getEmployeeAttendance(String empNo, String fromDate, String toDate) {
        AttendanceDataSource obj = new AttendanceDataSource();
        ArrayList<AttendanceInfo> attendinfo = obj.getEmployeeAttendance(empNo, fromDate, toDate);
        obj.close();
        return attendinfo;
    }

    public static boolean inserAttendance(ArrayList<AttendanceInfo> attendanceinfo) {
        AttendanceDataSource obj = new AttendanceDataSource();
        boolean flag = obj.inserAttendance(attendanceinfo);
        obj.close();
        return flag;
    }

    public static boolean updateAttendance(ArrayList<AttendanceInfo> attendanceinfo) {
        AttendanceDataSource obj = new AttendanceDataSource();
        boolean flag = obj.updateAttendance(attendanceinfo);
        obj.close();
        return flag;
    }

}
