package io.saleor.demo.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static io.saleor.demo.ui.CartPage.*;

public class ProductWas implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {
        if (!actor.recall("chosen_subcategory").equals("Alcohol")) {
            actor.attemptsTo(
                    WaitUntil.the(PRODUCT_NAME_ON_CART, isVisible()).forNoMoreThan(30).seconds(),
                    Ensure.that(PRODUCT_NAME_ON_CART).hasText(actor.recall("productName")),
                    Ensure.that(PRODUCT_PRICE_ON_CART).hasText(actor.recall("price")),
                    Ensure.that(PRODUCT_SIZE_ON_CART).hasText(actor.recall("sizeType") + ": " + actor.recall("size"))
            );
        } else {
            actor.attemptsTo(
                    WaitUntil.the(PRODUCT_NAME_ON_CART, isVisible()).forNoMoreThan(30).seconds(),
                    Ensure.that(PRODUCT_NAME_ON_CART).hasText(actor.recall("productName")),
                    Ensure.that(PRODUCT_PRICE_ON_CART).hasText(actor.recall("price"))
            );
        }

        return true;
    }

    public static ProductWas Added() {
        return new ProductWas();
    }
}
