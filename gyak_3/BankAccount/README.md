# BankAccount

Egyszerű bankszámla Java nyelven. Az új számla egyenlege 0; a `deposit()` befizet, a `withdraw()` pénzt vesz fel, a `getBalance()` pedig lekérdezi az aktuális egyenleget. A nulla vagy negatív összeg, a nem véges összeg, illetve az egyenleget meghaladó pénzfelvétel `IllegalArgumentException` kivételt dob. A sikertelen műveletek nem módosítják az egyenleget.

## Követelmények

- JDK 21 vagy újabb
- Apache Maven

## Tesztek futtatása

A projekt mappájában futtasd:

```shell
mvn test
```

Ez lefordítja a kódot, lefuttatja a JUnit 5 teszteket, és a konzolon összegzi az eredményeket.

## Fordítás és csomagolás

```shell
mvn package
```

A Maven a lefordított osztályokat a `target/classes`, a teszteredményeket pedig a `target/surefire-reports` mappába teszi.
