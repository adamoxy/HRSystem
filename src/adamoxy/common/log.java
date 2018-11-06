package adamoxy.common;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author adam
 */
public class log {

    public static void writeEvent(String eventText) {
        writeEvent(eventText, "wamyHR", "");
    }

    public static void writeEvent(String eventText, String logname, String logdir) {
        try {
            //get the date of the event 
            Date today = new Date();
            Calendar cal = Calendar.getInstance();
            cal.setTime(today);

            int day = cal.get(Calendar.DAY_OF_MONTH);

            //default directory if it is null or empty ...
            if ((logdir == null) || (logdir.isEmpty())) {

                String path = System.getProperty("user.home") + File.separator + "Adamoxy@wamy" + File.separator + "logs" + File.separator;
                logdir = path;
            }

            // Remove last seperator from directory
            if (logdir.substring(logdir.length() - 1, logdir.length()).equals(File.separator)) {
                logdir = logdir.substring(0, logdir.length() - 1);
            }

            // Get today file name
            String fileName;
            fileName = logdir + File.separator + logname + "-" + day + ".log";

            // Check log directory existance
            File dir = new File(logdir);

            if (!dir.exists()) {
                dir.mkdir();
            }

            File file = new File(fileName);

            // Recycle file after 1 month
            if (file.exists()) {

                Date fileDate = new Date();
                Date yesterday = new Date();
                yesterday.setTime(today.getTime() - 1000 * 60 * 60 * 24);
                fileDate.setTime(file.lastModified());

                // Delete old file
                if (fileDate.before(yesterday)) {
                    file.delete();
                }
            }

            // Write into log file
            FileWriter writer = new FileWriter(fileName, true);
            writer.write("\t" + today.toString() + " : " + eventText + "\n\n");
            writer.flush();
            writer.close();

        } catch (IOException e) {
            System.out.println("Unable to write: " + eventText + ", in log file: " + e.toString());
        }
    }

    public static double dateperiod(String nearerDate, String olderDate) {
        LocalDate today = LocalDate.now();
        
        LocalDate nearDate = LocalDate.parse(nearerDate);
        LocalDate historyDate = LocalDate.parse(olderDate);
        Period p = Period.between(historyDate, nearDate);
        return ChronoUnit.DAYS.between(historyDate, nearDate);
    }
    public static void main(String []args){
        System.out.println(log.dateperiod("2018-11-01", "2018-10-01"));
    }

}
