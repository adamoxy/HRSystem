package adamoxy.database;

import adamoxy.common.log;
import adamoxy.setget.EmployeeDetailsInfo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author adam
 */
public class EmployeeDtailsDataSource extends WamyConnection {
//    int id, empno;
//    String address, addressB, phone, phoneB, email, createdAt;

    public EmployeeDetailsInfo getEmployeeDetails(String id) {
        ResultSet resultset;
        EmployeeDetailsInfo employeeData = new EmployeeDetailsInfo();
        String sql = "select * from contact where empno= ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, id);
            resultset = ps.executeQuery();
            if (resultset.next()) {
                employeeData.setId(Integer.parseInt(resultset.getString("id")));
                employeeData.setEmpno(resultset.getInt("empno"));
                employeeData.setNN(resultset.getString("NN"));
                employeeData.setGender(resultset.getString("gender"));
                employeeData.setDOB(resultset.getString("DOB"));
                employeeData.setAddress(resultset.getString("address"));
                employeeData.setAddressB(resultset.getString("addressB"));
                employeeData.setPhone(resultset.getString("phone"));
                employeeData.setPhoneB(resultset.getString("phoneB"));
                employeeData.setEmail(resultset.getString("email"));
                employeeData.setCreatedAt(resultset.getString("createdAt"));
            }
        } catch (Exception e) {

        }

        return employeeData;
    }

    public boolean insertEmployeeDetails(EmployeeDetailsInfo emp) {
        boolean flag = false;
        String sql = "insert into contacts (id,empno,NN,gender,address,addressB,phone,phoneB,email,DOB,createdAt) valuse (default,?,?,?,?,?,?,?,?,?,?)";
        try {

            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setString(1, Integer.toString(emp.getEmpno()));
            ps.setString(2, emp.getNN());
            ps.setString(3, emp.getGender());
            ps.setString(4, emp.getAddress());
            ps.setString(5, emp.getAddressB());
            ps.setString(6, emp.getPhone());
            ps.setString(7, emp.getPhoneB());
            ps.setString(8, emp.getEmail());
            ps.setString(9, emp.getDOB());
            ps.setString(10, emp.getCreatedAt());
            if (ps.executeUpdate() <= 0) {
                flag = true;
            } else {
            }
        } catch (Exception e) {
            log.writeEvent(e.toString());
        }
        return flag;
    }

    public boolean updateEmployeeDetails(EmployeeDetailsInfo emp) {
        boolean updateflag = false;
        String sql = " UPDATE contact Set empno = ? ,address = ? ,addressB = ? ,phone = ?  ,phoneB = ? ,email = ? where id = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, Integer.toString(emp.getEmpno()));
            statement.setString(2, emp.getAddress());
            statement.setString(3, emp.getAddressB());
            statement.setString(4, emp.getPhone());
            statement.setString(5, emp.getPhoneB());
            statement.setString(6, emp.getEmail());
            statement.setInt(7, emp.getId());
            if (statement.executeUpdate() > 0) {
                updateflag = true;
            }
        } catch (SQLException e) {
            log.writeEvent(e.toString());
        } catch (Exception e) {
            log.writeEvent(e.toString());
        }
        return updateflag;
    }
}
