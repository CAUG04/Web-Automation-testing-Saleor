package io.saleor.demo.ui;

import net.serenitybdd.screenplay.targets.Target;

public class ProductDetailsPage {

    public static final Target SIZE_TYPE = Target.the("Type of size").locatedBy("//label[.='{0}']/preceding::input");
    public static final Target SIZE = Target.the("Value of size").locatedBy("//div[.='{0}' and @data-test='attributeOption']");
    public static final Target QUANTITY = Target.the("Quantity").locatedBy("[name='quantity']");
    public static final Target ADD_BUTTON = Target.the("Add Button").locatedBy("[data-test='addProductToCartButton']");
    public static final Target PRICE = Target.the("Price without discount").locatedBy(".product-page__product__info--fixed h4 span:nth-child(1)");
    public static final Target PRICE_WITH_DISCOUNT = Target.the("Price without discount").locatedBy(".product-page__product__info--fixed h4 span:nth-child(2)");
}
