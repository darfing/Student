package service;

import pojo.Student;

import java.io.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

public class Options {

    public static List<Student> sort(List<Student> list) {
        if(list == null) {
            return null;
        }
        int sum;
        int tempSum;
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = i + 1; j < list.size(); j++) {
                Student student = list.get(i);
                sum = student.getChineseScore() + student.getMathScore();
                Student tempStudent = list.get(j);
                tempSum = tempStudent.getChineseScore() + tempStudent.getMathScore();
                if (tempSum > sum) {
                    list.set(i, tempStudent);
                    list.set(j, student);
                }
            }
            list.get(i).setOrder(i + 1);
            System.out.println(list.get(i));
        }
        list.get(list.size() - 1).setOrder(list.size());
        System.out.println(list.get(list.size() - 1));
        try {
            OutputStream os = new FileOutputStream("src/sort.txt");
            PrintStream ps = new PrintStream(os);
            for (Student student : list) {
                String s = student.getOrder() + " " + student.getNumber() + " " + student.getName() + " " + student.getMathScore() + " " + student.getChineseScore();
                ps.println(s);
            }
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public static double[] average(List<Student> list) {

    	 int mathSum = 0; 
    	 double mathAvg = 0;
    	 int chineseSum = 0;
    	 double chineseAvg = 0;
		 for (Student student : list) { 
			 mathSum += student.getMathScore(); 
		 } 
		 mathAvg = 1.0 *mathSum / list.size(); 
		 for (Student student : list) { 
			 chineseSum += student.getChineseScore(); 
		 } 
		 chineseAvg = 1.0 * chineseSum / list.size();
        mathAvg = new BigDecimal(mathAvg).setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();
        chineseAvg = new BigDecimal(chineseAvg).setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();
		 double[] avg = {mathAvg, chineseAvg};
		 return avg;
    }

    public static double[] passRate(List<Student> list) {
        int mathPass = 0;
        int chinesePass = 0;
        double mathPassRate;
        double chinesePassRate;
        for (Student student : list) {
            if (student.getMathScore() >= 60) {
                mathPass += 1;
            }

        } 
        for (Student student : list) {
            if (student.getChineseScore() >= 60) {
               chinesePass += 1;
            }
        }
        mathPassRate = 1.0 * mathPass / list.size();
        chinesePassRate = 1.0 * chinesePass / list.size();
        mathPassRate = new BigDecimal(mathPassRate).setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();
        chinesePassRate = new BigDecimal(chinesePassRate).setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();
        return new double[] {mathPassRate, chinesePassRate};
    }


    public static double[] YLZRate(List<Student> list) {
        if(list == null) {
            return null;
        }
        int length = list.size();
        int mathExcellent = 0;
        int mathWell = 0;
        int mathMid = 0;
        int chineseExcellent = 0;
        int chineseWell = 0;
        int chineseMid = 0;
        double mathExcellentRate;
        double mathWellRate;
        double mathMidRate;
        double chineseExcellentRate;
        double chineseWellRate;
        double chineseMidRate;
            for (Student student : list) {
                if (student.getMathScore() >= 90) {
                    mathExcellent += 1;
                } else if (student.getMathScore() >= 80) {
                    mathWell += 1;
                } else if (student.getMathScore() >= 70) {
                    mathMid += 1;
                }
            }

            for (Student student : list) {
                if (student.getChineseScore() >= 90) {
                    chineseExcellent += 1;
                } else if (student.getChineseScore() >= 80) {
                    chineseWell += 1;
                } else if (student.getChineseScore() >= 70) {
                    chineseMid += 1;
                } 
            }
        mathExcellentRate = 1.0 * mathExcellent / length;
        mathWellRate = 1.0 * mathWell / length;
        mathMidRate = 1.0 * mathMid / length;
        chineseExcellentRate = 1.0 * chineseExcellent / length;
        chineseWellRate = 1.0 * chineseWell / length;
        chineseMidRate = 1.0 * chineseMid / length;
        mathExcellentRate = new BigDecimal(mathExcellentRate).setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();
        mathWellRate = new BigDecimal(mathWellRate).setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();
        mathMidRate = new BigDecimal(mathMidRate).setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();
        chineseExcellentRate = new BigDecimal(chineseExcellentRate).setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();
        chineseWellRate = new BigDecimal(chineseWellRate).setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();
        chineseMidRate = new BigDecimal(chineseMidRate).setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();
        return new double[] {mathExcellentRate, mathMidRate, mathWellRate, chineseExcellentRate, chineseMidRate, chineseWellRate};
    }

    public static int add() {
        Scanner scanner = new Scanner(System.in);
        String num = null;
        while (true) {
            System.out.println("请输入学生学号:");
            num = scanner.nextLine();
            if(num.contains(" ")) {
                System.out.println("不能含有空格");
                continue;
            }
            break;
        }
        String name = null;
        while (true) {
            System.out.println("请输入学生姓名:");
            name = scanner.nextLine();
            if(name.contains(" ")) {
                System.out.println("不能含有空格");
                continue;
            }
            break;
        }
        int mathScore = 0;
        while (true) {
            System.out.println("请输入学生数学成绩（整数）:");
            mathScore = Integer.parseInt(scanner.nextLine());
            if(checkScore(mathScore)) {
                System.out.println("分数不能大于100或负数");
                continue;
            }
            break;
        }
        int chineseScore = 0;
        while (true) {
            System.out.println("请输入学生数语文成绩（整数）:");
            chineseScore = Integer.parseInt(scanner.nextLine());
            if(checkScore(chineseScore)) {
                System.out.println("分数不能大于100或负数");
                continue;
            }
            break;
        }
        try {
            PrintStream ps = new PrintStream(new FileOutputStream("src/student.txt", true));
            String s = num + " " + name + " " + mathScore + " " + chineseScore;
            ps.println(s);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
    
    public static boolean update(List<Student> list) {
    	try {
            OutputStream os = new FileOutputStream("src/student.txt");
            PrintStream ps = new PrintStream(os);
            for (Student student : list) {
                String s = student.getNumber() + " " + student.getName() + " " + student.getMathScore() + " " + student.getChineseScore();
                ps.println(s);
            }
            ps.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
    	return false;
    }

    public static boolean checkScore(int score) {
        return score < 0 || score > 100;
    }
    
}
