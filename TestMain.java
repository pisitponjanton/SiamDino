import DataBase.*;
public class TestMain {
    public static void main(String[] args) {
        // DataMap b = new DataMap("top");
        // b.setName("ttt");
        // new DataBase(b);
        DataBase b = new DataBase();
        // new DataBase(b.getDataMap());
        System.out.println(b.getDataUser().getName());
    }
}
