package io.saleor.demo.ui;

import net.serenitybdd.screenplay.targets.Target;

public class CartPage {

    public static final Target PRODUCT_NAME_ON_CART = Target.the("Name of product on cart").locatedBy("[data-test='cartOverlay'] [data-test='itemName']");
    public static final Target PRODUCT_PRICE_ON_CART = Target.the("Price of product on cart").locatedBy("[data-test='cartOverlay'] [data-test='unitPrice']>span");
    public static final Target PRODUCT_SIZE_ON_CART = Target.the("Size of product on cart").locatedBy("[data-test='cartOverlay'] [data-test='itemSingleAttribute']");
}
