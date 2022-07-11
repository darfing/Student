package service;

import pojo.User;
import util.Users;

import java.util.List;

public class Login {

    public static boolean login(String username, String password) {
        List<User> list = Users.getUsers();
        for (User user : list) {
            if(user.getUsername().equals(username) && user.getPassword().equals(password));
            System.out.println("登陆成功");
            return true;
        }
        System.out.println("登录失败");
        return false;
    }
}
