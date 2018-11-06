
package adamoxy.setget;

/**
 *
 * @author adam
 */
public class MonthlysalInfo {

    String from_date, to_date;
    int id, empno, salarygroup_id;

    public void setId(int id) {
        this.id = id;
    }

    public void setEmpno(int empno) {
        this.empno = empno;
    }

    public void setSalarygroup_id(int salarygroup_id) {
        this.salarygroup_id = salarygroup_id;
    }

    public void setFrom_date(String from_date) {
        this.from_date = from_date;
    }

    public void setTo_date(String to_date) {
        this.to_date = to_date;
    }

    public int getId() {
        return id;
    }

    public int getEmpno() {
        return empno;
    }

    public int getSalarygroup_id() {
        return salarygroup_id;
    }

    public String getFrom_date() {
        return from_date;
    }

    public String getTo_date() {
        return to_date;
    }

}
