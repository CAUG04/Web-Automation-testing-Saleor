package io.saleor.demo.tasks;

import io.cucumber.datatable.DataTable;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.MoveMouse;

import java.util.List;
import java.util.Map;

import static io.saleor.demo.ui.HomePage.CATEGORY;
import static io.saleor.demo.ui.HomePage.SUBCATEGORY;
import static io.saleor.demo.ui.ProductListPage.PRODUCT;

public class Select implements Task {

    private DataTable data;

    public Select(DataTable data) {
        this.data = data;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        List<Map<String, String>> values = data.asMaps(String.class, String.class);
        actor.attemptsTo(
                MoveMouse.to(CATEGORY.of(String.valueOf(values.get(0).get("category"))).resolveFor(actor)),
                Click.on(SUBCATEGORY.of(String.valueOf(values.get(0).get("subcategory"))).resolveFor(actor)),
                Click.on(PRODUCT.of(String.valueOf(values.get(0).get("product"))).resolveFor(actor))
        );

        actor.remember("chosen_subcategory", values.get(0).get("subcategory"));
        actor.remember("productName", values.get(0).get("product").toUpperCase());
    }

    public static Select theProductWithThe(DataTable data) {
        return Tasks.instrumented(Select.class, data);
    }
}