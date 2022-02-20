package io.saleor.demo.tasks;

import io.cucumber.datatable.DataTable;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import java.util.List;
import java.util.Map;

import static io.saleor.demo.ui.ProductDetailsPage.PRICE;
import static io.saleor.demo.ui.ProductDetailsPage.SIZE;
import static io.saleor.demo.ui.ProductDetailsPage.SIZE_TYPE;
import static io.saleor.demo.ui.ProductDetailsPage.PRICE_WITH_DISCOUNT;
import static io.saleor.demo.ui.ProductDetailsPage.QUANTITY;
import static io.saleor.demo.ui.ProductDetailsPage.ADD_BUTTON;

public class Add implements Task {

    private DataTable data;

    public Add(DataTable data) {
        this.data = data;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        List<Map<String, String>> values = data.asMaps(String.class, String.class);

        if (!actor.recall("chosen_subcategory").equals("Alcohol")) {
            actor.attemptsTo(
                    Click.on(SIZE_TYPE.of(String.valueOf(values.get(0).get("sizeType"))).resolveFor(actor)),
                    Click.on(SIZE.of(String.valueOf(values.get(0).get("size"))).resolveFor(actor))
            );
            actor.remember("sizeType", values.get(0).get("sizeType"));
            actor.remember("size", values.get(0).get("size"));
        }
        actor.attemptsTo(
                Enter.theValue(values.get(0).get("quantity")).into(QUANTITY),
                Click.on(ADD_BUTTON)
        );

        if (values.get(0).get("discount").equals("yes")) {
            actor.remember("price", PRICE_WITH_DISCOUNT.resolveFor(actor).getText());
        } else {
            actor.remember("price", PRICE.resolveFor(actor).getText());
        }
    }

    public static Add theProductWithThe(DataTable data) {
        return Tasks.instrumented(Add.class, data);
    }
}