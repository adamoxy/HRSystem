package adamoxy.setget;

/**
 *
 * @author adam
 */
public class JobInfo {

    public  int id, empno;
    public String jobname, department, salarygroup, jobstart, jobend, jobnotes;
    public AttachmentInfo attachment;

    public void setId(int id) {
        this.id = id;
    }

    public void setEmpno(int empno) {
        this.empno = empno;
    }

    public void setJobname(String jobname) {
        this.jobname = jobname;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setSalarygroup(String salarygroup) {
        this.salarygroup = salarygroup;
    }

    public void setJobstart(String jobstart) {
        this.jobstart = jobstart;
    }

    public void setJobend(String jobend) {
        this.jobend = jobend;
    }

    public void setJobnotes(String jobnotes) {
        this.jobnotes = jobnotes;
    }

    public int getId() {
        return id;
    }

    public int getEmpno() {
        return empno;
    }

    public String setJobname() {
        return jobname;
    }

    public String setDepartment() {
        return department;
    }

    public String setSalarygroup() {
        return salarygroup;
    }

    public String setJobstart() {
        return jobstart;
    }

    public String setJobend() {
        return jobend;
    }

    public String setJobnotes() {
        return jobnotes;
    }

}
