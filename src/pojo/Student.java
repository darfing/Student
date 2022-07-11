package pojo;

public class Student {
    private String number;
    private String name;
    private int mathScore;
    private int ChineseScore;
    private int order;

    public Student() {
    }

    public Student(String number, String name, int mathScore, int chineseScore, int order) {
        this.number = number;
        this.name = name;
        this.mathScore = mathScore;
        ChineseScore = chineseScore;
        this.order = order;
    }

    @Override
    public String toString() {
        return "Student{" +
                "number='" + number + '\'' +
                ", name='" + name + '\'' +
                ", mathScore=" + mathScore +
                ", ChineseScore=" + ChineseScore +
                ", order=" + order +
                '}';
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMathScore() {
        return mathScore;
    }

    public void setMathScore(int mathScore) {
        this.mathScore = mathScore;
    }

    public int getChineseScore() {
        return ChineseScore;
    }

    public void setChineseScore(int chineseScore) {
        ChineseScore = chineseScore;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }
}
