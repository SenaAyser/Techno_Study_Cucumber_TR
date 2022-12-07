Feature: Datatable Functionality

  Background:
    Given Navigate to Campus
    When Enter username and password and click Login Button
    Then User should login successfully

  Scenario: Create Country
    And Click on the element in left nav

      | setupOne   |
      | parameters |
      | countries  |

    And Click on the element in Dialog
      | addButton |

    And User sending the keys in Dialog content
      | nameInput | BrkCountry00   |
      | codeInput | brkly123456789 |

    And Click on the element in Dialog
      | saveButton |

    And Success message should be displayed

    And User delete item from Dialog
      | BrkCountry00 |


  Scenario: Create a Nationality
    And Click on the element in left nav
      | setupOne      |
      | parameters    |
      | nationalities |

    And Click on the element in Dialog
      | addButton |

    And User sending the keys in Dialog content
      | nameInput | BrkNat |

    And Click on the element in Dialog
      | saveButton |

    Then Success message should be displayed

    And User delete item from Dialog
      | BrkNat |

    Then Success message should be displayed

    #TODO: Create fee delete fee

  Scenario: Fee Functionality
    And Click on the element in left nav

      | setupOne   |
      | parameters |
      | feesSetup  |

    And Click on the element in Dialog
      | addButton |

    And User sending the keys in Dialog content
      | nameInput       | BrklyFee |
      | codeInput       | 123456     |
      | integrationCode | 1122334455 |
      | priorityCode    | 2615       |

    And Click on the element in Dialog
      | toggleBar  |
      | saveButton |

    And Success message should be displayed

    And User delete item from Dialog
      | BrklyFee |

    Then Success message should be displayed

     #    Senaryo Outline da verilen değerler için tüm senaryo her satır kadar tekrar çalıştırılıyordu.
      #    DataTable da ise, sadece ilgili step için toplu veri gönderme imkanı oluşuyor.


