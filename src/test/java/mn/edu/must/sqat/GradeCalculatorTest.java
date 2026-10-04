package mn.edu.must.sqat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class GradeCalculatorTest {

    // ---- letterGrade: хязгаарын утгууд ----

    @Test
    @DisplayName("90 оноо яг A дүн байх ёстой (хязгаарын тохиолдол)")
    void ninetyIsExactlyA() {
        GradeCalculator calc = new GradeCalculator();   // Arrange
        String grade = calc.letterGrade(90.0);          // Act
        assertEquals("A", grade);                       // Assert
    }

    @Test
    @DisplayName("89.99 оноо B дүн байх ёстой")
    void eightyNinePointNineNineIsB() {
        GradeCalculator calc = new GradeCalculator();
        String grade = calc.letterGrade(89.99);
        assertEquals("B", grade);
    }

    @Test
    @DisplayName("60 оноо яг D дүн байх ёстой")
    void sixtyIsD() {
        GradeCalculator calc = new GradeCalculator();
        String grade = calc.letterGrade(60.0);
        assertEquals("D", grade);
    }

    @Test
    @DisplayName("59.99 оноо F дүн байх ёстой")
    void fiftyNinePointNineNineIsF() {
        GradeCalculator calc = new GradeCalculator();
        String grade = calc.letterGrade(59.99);
        assertEquals("F", grade);
    }

    @Test
    @DisplayName("0 оноо F дүн байх ёстой (доод хязгаар)")
    void zeroIsF() {
        GradeCalculator calc = new GradeCalculator();
        String grade = calc.letterGrade(0.0);
        assertEquals("F", grade);
    }

    @Test
    @DisplayName("100 оноо A дүн байх ёстой (дээд хязгаар)")
    void hundredIsA() {
        GradeCalculator calc = new GradeCalculator();
        String grade = calc.letterGrade(100.0);
        assertEquals("A", grade);
    }

    // ---- letterGrade: буруу оролт ----

    @Test
    @DisplayName("-1 оноо IllegalArgumentException шидэх ёстой")
    void negativeScoreThrows() {
        GradeCalculator calc = new GradeCalculator();
        assertThrows(IllegalArgumentException.class, () -> calc.letterGrade(-1));
    }

    @Test
    @DisplayName("101 оноо IllegalArgumentException шидэх ёстой")
    void over100Throws() {
        GradeCalculator calc = new GradeCalculator();
        assertThrows(IllegalArgumentException.class, () -> calc.letterGrade(101));
    }

    // ---- totalScore ----

    @Test
    @DisplayName("Бүх оноо дээд хэмжээтэй бол нийлбэр 100 байх ёстой")
    void totalScoreMaxIs100() {
        GradeCalculator calc = new GradeCalculator();
        double total = calc.totalScore(10, 40, 10, 10, 30);
        assertEquals(100.0, total, 0.0001);
    }

    @Test
    @DisplayName("Сөрөг ирц IllegalArgumentException шидэх ёстой")
    void negativeAttendanceThrows() {
        GradeCalculator calc = new GradeCalculator();
        assertThrows(IllegalArgumentException.class,
                () -> calc.totalScore(-5, 40, 10, 10, 30));
    }

    @Test
    @DisplayName("Лабын оноо 40-өөс хэтэрвэл IllegalArgumentException шидэх ёстой")
    void labOverMaxThrows() {
        GradeCalculator calc = new GradeCalculator();
        assertThrows(IllegalArgumentException.class,
                () -> calc.totalScore(10, 41, 10, 10, 30));
    }

    // ---- Parameterized ----

    @ParameterizedTest
    @CsvSource({"95,A", "85,B", "75,C", "65,D", "30,F",
                "90,A", "89.99,B", "80,B", "70,C", "60,D", "59.99,F", "0,F"})
    @DisplayName("letterGrade: ердийн болон хязгаарын утгууд")
    void letterGradeBoundaries(double score, String expected) {
        assertEquals(expected, new GradeCalculator().letterGrade(score));
    }

    @ParameterizedTest
    @CsvSource({"10,40,10,10,30,100", "0,0,0,0,0,0", "5,20,5,5,15,50"})
    @DisplayName("totalScore: зөв нийлбэр")
    void totalScoreSums(double att, double lab, double q1, double q2,
                        double exam, double expected) {
        assertEquals(expected,
                new GradeCalculator().totalScore(att, lab, q1, q2, exam), 0.0001);
    }
}
