package adamoxy.control;

import adamoxy.database.HolydayDataSource;
import adamoxy.setget.holyDayInfo;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author adam
 */
public class HolydayControl {

    public static ArrayList<holyDayInfo> getAllHolydaySummery(String department, String fromDate, String toDate) {
        HolydayDataSource obj = new HolydayDataSource();
        ArrayList<holyDayInfo> list = obj.getAllHolydaySummery(department, fromDate, toDate);
        obj.close();
        return list;
    }

    public static ArrayList<holyDayInfo> getHolydaySummeryById(String id, String fromDate, String toDate) {
        HolydayDataSource obj = new HolydayDataSource();
        ArrayList<holyDayInfo> list = obj.getHolydaySummeryById(id, fromDate, toDate);
        obj.close();
        return list;

    }

    public static void main(String[] args) throws ParseException {
        ArrayList<holyDayInfo> list = HolydayControl.getAllHolydaySummery("all", "", "");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        String today = sdf.format(date);
        String endDate = null;

        for (holyDayInfo prin : list) {
            endDate = sdf.format(sdf.parse(prin.getEndat()));

            if (today.compareTo(endDate) > 0) {
                System.out.println("today is after Date2");
                System.out.println("today : " + today);
                System.out.println("endDate : " + endDate);

            } else if (today.compareTo(endDate) < 0) {

                System.out.println("today is before Date2");
                System.out.println("today : " + today);
                System.out.println("endDate : " + endDate);
            } else if (today.compareTo(endDate) == 0) {

                System.out.println("today is equal to Date2");
                System.out.println("today : " + today);
                System.out.println("endDate : " + endDate);
            }
        }

      
    }
}
