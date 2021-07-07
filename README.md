# Cucumber Rest-Assured
This project is built with Cucumber, Rest-Assured, Junit. Also used WireMock


## Executing the tests
```
sh cd <project/path>
mvn clean verify

Run with options
mvn clean verify -Dcucumber.filter.tags="@Basket"
```

- Run options
    - *Cucumber Filter*
    -         -Dcucumber.filter.tags="@Basket"
    -         -Dcucumber.filter.tags="@Basket or @SmokeTest"
***

## Reporting
- Reports
    -         Report ui :ProjectFolder/target/generated-report/index.html
***

## Tools
- Rest-Assured
- Cucumber BDD
- Junit
- WireMock
- Jackson-Databind
***