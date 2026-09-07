function calculateTicketPrice(age, isStudent, is3D) {
  if (age < 0 || age > 120) {
    throw new Error("Age must be between 0 and 120.");
  }

  let price = 3000;

  if (age < 6) {
    price = 0;
  } else if (age < 18) {
    price *= 0.7;
  } else if (age >= 65) {
    price *= 0.6;
  } else if (isStudent) {
    price *= 0.8;
  }

  if (is3D) {
    price += 800;
  }

  return price;
}
