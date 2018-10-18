
package adamoxy.control;

import adamoxy.common.log;
import adamoxy.database.SalaryDataSource;
import adamoxy.setget.SalaryInfo;
import java.util.ArrayList;

/**
 *
 * @author adam
 */
public class SalaryControl {

    public static ArrayList<SalaryInfo> getMonthlySalary(String fromDate, String toDate) {
        SalaryDataSource salary = new SalaryDataSource();
        ArrayList<SalaryInfo> sal = null;
        try {
            sal = salary.getMonthlySalary(fromDate, toDate);

        } catch (Exception e) {
            log.writeEvent(e.toString());
        }
        return sal;
    }

    public static SalaryInfo getMonthlySalaryById(String id, String fromDate, String toDate) {
        SalaryDataSource salary = new SalaryDataSource();
        SalaryInfo sal = null;
        try {
            sal = salary.getMonthlySalaryById(id, fromDate, toDate);

        } catch (Exception e) {
            log.writeEvent(e.toString());
        }
        return sal;
    }
}
