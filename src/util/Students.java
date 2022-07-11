package util;

import pojo.Student;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Students {
    public static List<Student> getStudents() {
        List<Student> list = new ArrayList<>();

        try {
            InputStream is = new FileInputStream("src/student.txt");
            Scanner scanner = new Scanner(is);
            while (scanner.hasNextLine()) {
                Student student = new Student();
                String student1 = scanner.nextLine();
                String[] s = student1.split(" ");
                student.setNumber(s[0]);
                student.setName(s[1]);
                student.setMathScore(Integer.parseInt(s[2]));
                student.setChineseScore(Integer.parseInt(s[3]));
                list.add(student);
            }
            return list;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
