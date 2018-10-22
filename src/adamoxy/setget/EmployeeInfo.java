package adamoxy.setget;

/**
 *
 * @author adam
 */
public class EmployeeInfo {

    public String fname, restname, nationality, hireDate, depaprtment, 
            workTime, jobTitle, status, fromDate, toDate, note, bankname, branch, account;//date
    public int empno, id;//1,2,3,4
    public EmployeeDetailsInfo empDetails;//EmployeeDetailsInfo : [ id, empno ,address, addressB, phone, phoneB, email, createdAt,NN, DOB, gender ]
    public SalaryInfo salary;// SalaryInfo : empno,groupId;
    // public String ;
    public JobInfo job;
    public AttachmentInfo attachment;
    public TempPoJo setget;

    public void setId(int id) {
        this.id = id;
    }

    public void setEmpno(int empno) {
        this.empno = empno;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getNote() {
        return note;
    }

    public void setFName(String fname) {
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

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    public void setToDate(String toDate) {
        this.toDate = toDate;
    }

    public int getId() {
        return id;
    }

    public int getEmpno() {
        return empno;
    }

    public String getFName() {
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

    public String getFromDate() {
        return fromDate;
    }

    public String getToDate() {
        return toDate;
    }
    public void setBankname(String bankname) {
        this.bankname = bankname;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getBankname() {
        return bankname;
    }

    public String getAccount() {
        return account;
    }

    public String getBranch() {
        return branch;
    }
}
