package util;

import pojo.User;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Users {
    public static List<User> getUsers() {
        List<User> list = new ArrayList<>();
        try {
            InputStream is = new FileInputStream("src/user.txt");
            Scanner scanner = new Scanner(is);
            while (scanner.hasNextLine()) {
                User user = new User();
                String user1 = scanner.nextLine();
                String[] s = user1.split(" ");
                user.setUsername(s[0]);
                user.setPassword(s[1]);
                list.add(user);
            }
            return list;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

}
