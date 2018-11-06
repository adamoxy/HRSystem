package adamoxy.setget;

/**
 *
 * @author adam
 */
public class SalaryInfo {

    int id, groupId;
    double transport, residence, living, clothing, basicSalary, insurance, netSalary;

    public int getId() {
        return id;
    }

    public void setId() {
        this.id = id;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
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

    public void setNetSalary(double netSalary) {
        this.netSalary = netSalary;
    }

    public double getNetSalary() {
        return netSalary;
    }
}
