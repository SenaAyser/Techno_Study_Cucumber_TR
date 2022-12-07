#Senaryo :
#  Exam Formunun Çalışmasını test ediniz
#  1 sınav girişi yapıp
#  sonrasında silmesini yapınız

Feature: Exam Functionality

  Background:
    Given Navigate to Campus
    When Enter username and password and click Login Button
    Then User should login successfully

  Scenario: Create and Delete Exam
    And Click on the element in left nav
      | entranceExamsOne |
      | setupTwo         |
      | entranceExamsTwo |

    And Click on the element in Dialog
      | addButton |

    And User sending the keys in Dialog content
      | nameInput | brokoli2 |

    And Click on the element in the Form Content
      | academicPeriod  |
      | academicPeriod1 |
      | gradeLevel      |
      | gradeLevel2     |

    And Click on the element in Dialog
      | saveButton |

    Then Success message should be displayed

    And Click on the element in left nav
      | entranceExamsOne |
      | setupTwo         |
      | entranceExamsTwo |

    And User delete item from Dialog
      | brokoli2 |

    Then Success message should be displayed