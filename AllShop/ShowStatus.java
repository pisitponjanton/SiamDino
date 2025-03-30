package AllShop;

import AllMom.MomButton;

public class ShowStatus extends Shop {

    public static void showInfo(MomButton shop) {
        System.out.println("[IMG Path] : " + shop.getNamePath());
    }

    public static void showShopStatus(ShopStatus status) {
        System.out.println("[Shop Info] : " + status.getStatus());
    }
}
