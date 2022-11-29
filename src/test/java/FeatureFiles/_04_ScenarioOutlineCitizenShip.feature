  #Senaryo
  #CitizenShip sayfasina gidiniz
  #Create islemini dogrulayiniz
  #Daha sonra ayni bilgilerle tekrar create yapilamadigini dogrulayiniz
  #Parameter yontemi ile yapiniz



  Feature: CitizenShip

    Background:
      Given Navigate to Campus
      When Enter username and password and click Login Button
      Then User should login successfully
      And Navigate to CitizenShip page

      Scenario: CitizenShip Create
        When User a CitizenShip name as "brokoly1" short name as "brk1"
        Then Success message should be displayed

        When User a CitizenShip name as "brokoly1" short name as "brk1"
        Then Already exist message should be displayed
