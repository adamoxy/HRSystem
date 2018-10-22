package adamoxy.setget;

/**
 *
 * @author adam
 */
public class EmployeeDetailsInfo {
//                //(id,empno,NN,gender,address,addressB,phone,phoneB,email,DOB,createdAt) 
    int id, empno;
    String address, addressB, phone, phoneB, email, createdAt,NN, DOB, gender,nationalityId;

    public void setNationalityId(String nationalityId){
        this.nationalityId=nationalityId;
    }
    public String getNationalityId(){
        return nationalityId;
    }
    public void setId(int id) {
        this.id = id;
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
