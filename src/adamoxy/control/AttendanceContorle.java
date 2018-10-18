package adamoxy.control;

import adamoxy.common.log;
import adamoxy.database.AttendanceDataSource;
import adamoxy.setget.AttendanceInfo;
import java.util.ArrayList;

/**
 *
 * @author adam
 */
public class AttendanceContorle {

    /*    public ArrayList<AttendanceInfo> getAllAttendance(String fromDate, String toDate) {}
     */
    public static ArrayList<AttendanceInfo> getAllAttendance(String fromDate, String toDate) {
        AttendanceDataSource obj = new AttendanceDataSource();
        ArrayList<AttendanceInfo> attendinfo =null;
        try{
        attendinfo = obj.getAllAttendance(fromDate, toDate);
            
        }catch(Exception e){
            log.writeEvent(e.toString());
        }
        return attendinfo;
    }

    /*    public ArrayList<AttendanceInfo> getEmployeeAttendance(String empNo, String fromDate, String toDate) {}
     */
    public static ArrayList<AttendanceInfo> getEmployeeAttendance(String empNo, String fromDate, String toDate) {
        AttendanceDataSource obj = new AttendanceDataSource();
         ArrayList<AttendanceInfo> attendinfo =null;
        try{
         attendinfo = obj.getEmployeeAttendance(empNo, fromDate, toDate);
            
        }catch(Exception e){
            log.writeEvent(e.toString());
        }
        return attendinfo;
    }

    /*   public boolean inserAttendance(ArrayList<AttendanceInfo> attendanceinfo) {}
     */
    public static boolean inserAttendance(ArrayList<AttendanceInfo> attendanceinfo) {
        AttendanceDataSource obj = new AttendanceDataSource();
        boolean flag = false;
        try {
            flag = obj.inserAttendance(attendanceinfo);
        } catch (Exception e) {
            log.writeEvent(e.toString());
        }
        return flag;
    }

    /*
    public boolean updateAttendance(ArrayList<AttendanceInfo> attendanceinfo) {}
     */
    public static boolean updateAttendance(ArrayList<AttendanceInfo> attendanceinfo) {
        AttendanceDataSource obj = new AttendanceDataSource();
        boolean flag = false;
        try {
            flag = obj.updateAttendance(attendanceinfo);
        } catch (Exception e) {
            log.writeEvent("Error in updateAttendance : " + e.toString());
        }

        return flag;
    }

}
