public class Tree {
    public String x = "in tree";
    Tree() {
        System.out.println("I am tree");
    }

    public static void main(String[] args) {
        Tree t = new YingHuaTree("樱花");
        System.out.println(t.x);
        YingHuaTree t1 = new YingHuaTree("樱花");
        System.out.println(t1.x);

    }
}
class YingHuaTree extends Tree {
    public String x;
    public YingHuaTree(String x) {
        super();
        this.x = x;
        System.out.println("I am " + x);
    }
}
