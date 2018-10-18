
package adamoxy.setget;

/**
 *
 * @author adam
 */
public class SalaryInfo {

    /*
     select ES.empno empno, E.fname fName, E.restname lName,
		S.basic_salary AS basicSalary ,
		S.transport AS transport ,
		S.Residence AS residence ,
		S.Living AS living ,
		S.clothing AS clothing , 
        S.insurance AS insurance ,
        IFNULL(S.transport, 0) + IFNULL(S.Residence, 0) + IFNULL(S.Living, 0) + IFNULL(S.clothing, 0) + IFNULL(S.basic_salary, 0) AS Benefits,
        S.insurance as deductions,
        IFNULL(S.transport, 0) + IFNULL(S.Residence, 0) + IFNULL(S.Living, 0) + IFNULL(S.clothing, 0) + IFNULL(S.basic_salary, 0) +ifnull(S.insurance,0) as netSalary,
        S.groupname AS groupName,
        S.groupid as groupId,
        ES.from_date AS fromDate,
        ES.to_date AS toDate
     */
    int empno,groupId;
    double transport,residence,living,clothing,basicSalary, insurance,Benefits,deductions,netSalary;
    String fName,lName,groupName,fromDate,toDate;
    
    public int getEmpno() {
        return empno;
    }
    public void setEmpno(int empno) {
        this.empno = empno;
    }
    public int getId() {
        return groupId;
    }
    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }
    
    public String getFName() {
        return fName;
    }
    public void setFName(String fName) {
        this.fName = fName;
    }
    public String getLName() {
        return lName;
    }
    public void setLName(String lName) {
        this.lName = lName;
    }
    public String getGroupName() {
        return groupName;
    }
    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
    public String getFromDate() {
        return fromDate;
    }
    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }
    public String getToDate() {
        return toDate;
    }
    public void setToDate(String toDate) {
        this.toDate = toDate;
    }
    
    public void setTransport(double transport) {
        this.transport = transport;
    }
    public double getTransport() {
        return transport;
    }
    public void setResidence(double residence) {
        this.residence = residence;
    }
    public double getResidence() {
        return residence;
    }
    public void setLiving(double living) {
        this.living = living;
    }
    public double getLiving() {
        return living;
    }
    public void setClothing(double clothing) {
        this.clothing = clothing;
    }
    public double getClothing() {
        return clothing;
    }
    //, ,,,
    
        public void setBasicSalary(double basicSalary) {
        this.basicSalary = basicSalary;
    }
    public double getBasicSalary() {
        return basicSalary;
    }
    public void setInsurance(double insurance) {
        this.insurance = insurance;
    }
    public double getInsurance() {
        return insurance;
    }
    public void setBenefits(double Benefits) {
        this.Benefits = Benefits;
    }
    public double getBenefits() {
        return Benefits;
    }
    public void setDeductions(double deductions) {
        this.deductions = deductions;
    }
    public double getDeductions() {
        return deductions;
    }
     public void setNetSalary(double netSalary) {
        this.netSalary = netSalary;
    }
    public double getNetSalary() {
        return netSalary;
    }
}
