package io.saleor.demo.ui;

import net.serenitybdd.screenplay.targets.Target;

public class ProductListPage {

    public static final Target PRODUCT = Target.the("Label Product").locatedBy("//*[@data-test ='productTile' and .='{0}']");
 }