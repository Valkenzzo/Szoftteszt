package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TableTest {

    private Table tableNotAdjustable;
    private Table tableAdjustable;

    @BeforeEach
    void setUp() {
        tableNotAdjustable = new Table(70, 200, 50);
        tableAdjustable = new Table(70, 200, 50, 50, true);
    }

    // --- setHeight() tesztek ---

    @Test
    void setHeight_shouldNotChangeWhenNotAdjustable() {
        tableNotAdjustable.setHeight(120);
        assertEquals(50, tableNotAdjustable.getHeight());
    }

    @Test
    void setHeight_shouldChangeWhenAdjustable() {
        tableAdjustable.setHeight(120);
        assertEquals(120, tableAdjustable.getHeight());
    }

    @Test
    void setHeight_shouldNotAcceptNegativeValues() {
        tableNotAdjustable.setHeight(-1);
        assertEquals(50, tableNotAdjustable.getHeight());
    }

    @Test
    void setHeight_shouldNotAcceptTooLargeValues() {
        tableNotAdjustable.setHeight(500);
        assertEquals(50, tableNotAdjustable.getHeight());
    }


    // --- area() tesztek ---

    @Test
    void area_shouldReturnCorrectValue() {
        assertEquals(70 * 200, tableNotAdjustable.area());
    }

    @Test
    void area_shouldReturnZeroWhenWidthOrLengthIsZero() {
        Table t = new Table(0, 200, 50);
        assertEquals(0, t.area());

        t = new Table(200, 0, 50);
        assertEquals(0, t.area());
    }


    // --- getCapacity() tesztek ---

    @Test
    void getCapacity_shouldReturnCorrectValue() {
        assertEquals(200 / 60, tableNotAdjustable.getCapacity());
    }

    @Test
    void getCapacity_shouldReturnZeroWhenLengthIsTooSmall() {
        Table tiny = new Table(70, 30, 50);
        assertEquals(0, tiny.getCapacity());
    }


    // --- repaint() tesztek ---

    @Test
    void repaint_shouldNotChangeColorWhenNull() {
        tableNotAdjustable.repaint("Brown");
        tableNotAdjustable.repaint(null);
        assertEquals("Brown", tableNotAdjustable.getColor());
    }

    @Test
    void repaint_shouldNotChangeColorWhenEmptyString() {
        tableNotAdjustable.repaint("Brown");
        tableNotAdjustable.repaint("");
        assertEquals("Brown", tableNotAdjustable.getColor());
    }

    @Test
    void repaint_shouldNotChangeColorWhenWhitespace() {
        tableNotAdjustable.repaint("Brown");
        tableNotAdjustable.repaint("   ");
        assertEquals("Brown", tableNotAdjustable.getColor());
    }

    @Test
    void repaint_shouldChangeColorWhenValidValue() {
        tableNotAdjustable.repaint("Brown");
        assertEquals("Brown", tableNotAdjustable.getColor());

        tableNotAdjustable.repaint("Green");
        assertEquals("Green", tableNotAdjustable.getColor());
    }


    // --- isStable() tesztek ---

    @Test
    void isStable_shouldReturnTrueWhenLegsAre3() {
        tableNotAdjustable.setNumberOfLegs(3);
        assertTrue(tableNotAdjustable.isStable());
    }

    @Test
    void isStable_shouldReturnFalseWhenLegsAreLessThan3() {
        tableNotAdjustable.setNumberOfLegs(2);
        assertFalse(tableNotAdjustable.isStable());
    }


    // --- isFoldable() tesztek ---

    @Test
    void isFoldable_shouldReturnTrueWhenAdjustableAndLegsAre4() {
        tableAdjustable.setNumberOfLegs(4);
        assertTrue(tableAdjustable.isFoldable());
    }

    @Test
    void isFoldable_shouldReturnFalseWhenAdjustableButLegsAreLessThan4() {
        tableAdjustable.setNumberOfLegs(3);
        assertFalse(tableAdjustable.isFoldable());
    }

    @Test
    void isFoldable_shouldReturnFalseWhenNotAdjustableEvenWithEnoughLegs() {
        tableNotAdjustable.setNumberOfLegs(4);
        assertFalse(tableNotAdjustable.isFoldable());
    }


    // --- getPerimeter() teszt ---

    @Test
    void getPerimeter_shouldReturnExpectedPerimeter() {
        assertEquals(2 * 200 + 2 * 50, tableNotAdjustable.getPerimeter());
    }
}
