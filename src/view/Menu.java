package view;

public class Menu {
    public static void loginOrRegister(){
        System.out.println("1、登录");
        System.out.println("2、注册");
    }
    public static void show() {
        System.out.println("欢迎使用学生成绩管理系统（请输入功能对应的数字选项）");
        System.out.println("1、排名(总分)");
        System.out.println("2、平均成绩");
        System.out.println("3、不及格率");
        System.out.println("4、及格率");
        System.out.println("5、优良中所占比率");
        System.out.println("6、添加学生信息");
    }
}
