package adamoxy.database;

import adamoxy.common.log;
import adamoxy.setget.EmployeeInfo;
import adamoxy.setget.TempPoJo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author adam
 */
public class EmployeeDataSource extends WamyConnection {

    public static void main(String[] args) {
        EmployeeDataSource obj = new EmployeeDataSource();
        EmployeeInfo empinfo;

        empinfo = obj.getEmployeeInfoById(7);
        TempPoJo temp = obj.insertNewEmployee(empinfo);
        boolean flag = obj.UpdateEmployeeInfo(empinfo);

        System.out.println("---------------------------------------------------------------------------------------");
        System.out.println("id name \t rest name \t hiredate \t account \t bank \t branch ");
        System.out.println(empinfo.getId() + "\t" + empinfo.getFName() + "\t" + empinfo.getRestname() + "\t" + empinfo.getHiredate()
                + "\t" + empinfo.getAccount() + "\t" + empinfo.getBankname() + "\t" + empinfo.getBranch());
        System.out.println("---------------------------------------------------------------------------------------");
        System.out.println("this the insert info ");
        System.out.println(" operation reult is : " + temp.getBOOLEAN() + "\t and assinged id is :  " + temp.getINT());
        System.out.println("---------------------------------------------------------------------------------------");
        System.out.println("this is the update method test ... ");
        System.out.println("update operation was : " + flag);
        System.out.println("---------------------------------------------------------------------------------------");
    }

    public ArrayList<EmployeeInfo> getAllEmployees() {
        ArrayList<EmployeeInfo> users = new ArrayList<>();

        String sql = "SELECT * FROM employee";//"#id empno fname restname hireDate bankAccount bankName bankBranch";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultset = statement.executeQuery();
            while (resultset.next()) {
                EmployeeInfo empinfo = new EmployeeInfo();
                empinfo.setId(resultset.getInt("id"));
                empinfo.setEmpno(Integer.parseInt(resultset.getString("empno")));
                empinfo.setFName(resultset.getString("fname"));
                empinfo.setRestname(resultset.getString("restname"));
                empinfo.setHiredate(resultset.getString("hireDate"));
                empinfo.setAccount(resultset.getString("bankAccount"));
                empinfo.setBankname(resultset.getString("bankName"));
                empinfo.setBranch(resultset.getString("bankBranch"));
                users.add(empinfo);
            }
        } catch (SQLException e) {
            log.writeEvent("Error in getAllEmployees : " + e.toString());
        } catch (Exception ex) {
            log.writeEvent("Error in getAllEmployees : " + ex.toString());
        }
        return users;
    }

    public EmployeeInfo getEmployeeInfoById(int id) {
        ResultSet resultset;
        EmployeeInfo empinfo = new EmployeeInfo();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM employee where id= ? ");
            statement.setInt(1, id);
            resultset = statement.executeQuery();
            if (resultset.next()) {//(id,empno,fname,restname,hireDate,bankAccount,bankName,bankBranch)
                empinfo.setId(resultset.getInt("id"));
                empinfo.setFName(resultset.getString("fname"));
                empinfo.setRestname(resultset.getString("restname"));
                empinfo.setHiredate(resultset.getString("hireDate"));
                empinfo.setAccount(resultset.getString("bankAccount"));
                empinfo.setBankname(resultset.getString("bankName"));
                empinfo.setBranch(resultset.getString("bankBranch"));

            }
            resultset.close();
        } catch (Exception e) {
            log.writeEvent("Error in getEmployeeInfo : " + e.toString());
        }
        return empinfo;
    }

    public TempPoJo insertNewEmployee(EmployeeInfo employeeinfo) {
        TempPoJo temp = new TempPoJo();
        String[] empno = {"id"};
        String sqlemployee = "insert into employee (id,fname,restname,hireDate,bankAccount,bankName,bankBranch) values(default,?,?,?,?,?,?);";
        try {
            PreparedStatement prepstatement = connection.prepareStatement(sqlemployee, empno);
            prepstatement.setString(1, employeeinfo.getFName());
            prepstatement.setString(2, employeeinfo.getRestname());
            prepstatement.setString(3, employeeinfo.getHiredate());
            prepstatement.setString(4, employeeinfo.getAccount());
            prepstatement.setString(5, employeeinfo.getBankname());
            prepstatement.setString(6, employeeinfo.getBranch());

            if (prepstatement.executeUpdate() > 0) {
                ResultSet rs = prepstatement.getGeneratedKeys();
                if (rs.next()) {
                    temp.setBOOLEAN(true);
                    temp.setINT(rs.getInt(1));
                    temp.setSTRING(Integer.toString(rs.getInt(1)));
                }
            }
        } catch (Exception e) {
            log.writeEvent(e.toString());
        }
        return temp;
    }

    public boolean UpdateEmployeeInfo(EmployeeInfo empinfo) {
        boolean updateflag = false;
        try {//(id,fname,restname,hireDate,bankAccount,bankName,bankBranch)
            PreparedStatement statement = connection.prepareStatement("UPDATE employee SET fname= ? , restname = ? , hireDate = ? , bankAccount = ? , bankName = ? , bankBranch = ? WHERE id = ? ;");
            statement.setString(1, empinfo.getFName());
            statement.setString(2, empinfo.getRestname());
            statement.setString(3, empinfo.getHiredate());
            statement.setString(4, empinfo.getBankname());
            statement.setString(5, empinfo.getAccount());
            statement.setString(6, empinfo.getBranch());
            statement.setInt(7, empinfo.getId());
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
