package pojo;


public class Person {
    String sName;
    private String sNumber;

    public Person(String sName, String sNumber) {
        this.sName = sName;
        this.sNumber = sNumber;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public String getsNumber() {
        return sNumber;
    }

    public void setsNumber(String sNumber) {
        this.sNumber = sNumber;
    }
}
class PersonTest {
    public static void main(String[] args) {
        Person[] person = new Person[5];
        for (Person value : person) {
            System.out.println(value);
        }


    }
}
