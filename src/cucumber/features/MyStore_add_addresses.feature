Feature: Add new address to MyStore

  Scenario Outline: Add new address to MyStore
    Given Open browser on https://mystore-testlab.coderslab.pl/index.php site
    When Signs in edprfaloqmyoomqaeb@kvhrw.com Azrael01 for address
    And Add first address
    And Fulfill address form with <alias> <address> <postal> <city> <phone>
    And Save
    Then Check address successfully added
    And Check address contain <alias> <address> <postal> <city> <phone>
    Then Delete address
    And Check address successfully deleted


    Examples:
      | alias      | address           | postal  | city       | phone         |
      | London     | Downing           | SW1A2AA | London     | +447764729635 |
      | Manchester | King              | M24WU   | Manchester | +447529188234 |
      | Leeds      | Calverley         | LS13DA  | Leeds      | +447883196637 |
      | Bognor     | Hook              | PO228AR | Bognor     | +447883200468 |
      | Liverpool  | Tithebarn         | L22DP   | Liverpool  | +447883269920 |