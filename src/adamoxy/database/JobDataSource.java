package adamoxy.database;

import adamoxy.common.log;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author adam
 */
public class JobDataSource extends WamyConnection {

    public List<HashMap<String, String>> getAllJobsTilte() {
        List<HashMap<String, String>> list = new ArrayList<>();
        ResultSet rs;
        String sql = "select * from jobs ;";
        try {//,
            PreparedStatement ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                HashMap<String, String> map = new HashMap<>();
                map.put("id", rs.getString("id"));
                map.put("Title", rs.getString("Title"));
                map.put("TitleEng", rs.getString("TitleEng"));
                list.add(map);
            }
        } catch (Exception e) {
            log.writeEvent("getAllJobsTilte \t : " + e.toString());
        }

        return list;
    }

    public HashMap<String, String> getJobTilteById(String id) {

        ResultSet rs;
        HashMap<String, String> map = new HashMap<>();
        String sql = "select * from jobs where id = ? ;";
        try {//,
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {

                map.put("id", rs.getString("id"));
                map.put("Title", rs.getString("Title"));
                map.put("TitleEng", rs.getString("TitleEng"));
            }
        } catch (Exception e) {
            log.writeEvent("getJobTilteById \t : " + e.toString());
        }
        return map;
    }

    public boolean insertNewJob(String arabicTitle, String englishTitle) {
        boolean flag = false;
        String sql = "insert into jobs set jobs.id = Default ,jobs.Title = ? ";
        try {
            if (!englishTitle.trim().isEmpty()) {
                sql += " , jobs.TitleEng = ? ";
            }
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, arabicTitle);
            if (!englishTitle.trim().isEmpty()) {
                ps.setString(2, englishTitle);
            }
            if (ps.executeUpdate() > 0) {
                flag = true;
            }
        } catch (SQLException e) {
            log.writeEvent("insertNewJob :" + e.toString());
        } catch (Exception ex) {
            log.writeEvent("insertNewJob : " + ex.toString());
        }
        return flag;
    }

    public boolean deleteAjob(String id) {
        boolean flag = false;
        String sql = " DELETE FROM jobs WHERE id= ? ;";
        try {
            PreparedStatement statment = connection.prepareStatement(sql);
            statment.setString(1, id);
            if (statment.execute()) {
                flag = true;
            }
        } catch (Exception e) {
            log.writeEvent("deleteAjob : " + e.toString());
        }
        return flag;
    }

    public boolean updateAjob(String arabicTitle, String EnglishTitle, String id) {
        boolean flag = false;
        String sql = " UPDATE jobs SET Title= ? ";
        if (!EnglishTitle.trim().isEmpty()) {
            sql += " , TitleEng = ? ";
        }
        sql += " WHERE id = ? ; ";
        try {
            PreparedStatement statment = connection.prepareStatement(sql);
            statment.setString(1, arabicTitle);
            if (EnglishTitle.trim().isEmpty()) {
                statment.setString(2, id);
            } else {
                statment.setString(2, EnglishTitle);
                statment.setString(3, id);
            }
            if (statment.executeUpdate() > 0) {
                flag = true;
            }
        } catch (Exception e) {
            log.writeEvent(e.toString());
        }
        return flag;
    }

}
