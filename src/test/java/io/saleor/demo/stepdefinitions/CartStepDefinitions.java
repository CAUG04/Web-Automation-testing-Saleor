package io.saleor.demo.stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.saleor.demo.questions.ProductWas;
import io.saleor.demo.tasks.Add;
import io.saleor.demo.tasks.GoTo;
import io.saleor.demo.tasks.Select;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.*;

public class CartStepDefinitions {

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("that {string} has opened the ecommerce")
    public void givenThatUserHasOpenedTheEcommerce(String actorName) {
        theActorCalled(actorName).wasAbleTo(GoTo.theUrl());
    }

    @When("he select the product from the section")
    public void whenHeSelectTheProductFromTheSection(DataTable data) {
        theActorInTheSpotlight().attemptsTo(Select.theProductWithThe(data));
    }

    @And("he adds the product to the cart with")
    public void andHeAddsTheProductToTheCartWith(DataTable data) {
        theActorInTheSpotlight().attemptsTo(Add.theProductWithThe(data));
    }

    @Then("he should see the added product in the cart")
    public void thenHeShouldSeeTheAddedProductInTheCart() {
        theActorInTheSpotlight().should(seeThat(ProductWas.Added()));
    }
}