function calculateParkingFee(minutes, isWeekend, isVip) {
    
    if(minutes < 0) {
        throw new Error("Minutes must be non-negative.");
    }
    
    
    if (minutes <= 15) {
        return 0;
    }

    minutesLeft = minutes - 15;

    let hours = Math.ceil(minutesLeft / 60);
    let fee = hours * 600;

    if (isWeekend) {
        fee = fee * 0.5;
    }

    if (isVip) {
        fee = fee * 0.8;
    }

    if (fee > 5000) {
        fee = 5000;
    }

    return fee;
}

