package AllShop;

import AllMom.MomButton;

public class ShowStatus {

    // show store button info
    public static void showInfo(MomButton shop) {
        System.out.println("[IMG Path] : " + shop.getNamePath());
    }

    // show shop status info
    public static void showShopStatus(ShopStatus status) {
        System.out.println("[Shop Info] : " + status.getStatus());
    }
}
