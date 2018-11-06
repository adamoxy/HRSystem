package adamoxy.database;

import adamoxy.common.Config;
import adamoxy.common.log;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import adamoxy.setget.UsersInfo;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author adam
 */
public class UsersDataSource extends WamyConnection {

    public UsersInfo CheckUserLogin(String username, String password) {
        ResultSet resultset;
        UsersInfo userinfo = new UsersInfo();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM users where username =? OR email=? and password =? ");
            statement.setString(1, username);
            statement.setString(2, username);//case he tried to use his/her email
            statement.setString(3, Config.getMD5(password));//Config.getMD5(userInfo.getPassword())
            resultset = statement.executeQuery();
            if (resultset.next()) {
                userinfo.setId(Integer.parseInt(resultset.getString("id")));
                userinfo.setUsername(resultset.getString("username"));
                userinfo.setEmail(resultset.getString("email"));
                userinfo.setPassword(resultset.getString("password"));
                userinfo.setRolid(resultset.getInt("rolid"));
                userinfo.setStatus(resultset.getString("status"));
                userinfo.setCreatedAt(resultset.getString("createdAt"));
            }

            resultset.close();
        } catch (Exception e) {
            log.writeEvent("Error in CheckUserLogin : " + e.toString());
        }
        return userinfo;
    }

    public ArrayList<UsersInfo> getAllUsersData() {
        ArrayList<UsersInfo> res = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM users");
            ResultSet resultset = statement.executeQuery();
            while (resultset.next()) {
                UsersInfo userinfo = new UsersInfo();
                userinfo.setId(resultset.getInt("id"));
                userinfo.setUsername(resultset.getString("username"));
                userinfo.setEmail(resultset.getString("email"));
                userinfo.setPassword(resultset.getString("password"));
                userinfo.setRolid(resultset.getInt("rolid"));
                userinfo.setStatus(resultset.getString("status"));
                userinfo.setCreatedAt(resultset.getString("createdAt"));
                res.add(userinfo);
            }
        } catch (SQLException e) {
            log.writeEvent("Error in getAllUsersData : " + e.toString());
        } catch (Exception ex) {
            log.writeEvent("Error in getAllUsersData : " + ex.toString());
        }

        return res;
    }

    public UsersInfo getUserInfo(int id) {
        ResultSet resultset;
        UsersInfo userinfo = new UsersInfo();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM users where id= ? ");
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

    public boolean inserUser(UsersInfo userInfo) {
        boolean insertFlage = false;
        userInfo.setPassword(Config.getMD5(userInfo.getPassword()));
        try {
            try (PreparedStatement statement = connection.prepareStatement("INSERT INTO users (id, username, email, password, rolid, status,createdAt ) VALUES ( default,?, ?, ?, ?, ? , ?)")) {
                statement.setString(1, userInfo.getUsername());
                statement.setString(2, userInfo.getEmail());
                statement.setString(3, userInfo.getPassword());
                statement.setInt(4, userInfo.getRolid());
                statement.setString(5, userInfo.getStatus());
                statement.setString(6, userInfo.getCreatedAt() );
                if (statement.executeUpdate() > 0) {
                    insertFlage = true;
                }
            }
        } catch (Exception ex) {
            log.writeEvent("\tError in UserDataSource --> inserUser: " + ex.toString());
        }
        return insertFlage;
    }

    public boolean UpdateUserInfo(UsersInfo userInfo) {
        boolean updateflag = false;
        try {
            PreparedStatement statement = connection.prepareStatement("UPDATE users SET username= ? , email = ? , rolid = ? , status = ? , createdAt = ? WHERE id = ? ;");
            statement.setString(1, userInfo.getUsername());
            statement.setString(2, userInfo.getEmail());
            statement.setInt(3, userInfo.getRolid());
            statement.setString(4, userInfo.getStatus());
            statement.setString(5, userInfo.getCreatedAt());
            statement.setInt(6, userInfo.getId());
            if (statement.executeUpdate() > 0) {
                updateflag = true;
            }
        } catch (SQLException e) {
            log.writeEvent("Error in UpdateUserInfo : " + e.toString());
        } catch (Exception ex) {
            log.writeEvent("Error in getAllUsersData : " + ex.toString());
        }
        return updateflag;
    }

    public boolean UpdateUserPassword(String id, String newPass) {
        boolean flag = true;
        String upate = "UPDATE users SET password =  ? where id = ? ";
        try {
            PreparedStatement statment = connection.prepareStatement(upate);
            statment.setString(1, Config.getMD5(newPass));
            statment.setString(2, id);
            if (statment.executeUpdate() > 0) {
                flag = true;
            }

        } catch (SQLException e) {
            log.writeEvent("error in UpdateUserPassword ." + e.toString());
        } catch (Exception ex) {
            log.writeEvent("error in UpdateUserPassword ." + ex.toString());
        }
        return flag;
    }
}
