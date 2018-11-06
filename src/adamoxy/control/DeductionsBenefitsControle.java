package adamoxy.control;

import adamoxy.database.DeductionsBenefits;

/**
 *
 * @author adam
 */
public class DeductionsBenefitsControle {

    public static String[] getAllDeductionsBenefits() {
        DeductionsBenefits obj = new DeductionsBenefits();
        String[] deductionsBenefits = obj.getAllDeductionsBenefits();
        obj.close();
        return deductionsBenefits;
    }

    public static String[] getOnlyDeductions() {
        DeductionsBenefits obj = new DeductionsBenefits();
        String[] deductions = obj.getOnlyDeductions();
        obj.close();
        return deductions;
    }

    public static String[] getOnlyBenefits() {
        DeductionsBenefits obj = new DeductionsBenefits();
        String[] benefits = obj.getOnlyBenefits();
        obj.close();
        return benefits;
    }
}
