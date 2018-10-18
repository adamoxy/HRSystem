package adamoxy.database;

import adamoxy.common.Config;
import adamoxy.common.log;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import adamoxy.setget.UsersInfo;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author adam
 */
public class EmployeeDataSource extends WamyConnection {

//    public static void main(String[] args) {
//        UsersInfo uinfo=new UsersInfo();
//        
//ArrayList<UsersInfo> attendinfo = obj.getEmployeeAttendance("2","", "");
//        for (AttendanceInfo emp : attendinfo) {
//            System.out.println(emp.getId());
//            System.out.println(emp.getEmpno());
//            System.out.println(emp.getIsAbsent());
//            System.out.println(emp.getAttendDate());
//        }
//    }
//#id username email rolid password status createat
//this will get all employees from the beging of the company or org (*)
    //return all active employees on the current date(* where curn date between startdate and enddate)
    //return all active employee on spcific period of time (* where startdate=date1 and enddate=date2) 
    public ArrayList<UsersInfo> getAllEmployees() {

        ArrayList<UsersInfo> users = new ArrayList<>();

        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM employee");
            ResultSet resultset = statement.executeQuery();
            while (resultset.next()) {
                UsersInfo userinfo = new UsersInfo();
                userinfo.setId(resultset.getInt("id"));
                userinfo.setUsername(resultset.getString("username"));
                userinfo.setEmail(resultset.getString("email"));
                userinfo.setPassword(resultset.getString("password"));
                userinfo.setRolid(resultset.getInt("rolid"));
                userinfo.setStatus(resultset.getString("status"));
                userinfo.setCreatedAt(resultset.getString("createdAt"));
                users.add(userinfo);
            }
        } catch (SQLException e) {
            log.writeEvent("Error in getAllEmployees : " + e.toString());
        }
        catch(Exception ex){
            log.writeEvent("Error in getAllEmployees : " + ex.toString());
        }
        return users;
    }

    public UsersInfo getEmployeeInfo(int id) {
        ResultSet resultset;
        UsersInfo userinfo = new UsersInfo();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM employee where id= ? ");
            statement.setInt(1, id);
            resultset = statement.executeQuery();
            if (resultset.next()) {
                userinfo.setId(resultset.getInt("id"));
                userinfo.setUsername(resultset.getString("username"));
                userinfo.setEmail(resultset.getString("email"));
                userinfo.setPassword(resultset.getString("password"));
                userinfo.setRolid(resultset.getInt("rolid"));
                userinfo.setStatus(resultset.getString("status"));
                userinfo.setCreatedAt(resultset.getString("createdAt"));
            }
            resultset.close();
        } catch (Exception e) {
            log.writeEvent("Error in getEmployeeInfo : " + e.toString());
        }
        return userinfo;
    }

    public boolean insertNewEmployee(UsersInfo userInfo) {
        boolean insertFlage = false;
        userInfo.setPassword(Config.getMD5(userInfo.getPassword()));
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO employee ( username, email, password, rolid, status,createdAt ) VALUES ( ?, ?, ?, ?, ? , ?)");

            statement.setString(1, userInfo.getUsername());
            statement.setString(2, userInfo.getEmail());
            statement.setString(3, userInfo.getPassword());
            statement.setInt(4, userInfo.getRolid());
            statement.setString(5, userInfo.getStatus());
            statement.setString(6, userInfo.getCreatedAt());
            if (statement.executeUpdate() > 0) {
                insertFlage = true;
            }
        } catch (Exception ex) {
            log.writeEvent("Error in insertNewEmployee : " + ex.toString());
        }
        return insertFlage;
    }

    public boolean UpdateEmployeeInfo(UsersInfo userInfo) {
        boolean updateflag = false;
        try {
            PreparedStatement statement = connection.prepareStatement("UPDATE employee SET username= ? , email = ? , rolid = ? , status = ? , createdAt = ? WHERE id = ? ;");
            statement.setString(1, userInfo.getUsername());
            statement.setString(2, userInfo.getEmail());
            statement.setInt(3, userInfo.getRolid());
            statement.setString(4, userInfo.getStatus());
            statement.setString(5, userInfo.getCreatedAt());
            statement.setInt(6, userInfo.getId());
            if (statement.executeUpdate() > 0) {
                updateflag = true;
            }
        } catch (SQLException e) {
            log.writeEvent("Error in UpdateEmployeeInfo : " + e.toString());
        } catch (Exception ex) {
            log.writeEvent("Error in UpdateEmployeeInfo : " + ex.toString());
        }
        return updateflag;
    }

}
