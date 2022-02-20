package io.saleor.demo.ui;

import net.serenitybdd.screenplay.targets.Target;

public class HomePage {

    public static final Target CATEGORY = Target.the("Label Category").locatedBy("//*[@id='header']//a[.='{0}']");
    public static final Target SUBCATEGORY = Target.the("Label SubCategory").locatedBy("//*[@id='header']//a[.='{0}']");
}