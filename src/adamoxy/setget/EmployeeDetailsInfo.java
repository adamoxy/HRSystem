package adamoxy.setget;

/**
 *
 * @author adam
 */
public class EmployeeDetailsInfo {

    private int id, empno;
    private String address, mStatus, addressB, phone, phoneB, email, createdAt, NN, DOB, age, gender, nationalityId, nationality;

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getAge() {
        return age;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationalityId(String nationalityId) {
        this.nationalityId = nationalityId;
    }

    public String getNationalityId() {
        return nationalityId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setMStatus(String mStatus) {
        this.mStatus = mStatus;
    }

    public String getMStatus() {
        return mStatus;
    }

    public int getId() {
        return id;
    }

    public void setEmpno(int empno) {
        this.empno = empno;
    }

    public int getEmpno() {
        return empno;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setAddressB(String addressB) {
        this.addressB = addressB;
    }

    public String getAddressB() {
        return addressB;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhoneB(String phoneB) {
        this.phoneB = phoneB;
    }

    public String getPhoneB() {
        return phoneB;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setNN(String NN) {
        this.NN = NN;
    }

    public String getNN() {
        return NN;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public String getDOB() {
        return DOB;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

}
