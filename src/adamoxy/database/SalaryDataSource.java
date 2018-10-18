package adamoxy.database;

import adamoxy.common.log;
import adamoxy.setget.SalaryInfo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * @author adam
 */
public class SalaryDataSource extends WamyConnection {

    /*    
    int empno,groupId;
    double transport,residence,living,clothing,basicSalary, insurance,Benefits,deductions,netSalary;
    String fName,lName,groupName,fromDate,toDate;
     */
    public ArrayList<SalaryInfo> getMonthlySalary(String fromDate, String toDate) {
        ResultSet resultset;
        ArrayList<SalaryInfo> list = new ArrayList<>();
        String col = "";//attribute,sign
        try {
            /* fetch all the deductions_benefits to enhance the query */
            PreparedStatement stmt = connection.prepareStatement("SELECT * from deductions_benefits");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                col += rs.getString("sign") + " " + rs.getString("attribute");
            }
            /**************************** */

            String sql = "select ES.empno empno, E.fname fName, E.restname lName,"
                    + " S.basic_salary AS basicSalary ,"
                    + " S.transport AS transport ,"
                    + " S.Residence AS residence ,"
                    + " S.Living AS living ,"
                    + " S.clothing AS clothing ,"
                    + " S.insurance AS insurance ,"
                    + " IFNULL(S.transport, 0) + IFNULL(S.Residence, 0) + IFNULL(S.Living, 0) + IFNULL(S.clothing, 0) + IFNULL(S.basic_salary, 0) AS benefits,"
                    + " S.insurance as deductions,"
                    + " IFNULL(S.transport, 0) + IFNULL(S.Residence, 0) + IFNULL(S.Living, 0) + IFNULL(S.clothing, 0) + IFNULL(S.basic_salary, 0) +ifnull(S.insurance,0) as netSalary,"
                    + " S.groupname AS groupName,"
                    + " S.groupid as groupId,"
                    + " ES.from_date AS fromDate,"
                    + "   ES.to_date AS toDate"
                    + " FROM emp_salary ES "
                    + "   JOIN salaries S ON S.groupid = ES.salarygroup_id"
                    + "   JOIN employee E ON ES.empno = E.empno ";

            if (!fromDate.isEmpty() && !toDate.isEmpty()) {
                sql += " where ES.from_date= ? and ES.to_date= ? ;";
            }
            PreparedStatement statement = connection.prepareStatement(sql);
            if (!fromDate.isEmpty() && !toDate.isEmpty()) {
                statement.setString(1, fromDate);
                statement.setString(1, toDate);
            }
            resultset = statement.executeQuery();
            while (resultset.next()) {
                SalaryInfo salinfo = new SalaryInfo();
                salinfo.setEmpno(resultset.getInt("empno"));
                salinfo.setGroupId(resultset.getInt("groupId"));
                salinfo.setFName(resultset.getString("fName"));
                salinfo.setLName(resultset.getString("lName"));
                salinfo.setGroupName(resultset.getString("groupName"));
                salinfo.setFromDate(resultset.getString("fromDate"));
                salinfo.setToDate(resultset.getString("toDate"));
                salinfo.setTransport(resultset.getDouble("transport"));
                salinfo.setResidence(resultset.getDouble("residence"));
                salinfo.setLiving(resultset.getDouble("living"));
                salinfo.setClothing(resultset.getDouble("clothing"));
                salinfo.setBasicSalary(resultset.getDouble("basicSalary"));
                salinfo.setInsurance(resultset.getDouble("insurance"));
                salinfo.setBenefits(resultset.getDouble("benefits"));
                salinfo.setDeductions(resultset.getDouble("deductions"));
                salinfo.setNetSalary(resultset.getDouble("netSalary"));
                list.add(salinfo);
            }
        } catch (Exception ex) {
            log.writeEvent("Error in getMonthlySalary : " + ex.toString());
        }
        return list;
    }

    public SalaryInfo getMonthlySalaryById(String id, String fromDate, String toDate) {
        SalaryInfo salinfo = new SalaryInfo();
        ResultSet resultset;
        String sql = "select ES.empno empno, E.fname fName, E.restname lName,"
                + "	S.basic_salary AS basicSalary ,"
                + "	S.transport AS transport ,"
                + "	S.Residence AS residence ,"
                + "	S.Living AS living ,"
                + " S.clothing AS clothing ,"
                + " S.insurance AS insurance ,"
                + " IFNULL(S.transport, 0) + IFNULL(S.Residence, 0) + IFNULL(S.Living, 0) + IFNULL(S.clothing, 0) + IFNULL(S.basic_salary, 0) AS benefits,"
                + " S.insurance as deductions,"
                + " IFNULL(S.transport, 0) + IFNULL(S.Residence, 0) + IFNULL(S.Living, 0) + IFNULL(S.clothing, 0) + IFNULL(S.basic_salary, 0) +ifnull(S.insurance,0) as netSalary,"
                + " S.groupname AS groupName,"
                + " S.groupid as groupId,"
                + " ES.from_date AS fromDate,"
                + "    ES.to_date AS toDate"
                + " FROM emp_salary ES "
                + "    JOIN salaries S ON S.groupid = ES.salarygroup_id"
                + "    JOIN employee E ON ES.empno = E.empno"
                + " where  ES.empno= ? and ES.from_date= ? and ES.to_date= ?;";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, id);
            statement.setString(2, fromDate);
            statement.setString(3, toDate);

            resultset = statement.executeQuery();

            if (resultset.next()) {
                salinfo.setEmpno(resultset.getInt("empno"));
                salinfo.setGroupId(resultset.getInt("groupId"));
                salinfo.setFName(resultset.getString("fName"));
                salinfo.setLName(resultset.getString("lName"));
                salinfo.setGroupName(resultset.getString("groupName"));
                salinfo.setFromDate(resultset.getString("fromDate"));
                salinfo.setToDate(resultset.getString("toDate"));
                salinfo.setTransport(resultset.getDouble("transport"));
                salinfo.setResidence(resultset.getDouble("residence"));
                salinfo.setLiving(resultset.getDouble("living"));
                salinfo.setClothing(resultset.getDouble("clothing"));
                salinfo.setBasicSalary(resultset.getDouble("basicSalary"));
                salinfo.setInsurance(resultset.getDouble("insurance"));
                salinfo.setBenefits(resultset.getDouble("benefits"));
                salinfo.setDeductions(resultset.getDouble("deductions"));
                salinfo.setNetSalary(resultset.getDouble("netSalary"));
            }
        } catch (Exception ex) {

            log.writeEvent("Error in getMonthlySalary : " + ex.toString());
        }
        return salinfo;
    }
}
