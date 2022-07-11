package service;

import pojo.User;
import util.Users;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.Scanner;

public class Register {
    private static List<User> list;

    public static void register() {
        String username;
        String password;
        list = Users.getUsers();

        try {
            Scanner scanner = new Scanner(System.in);
            OutputStream os = new FileOutputStream("src/user.txt", true);
            PrintStream ps = new PrintStream(os);
            boolean flag = false;
            while (true) {
                System.out.println("请输入用户名:");
                username = scanner.nextLine();
                for (User user : list) {
                    if (username.equals(user.getUsername())) {
                        flag = true;
                    }
                }
                if (flag) {
                    System.out.println("用户名已存在，请重新输入");
                    flag = false;
                    continue;
                }
                break;
            }
            System.out.println("请输入密码:");
            password = scanner.nextLine();
            String s = username + " " + password;
            ps.println(s);
            System.out.println("注册成功");
        } catch (FileNotFoundException e) {
            System.out.println("注册失败");
        }
    }

}
