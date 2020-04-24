Feature: Hello

  @test
    @excel=C:\Users\Manjunath-PC\Desktop=book.xlsx=Sheet1
  Scenario Outline: test

    Given  Test Given
    When  Test When "<SOME DATA>"
    Examples:
      | SOME DATA |
      | DATA      |