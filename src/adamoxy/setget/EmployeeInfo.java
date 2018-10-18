package adamoxy.setget;

/**
 *
 * @author adam
 */
public class EmployeeInfo {

    public String fname, restname, nationality, hireDate, depaprtment, workTime, jobTitle, status;//date
    public int empno, id;//1,2,3,4
    public EmployeeDetailsInfo employeeDetails;

    public void setId(int id) {
        this.id = id;
    }

    public void setEmpno(int empno) {
        this.empno = empno;
    }

    public void setFullName(String fname) {
        this.fname = fname;
    }

    public void setRestname(String restname) {
        this.restname = restname;
    }

    public void setHiredate(String hireDate) {
        this.hireDate = hireDate;
    }

    public void setDepaprtment(String depaprtment) {
        this.depaprtment = depaprtment;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setWorkTime(String workTime) {
        this.workTime = workTime;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public int getId() {
        return id;
    }

    public int getEmpno() {
        return empno;
    }

    public String getFullName() {
        return fname;
    }

    public String getRestname() {
        return restname;
    }
   public String getHiredate() {
        return hireDate;
    }

    public String getDepaprtment() {
        return depaprtment;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public String getStatus() {
        return status;
    }

    public String getWorkTime() {
        return workTime;
    }

    public String getNationality() {
        return nationality;
    }

}
