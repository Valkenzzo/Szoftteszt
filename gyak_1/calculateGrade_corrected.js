function calculateGrade(theory, practice) {

    if (theory < 0 || practice < 0 || theory > 60 || practice > 40) {
        throw new Error("Invalid input: theory must be between 0 and 60, practice must be between 0 and 40.");
    }
    if (theory < 30 || practice < 20) {
        return 1;
    }

    let total = theory + practice;


    if (total < 50) {
        return 1;
    } else if (total < 60) {
        return 2;
    } else if (total < 70) {
        return 3;
    } else if (total < 85) {
        return 4;
    } else {
        return 5;
    }
}