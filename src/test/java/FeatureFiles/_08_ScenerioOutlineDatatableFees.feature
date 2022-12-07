#Senaryo :
#  Daha önceki Create a Fee, delete Fee Senaryosunu
#  name, code, intCode ve priority için 5 farklı kombinasyon için çalıştırınız.

Feature: Fee Functionality (DataTable - Scenario Outline)
  Background:
    Given Navigate to Campus
    When Enter username and password and click Login Button
    Then User should login successfully

  Scenario Outline: Fee Functionality
    And Click on the element in left nav

      | setupOne   |
      | parameters |
      | feesSetup  |

    And Click on the element in Dialog
      | addButton |

    And User sending the keys in Dialog content
      | nameInput       | <name>     |
      | codeInput       | <code>     |
      | integrationCode | <intCode>  |
      | priorityCode    | <priority> |

    And Click on the element in Dialog
      | toggleBar  |
      | saveButton |

    And Success message should be displayed

    And User delete item from Dialog
      | <name> |

    Then Success message should be displayed
    Examples:
      | name       | code    | intCode    | priority |
      | brokolyfee | 2222222 | paypal1    | 9421     |
      | brokolyfee | 2121212 | applePay1  | 9651     |
      | brokolyfee | 2252252 | googlePay1 | 9531     |
