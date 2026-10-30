# BankService Mockito példa

Ez a Maven-projekt egy egyszerű `BankAccount` osztályt és egy befizetést végző `BankService`-t tartalmaz. Sikeres befizetés után a szolgáltatás a konstruktorban kapott `NotificationService`-en keresztül küld értesítést. Az értesítés mock objektummal van helyettesítve, így a tesztek nem kapcsolódnak valódi külső szolgáltatáshoz.

A projekt az `ExchangeRateService` mockolását is bemutatja: a tesztben a `when(...).thenReturn(...)` segítségével előre megadott árfolyamot állítunk be.

## Követelmények

- JDK 21 vagy újabb
- Apache Maven

## Tesztek futtatása

A `Bank` projektmappájában futtasd:

```shell
mvn clean test
```

A parancs törli az előző build eredményeit, lefordítja a projektet, majd lefuttatja a JUnit 5 teszteket. A Mockito a függőségek mockolására, a `verify()` az értesítés ellenőrzésére, a `when(...).thenReturn(...)` pedig az előre beállított árfolyam visszaadására szolgál.
