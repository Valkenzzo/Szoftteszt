function arabicToRomanConverter(number) {
  if (typeof number !== "number") {
    throw new TypeError("The input must be a number.");
  }
  if (!Number.isInteger(number) || number < 1 || number > 3999) {
    throw new RangeError("The input must be an integer between 1 and 3999.");
  }

  const romanNumerals = [
    [1000, "M"],
    [900, "CM"],
    [500, "D"],
    [400, "CD"],
    [100, "C"],
    [90, "XC"],
    [50, "L"],
    [40, "XL"],
    [10, "X"],
    [9, "IX"],
    [5, "V"],
    [4, "IV"],
    [1, "I"],
  ];

  let remainder = number;
  let result = "";

  for (const [value, symbol] of romanNumerals) {
    while (remainder >= value) {
      result += symbol;
      remainder -= value;
    }
  }

  return result;
}
