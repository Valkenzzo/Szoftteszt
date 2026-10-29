# Arab számok átváltása római számokra

A program az 1 és 3999 közötti egész számokat írja át római számokra. Próbáld ki például az 1994-et vagy a 3999-et! Ha a bemenet nem szám, `TypeError` hibát kapsz; ha szám, de nem egész vagy kívül esik az elfogadott tartományon, `RangeError` jelzi a problémát.

## A program kipróbálása

Nyisd meg a `test.html` fájlt a böngésződben. Ha magát az átalakítót is kipróbálnád, nyisd meg a fejlesztői konzolt, és hívd meg így:

```js
arabicToRomanConverter(1994)
```

Az eredmény `"MCMXCIV"` lesz. Ezt is kipróbálhatod:

```js
arabicToRomanConverter(3999)
```

## Tesztelés

A `test.html` megnyitásakor a QUnit automatikusan lefuttatja a `test.js` fájlban szereplő teszteket. Az eredményeket ugyanazon az oldalon látod.

A QUnit a `code.jquery.com` címről töltődik be, ezért a tesztek futtatásához internetkapcsolat szükséges.
