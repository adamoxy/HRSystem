package adamoxy.control;

import adamoxy.database.JobDataSource;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author adam
 */
public class JobControl {

    public static List<HashMap<String, String>> getAllJobsTilte() {
        JobDataSource obj = new JobDataSource();
        List<HashMap<String, String>> list = obj.getAllJobsTilte();
        obj.close();
        return list;
    }

    public static HashMap<String, String> getJobTilteById(String id) {
        JobDataSource obj = new JobDataSource();
        HashMap<String, String> jobtitle = obj.getJobTilteById(id);
        obj.close();
        return jobtitle;
    }

    public boolean insertNewJob(String arabicTitle, String englishTitle) {
        JobDataSource obj = new JobDataSource();
        boolean flag = obj.insertNewJob(arabicTitle, englishTitle);
        obj.close();
        return flag;
    }

    public boolean deleteAjob(String id) {
        JobDataSource obj = new JobDataSource();
        boolean flag = obj.deleteAjob(id);
        obj.close();
        return flag;
    }

    public boolean updateAjob(String arabicTitle, String englishTitle, String id) {
        JobDataSource obj = new JobDataSource();
        boolean flag = obj.updateAjob(arabicTitle, englishTitle, id);
        obj.close();
        return flag;
    }
}
