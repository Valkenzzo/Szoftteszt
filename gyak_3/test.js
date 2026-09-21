// QUnit tesztek
QUnit.module("Arabic to roman converter függvény tesztelése");


QUnit.test("Az input határkarakterek", function (assert) {
  assert.equal(arabicToRomanConverter(5), "V");
  assert.equal(arabicToRomanConverter(10), "X");
  assert.equal(arabicToRomanConverter(50), "L");
  assert.equal(arabicToRomanConverter(100), "C");
  assert.equal(arabicToRomanConverter(500), "D");
  assert.equal(arabicToRomanConverter(1000), "M");

QUnit.test("Az input végződése 1 és 5 között", function (assert) {
  assert.equal(arabicToRomanConverter(11), "XI");
  assert.equal(arabicToRomanConverter(52), "LII");
  assert.equal(arabicToRomanConverter(103), "CIII");
  assert.equal(arabicToRomanConverter(504), "DIV");
   assert.equal(arabicToRomanConverter(1504), "MDIV");
  
});

QUnit.test("Az input végződése 5-nél", function (assert) {
  assert.equal(arabicToRomanConverter(15), "XV");
  assert.equal(arabicToRomanConverter(55), "LV");
  assert.equal(arabicToRomanConverter(105), "CV");
  assert.equal(arabicToRomanConverter(505), "DV");
  assert.equal(arabicToRomanConverter(1005), "MV");
});

QUnit.test("Az input végződése 6 és 10 között", function (assert) {
  assert.equal(arabicToRomanConverter(16), "XVI");
  assert.equal(arabicToRomanConverter(57), "LVII");
  assert.equal(arabicToRomanConverter(108), "CVIII");
  assert.equal(arabicToRomanConverter(509), "DIX");
  assert.equal(arabicToRomanConverter(1010), "MX");
});

});

function arabicToRomanConverter(n) {
  if (!n || n <= 0) return "";
  const romanNumerals = [
    { value: 1000, symbol: "M" },
    { value: 900, symbol: "CM" },
    { value: 500, symbol: "D" },
    { value: 400, symbol: "CD" },
    { value: 100, symbol: "C" },
    { value: 90, symbol: "XC" },
    { value: 50, symbol: "L" },
    { value: 40, symbol: "XL" },
    { value: 10, symbol: "X" },
    { value: 9, symbol: "IX" },
    { value: 5, symbol: "V" },
    { value: 4, symbol: "IV" },
    { value: 1, symbol: "I" },
  ];
  let result = "";
  for (let i = 0; i < romanNumerals.length; i++) {
    while (n >= romanNumerals[i].value) {
      result += romanNumerals[i].symbol;
      n -= romanNumerals[i].value;
    }
  }
  return result;
}
