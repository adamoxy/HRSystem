package adamoxy.database;

import adamoxy.common.log;
import adamoxy.setget.UserRolInfo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import adamoxy.setget.UsersInfo;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author adam
 */
public class UserRolDataSource extends WamyConnection {

    public UserRolInfo getRolById(String id) {
        UserRolInfo user = new UserRolInfo();
        String sql = " SELECT * FROM rols where id = ? ";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
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
        String sql = "SELECT * FROM rols";
        ArrayList<UserRolInfo> users = new ArrayList<>();
        UserRolInfo userinfo = null;
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
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

    public UsersInfo getAllUsersInRoleInfo(int id) {
        ResultSet resultset;
        UsersInfo userinfo = new UsersInfo();
        String sql = "SELECT * FROM users where rolid= ? ";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
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
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO rols ( id, name,description) VALUES ( default , ? , ?)");
            statement.setString(1, rolname);
            statement.setString(2, description);
            if (statement.executeUpdate() > 0) {
                insertFlage = true;
            }
        } catch (SQLException ex) {
            log.writeEvent("Error in insertNewRol :" + ex.toString());
        } catch (Exception e) {
            log.writeEvent("insertNewRol : " + e.toString());
        }
        return insertFlage;
    }

    public boolean UpdateRolInfo(String newRolName, int rolId) {
        boolean flag = false;
        String sql = "UPDATE rols SET name= ?  WHERE id = ? ";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, newRolName);
            statement.setInt(2, rolId);
            if (statement.executeUpdate() > 0) {
                flag = true;
            }
        } catch (SQLException e) {
            log.writeEvent("Error in UpdateRolInfo : " + e.toString());
        }catch(Exception e){
         log.writeEvent("UpdateRolInfo : "+e.toString());
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
        } catch (SQLException e) {
            log.writeEvent("Error in DeleteRol : " + e.toString());
        }catch(Exception ee){
            log.writeEvent("DeleteRol"+ee.toString());
        }
        return flag;
    }
}
