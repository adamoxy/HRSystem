
package adamoxy.setget;

/**
 *
 * @author adam
 */
public class AttendanceInfo {
    
    public int empno,id;
    
    String isAbsent;
    
    public String attendDate;
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getEmpno() {
        return empno;
    }
    public void setEmpno(int empno) {
        this.empno = empno;
    }     
    public String getIsAbsent() {
        return isAbsent;
    }
    public void setIsAbsent(String isAbsent) {
        this.isAbsent = isAbsent;
    }
    public String getAttendDate() {
        return attendDate;
    }
    public void setAttendDate(String attendDate) {
        this.attendDate = attendDate;
    }
}
