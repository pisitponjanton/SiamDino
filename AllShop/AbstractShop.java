// AbstractShop.java
package AllShop;

public abstract class AbstractShop {
    public abstract void startThread();
    public abstract void stopThread();
    public abstract String getShopName();
    public abstract void setMoney(int money);
    public abstract int getMoney();
    public abstract void setLevel(int level);
    public abstract int getLevel();
    public abstract void reMoney();
}