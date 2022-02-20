#language:en
Feature: Cart Operations

  Scenario Outline: Add a product
    Given that "user" has opened the ecommerce
    When he select the product from the section
      | category        | subcategory        | product        |
      | <user_category> | <user_subcategory> | <user_product> |
    And he adds the product to the cart with
      | sizeType   | size   | quantity   | discount   |
      | <sizeType> | <size> | <quantity> | <discount> |
    Then he should see the added product in the cart

    Examples:
      | user_category | user_subcategory | user_product             | sizeType    | size | quantity | discount |
      | Accessories   | Paints           | Light Speed Yellow Paint | Bucket Size | 2.5l | 4        | yes      |
      | Groceries     | Juices           | Apple Juice              | Bottle Size | 2l   | 1        | no       |
      | Groceries     | Alcohol          | Red Wine                 |             |      | 8        | yes      |