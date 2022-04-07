Feature: Complete order as login user

  Scenario Outline: Complete order as login user
    Given Open browser on https://mystore-testlab.coderslab.pl/index.php page
    When Signs in edprfaloqmyoomqaeb@kvhrw.com Azrael01 for order
    And Choose a product
    And Select size <size>
    And Select quantity <quantity>
    And Add product to cart
    And Checkout
    And Confirm address
    And Choose pickup method
    And Choose payment option
    And Agree to the terms
    And Complete order


    Examples:
    |size         |quantity         |
    |S            |5                |
    |M            |1                |
    |L            |2                |
    |XL           |3                |