Feature: Partition
  Create sub list partition from a given List and size

  Scenario: List partitioning by 1
    Given the following list params
      | 1,2,3,4,5 |
    When I call partition service to split the List by a size of 1
    Then I will get the following sub lists
      | 1 |
      | 2 |
      | 3 |
      | 4 |
      | 5 |

  Scenario: List partitioning by 2
    Given the following list params
      | 1,2,3,4,5 |
    When I call partition service to split the List by a size of 2
    Then I will get the following sub lists
      | 1,2 |
      | 3,4 |
      | 5   |

  Scenario: List partitioning by 3
    Given the following list params
      | 1,2,3,4,5 |
    When I call partition service to split the List by a size of 3
    Then I will get the following sub lists
      | 1,2,3 |
      | 4,5   |