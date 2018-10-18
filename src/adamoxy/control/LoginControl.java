package adamoxy.control;

import adamoxy.setget.UsersInfo;
import adamoxy.common.log;
import java.util.ArrayList;
import adamoxy.database.*;

/**
 *
 * @author adam
 */
public class LoginControl {

    public static UsersInfo CheckLogin(String username, String password) {

        UsersDataSource data = new UsersDataSource();
        UsersInfo info = null;
        try {
            info = data.CheckUserLogin(username, password);
            data.close();

        } catch (Exception e) {
            log.writeEvent(e.toString());
        }
        return info;
    }

    public static boolean UpdateUserInfo(UsersInfo usersInfo) {
        UsersDataSource data = new UsersDataSource();
        boolean res = false;
        try {
            res = data.UpdateUserInfo(usersInfo);
            data.close();

        } catch (Exception e) {
            log.writeEvent(e.toString());
        }
        return res;
    }

    public static boolean UpdateUserPass(String id, String newPass) {
        UsersDataSource data = new UsersDataSource();
        boolean res = false;
        try {
            res = data.UpdateUserPassword(id, newPass);
            data.close();

        } catch (Exception e) {
            log.writeEvent(e.toString());
        }
        return res;
    }

    public static ArrayList<UsersInfo> getAllUsersData() {
        UsersDataSource data = new UsersDataSource();
        ArrayList<UsersInfo> res = null;
        try {
            res = data.getAllUsersData();
            data.close();

        } catch (Exception e) {
            log.writeEvent(e.toString());
        }
        return res;
    }

    public static UsersInfo GetUserInfo(int id) {
        UsersDataSource data = new UsersDataSource();
        UsersInfo info = null;
        try {
            info = data.getUserInfo(id);

            data.close();

        } catch (Exception e) {
            log.writeEvent(e.toString());
        }
        return info;
    }

    public static boolean inserUser(UsersInfo usersInfo) {
        boolean flage = false;
        UsersDataSource data = new UsersDataSource();
        try {
            flage = data.inserUser(usersInfo);
        } catch (Exception e) {
            log.writeEvent(e.toString());
        }
        data.close();
        return flage;
    }
}
