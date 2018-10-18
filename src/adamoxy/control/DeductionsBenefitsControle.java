
package adamoxy.control;

import adamoxy.common.log;
import adamoxy.database.DeductionsBenefits;

/**
 *
 * @author adam
 */
public class DeductionsBenefitsControle {

    /*    public String[] getAllDeductionsBenefits() {}
     */
    public static String[] getAllDeductionsBenefits() {
        DeductionsBenefits obj = new DeductionsBenefits();
        String[] deductionsBenefits = null;
        try {
            deductionsBenefits = obj.getAllDeductionsBenefits();

        } catch (Exception e) {
            log.writeEvent(e.toString());
        }
        return deductionsBenefits;
    }

    /*    public String[] getOnlyDeductions() {}
     */
    public static String[] getOnlyDeductions() {
        DeductionsBenefits obj = new DeductionsBenefits();
        String[] deductions = null;
        try {
            deductions = obj.getOnlyDeductions();

        } catch (Exception e) {
            log.writeEvent(e.toString());
        }
        return deductions;
    }

    /*        public String[] getOnlyBenefits() {}
     */
    public static String[] getOnlyBenefits() {
        DeductionsBenefits obj = new DeductionsBenefits();
        String[] benefits = obj.getOnlyBenefits();
        try {

        } catch (Exception e) {
            log.writeEvent(e.toString());
        }
        return benefits;
    }
}
