
package adamoxy.database;

import adamoxy.common.log;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author adam
 */
public class DeductionsBenefits extends WamyConnection {

//    public static void main(String args[]) {
//        DeductionsBenefits obj = new DeductionsBenefits();
//        try {
//            String[] deductions = obj.getOnlyDeductions();
//            String[] benefits = obj.getOnlyBenefits();
//            String[] loop = obj.getAllDeductionsBenefits();
////            String[] loop = (String[]) obj.getAllDeductionsBenefits();
//
//            System.out.println("all of them together ");
//            for (String str : loop) {
//                System.out.print(str + " ");  //Will print the strings in the array that
//
//            }
//            System.out.println();
//            System.out.println("benefits");
//            for (String str : benefits) {
//
//                System.out.print(str + " ");  //Will print the strings in the array that
//            }
//            System.out.println();
//            System.out.println("deductions");
//            for (String str : deductions) {
//                System.out.print(str + " ");  //Will print the strings in the array that
//            }
//        } catch (Exception e) {
//            System.out.println(e.toString());
//        }
//
//    }

    public String[] getAllDeductionsBenefits() {
        String[] arr = null;
        int i = 0, x = 0;
        try {
            PreparedStatement ps1 = connection.prepareStatement("select count(*) from deductions_benefits");
            ResultSet rs1 = ps1.executeQuery();
            while (rs1.next()) {
                x = Integer.parseInt(rs1.getString(1));
            }
            arr = new String[x];
            PreparedStatement ps = connection.prepareStatement("SELECT * from deductions_benefits");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                arr[i] = (" " + rs.getString("sign") + "" + rs.getString("attribute"));
                i++;
            }
        } catch (java.lang.NullPointerException e) {
            log.writeEvent("Error in getAllDeductionsBenefits : " + e.toString());
        } catch (Exception ex) {
            log.writeEvent("Error in getAllDeductionsBenefits : " + ex.toString());
        }
        return arr;
    }

    public String[] getOnlyDeductions() {
        String[] arr = null;
        int i = 0, x = 0;
        try {
            PreparedStatement ps1 = connection.prepareStatement("SELECT count(*) FROM wamy_hr.deductions_benefits where sign = '-';");
            ResultSet rs1 = ps1.executeQuery();
            while (rs1.next()) {
                x = Integer.parseInt(rs1.getString(1));
            }
            arr = new String[x];
            PreparedStatement ps = connection.prepareStatement("SELECT * from deductions_benefits where sign = '-';");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                arr[i] = (" " + rs.getString("sign") + "" + rs.getString("attribute"));
                i++;
            }
        } catch (java.lang.NullPointerException e) {
            log.writeEvent("Error in getOnlyDeductions : " + e.toString());
        } catch (Exception ex) {
            log.writeEvent("Error in getOnlyDeductions : " + ex.toString());
        }
        return arr;
    }

    public String[] getOnlyBenefits() {
        String[] arr = null;
        int i = 0, x = 0;
        try {
            PreparedStatement ps1 = connection.prepareStatement("SELECT count(*) FROM wamy_hr.deductions_benefits where sign = '+';");
            ResultSet rs1 = ps1.executeQuery();
            while (rs1.next()) {
                x = Integer.parseInt(rs1.getString(1));
            }
            arr = new String[x];
            PreparedStatement ps = connection.prepareStatement("SELECT * from deductions_benefits where sign = '+';");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                arr[i] = (" " + rs.getString("sign") + "" + rs.getString("attribute"));
                i++;
            }
        } catch (java.lang.NullPointerException e) {
            log.writeEvent("Error in getOnlyBenefits : " + e.toString());
        } catch (Exception ex) {
            log.writeEvent("Error in getOnlyBenefits : " + ex.toString());
        }
        return arr;
    }

}
