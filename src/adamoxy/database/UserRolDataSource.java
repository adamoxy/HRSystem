package adamoxy.database;

import adamoxy.common.log;
import adamoxy.setget.UserRolInfo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import adamoxy.setget.UsersInfo;
import java.util.ArrayList;

/**
 *
 * @author adam
 */
public class UserRolDataSource extends WamyConnection {

    public static void main(String[] args) {
        UserRolDataSource obj = new UserRolDataSource();
        obj.insertNewRol("test two", "this is also just a test");
//        System.out.println(obj.insertNewRol("new roll","this is new roll for checking the insert process"));
////        ArrayList<UserRolInfo> users = obj.getAllRols();
////
////        for (UserRolInfo list : users) {
////            System.out.println(list.getId());
////            System.out.println(list.getRolname());
////            System.out.println(list.getRolDescription());
////
////        }
    }
    public UserRolInfo getRolById(String id) {
        UserRolInfo user = new UserRolInfo();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM rols where id=? ");
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                user.setId(rs.getInt("id"));
                user.setRolname(rs.getString("name"));
                user.setRolDescription(rs.getString("description"));
            }

        } catch (Exception e) {
            log.writeEvent(e.toString());
        }
        return user;
    }

    public ArrayList<UserRolInfo> getAllRols() {

        ArrayList<UserRolInfo> users = new ArrayList<>();
        UserRolInfo userinfo = null;
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM rols");
            ResultSet resultset = statement.executeQuery();

            while (resultset.next()) {
                userinfo = new UserRolInfo();
                userinfo.setId(resultset.getInt("id"));
                userinfo.setRolname(resultset.getString("name"));
                userinfo.setRolDescription(resultset.getString("description"));
                users.add(userinfo);
            }
        } catch (Exception e) {
            log.writeEvent("Error in getRolsData : " + e.toString());
        }
        return users;
    }

    //this will return all user with the spcific role
    public UsersInfo getAllUsersInRoleInfo(int id) {
        ResultSet resultset;
        UsersInfo userinfo = new UsersInfo();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM users where rolid= ? ");
            statement.setInt(1, id);
            resultset = statement.executeQuery();
            if (resultset.next()) {
                userinfo.setId(resultset.getInt("id"));
                userinfo.setUsername(resultset.getString("username"));
                userinfo.setEmail(resultset.getString("email"));
                userinfo.setPassword(resultset.getString("password"));
                userinfo.setRolid(resultset.getInt("rolid"));
                userinfo.setStatus(resultset.getString("status"));
                userinfo.setCreatedAt(resultset.getString("createdAt"));
            }
            resultset.close();
        } catch (Exception e) {
            log.writeEvent("Error in getUserInfo : " + e.toString());
        }
        return userinfo;
    }

    public boolean insertNewRol(String rolname, String description) {
        boolean insertFlage = false;
        String[] returnId = {"id"};
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO rols ( id, name,description) VALUES ( default , ? , ?)", returnId);

            statement.setString(1, rolname);
            statement.setString(2, description);

            if (statement.executeUpdate() > 0) {

                insertFlage = true;
            }
        } catch (Exception ex) {
            log.writeEvent("Error in insertNewRol :" + ex.toString());
        }
        return insertFlage;
    }

    public boolean UpdateRolInfo(String newRolName, int rolId) {
        boolean flag = false;
        try {
            PreparedStatement statement = connection.prepareStatement("UPDATE rols SET name= ?  WHERE id = ? ;");
            statement.setString(1, newRolName);
            statement.setInt(2, rolId);
            if (statement.executeUpdate() > 0) {
                flag = true;
            }
        } catch (Exception e) {
            log.writeEvent("Error in UpdateRolInfo : " + e.toString());
        }
        return flag;
    }

    public boolean DeleteRol(int rolId) {
        boolean flag = false;
        try {
            PreparedStatement statement = connection.prepareStatement("Delete from rols  WHERE id = ? ; ");
            statement.setInt(1, rolId);
            if (statement.executeUpdate() > 0) {
                flag = true;
            }
        } catch (Exception e) {
            log.writeEvent("Error in DeleteRol : " + e.toString());
        }
        return flag;
    }
}
