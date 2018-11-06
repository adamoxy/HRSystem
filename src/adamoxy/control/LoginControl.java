package adamoxy.control;

import adamoxy.setget.UsersInfo;
import java.util.ArrayList;
import adamoxy.database.*;

/**
 *
 * @author adam
 */
public class LoginControl {

    public static UsersInfo CheckLogin(String username, String password) {

        UsersDataSource obj = new UsersDataSource();
        UsersInfo info = obj.CheckUserLogin(username, password);
        obj.close();
        return info;
    }

    public static boolean UpdateUserInfo(UsersInfo usersInfo) {
        UsersDataSource obj = new UsersDataSource();
        boolean res = obj.UpdateUserInfo(usersInfo);
        obj.close();
        return res;
    }

    public static boolean UpdateUserPass(String id, String newPass) {
        UsersDataSource obj = new UsersDataSource();
        boolean res = obj.UpdateUserPassword(id, newPass);
        obj.close();
        return res;
    }

    public static ArrayList<UsersInfo> getAllUsersData() {
        UsersDataSource obj = new UsersDataSource();
        ArrayList<UsersInfo> res = obj.getAllUsersData();
        obj.close();
        return res;
    }

    public static UsersInfo GetUserInfo(int id) {
        UsersDataSource obj = new UsersDataSource();
        UsersInfo info = obj.getUserInfo(id);
        obj.close();
        return info;
    }

    public static boolean inserUser(UsersInfo usersInfo) {
        UsersDataSource obj = new UsersDataSource();
        boolean flage = obj.inserUser(usersInfo);
        obj.close();
        return flage;
    }
}
