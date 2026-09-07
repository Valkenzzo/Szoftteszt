function calculateShippingCost(orderValue, weight, country, express) {
  if (orderValue < 0 || weight < 0) {
    throw new Error("Order value and weight must be non-negative.");
  }

  country = country.toUpperCase();

  // Free shipping in Hungary for orders above 20,000 HUF
  if (country === "HU" && orderValue > 20000) {
    return 0;
  }

  let shippingCost = 0;
  // Base shipping cost by weight
  if (weight < 5) {
    shippingCost = 1500;
  } else if (weight >= 5 && weight <= 20) {
    shippingCost = 2500;
  } else {
    shippingCost = 5000;
  }
  // International shipping
  if (country !== "HU") {
    shippingCost = shippingCost * 2;
  }
  // Express delivery surcharge
  if (express === true) {
    shippingCost = shippingCost * 1.5;
  }

  return shippingCost;
}



