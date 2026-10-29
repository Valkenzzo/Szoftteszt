QUnit.module("Arab számok római számokká alakítása");

QUnit.test("Alakítja az alapértékeket és a megadott példákat", function (assert) {
  assert.strictEqual(arabicToRomanConverter(1), "I");
  assert.strictEqual(arabicToRomanConverter(4), "IV");
  assert.strictEqual(arabicToRomanConverter(9), "IX");
  assert.strictEqual(arabicToRomanConverter(14), "XIV");
  assert.strictEqual(arabicToRomanConverter(58), "LVIII");
  assert.strictEqual(arabicToRomanConverter(1994), "MCMXCIV");
  assert.strictEqual(arabicToRomanConverter(3999), "MMMCMXCIX");

  [
    [5, "V"],
    [10, "X"],
    [50, "L"],
    [100, "C"],
    [500, "D"],
    [1000, "M"],
    [11, "XI"],
    [52, "LII"],
    [103, "CIII"],
    [504, "DIV"],
    [1504, "MDIV"],
    [15, "XV"],
    [55, "LV"],
    [105, "CV"],
    [505, "DV"],
    [1005, "MV"],
    [16, "XVI"],
    [57, "LVII"],
    [108, "CVIII"],
    [509, "DIX"],
    [1010, "MX"],
  ].forEach(function ([number, expected]) {
    assert.strictEqual(arabicToRomanConverter(number), expected);
  });
});

QUnit.test("Kezeli a kivonásos jelölés speciális eseteit", function (assert) {
  assert.strictEqual(arabicToRomanConverter(40), "XL");
  assert.strictEqual(arabicToRomanConverter(90), "XC");
  assert.strictEqual(arabicToRomanConverter(400), "CD");
  assert.strictEqual(arabicToRomanConverter(900), "CM");
  assert.strictEqual(arabicToRomanConverter(944), "CMXLIV");
});

QUnit.test("Kezeli az ismétlődő számjeleket", function (assert) {
  assert.strictEqual(arabicToRomanConverter(2), "II");
  assert.strictEqual(arabicToRomanConverter(333), "CCCXXXIII");
  assert.strictEqual(arabicToRomanConverter(3888), "MMMDCCCLXXXVIII");
});

QUnit.test("Kezeli az alsó és felső határértéket", function (assert) {
  assert.strictEqual(arabicToRomanConverter(1), "I");
  assert.strictEqual(arabicToRomanConverter(3999), "MMMCMXCIX");
});

QUnit.test("Elutasítja a megengedett tartományon kívüli és nem egész számokat", function (assert) {
  [0, -1, 4000, 1.5, NaN, Infinity].forEach(function (value) {
    assert.throws(
      function () {
        arabicToRomanConverter(value);
      },
      RangeError,
      String(value) + " esetén RangeError kivételt dob"
    );
  });
});

QUnit.test("Elutasítja a nem szám típusú bemenetet", function (assert) {
  ["1", null, undefined].forEach(function (value) {
    assert.throws(
      function () {
        arabicToRomanConverter(value);
      },
      TypeError,
      String(value) + " esetén TypeError kivételt dob"
    );
  });
});
