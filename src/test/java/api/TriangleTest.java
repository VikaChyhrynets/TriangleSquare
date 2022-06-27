package api;


import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit test for TriangleSquare App.
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@Slf4j
public class TriangleTest {

    private Triangle triangleSquare;

    @BeforeAll
    public void setUp() {
        triangleSquare = new Triangle();
        System.setProperty("log4j.configurationFile", "logback-test.xml");
    }

    @DisplayName("Square can't be calculated if at least one side length is zero")
    @ParameterizedTest(name = "{index} => a={0}, b={1}, c={2}")
    @CsvSource({
            "0, 10, 1.5",
            "5, 0, 5",
            "1.5,10,0"
    })
    public void zeroSide(double a, double b, double c) {
        log.info("zeroSide");
        double expectedResult = -1;
        double result = triangleSquare.square(a, b, c);
        assertEquals(expectedResult,result);
    }

    @DisplayName("Square can't be calculated if at least one side length is less than zero")
    @ParameterizedTest(name = "{index} => a={0}, b={1}, c={2}")
    @CsvSource({
            "3, 5, -5",
            "5, -5, 3",
            "-1.5,10,1"
    })
    public void negativeSide(double a, double b, double c) {
        log.info("negativeSide");
        double expectedResult = -1;
        double result = triangleSquare.square(a, b, c);
        assertEquals(expectedResult,result);
    }

    @DisplayName("Calculating zero square")
    @ParameterizedTest(name = "{index} => a={0}, b={1}, c={2}")
    @CsvSource({
            "10, 5, 5",
            "3, 6, 3",
            "4.5,9,4.5"
    })
    public void zeroSquareTriangle(double a, double b, double c) {
        log.info("zeroSquareTriangle");
        double expectedResult = 0;
        double result = triangleSquare.square(a, b, c);
        assertEquals(expectedResult,result);
    }

    @DisplayName("Calculating positive square")
    @ParameterizedTest(name = "{index} => a={0}, b={1}, c={2}, expectedResult={3}")
    @CsvSource({
            "3, 4, 5, 6",
            "8.5, 15.8, 21.3, 58.51",
            "350, 500, 800.9, 55997.12"
    })
    public void positiveSquareTriangle(double a, double b, double c, double expectedResult) {
        log.info("positiveSquareTriangle");
        double result = triangleSquare.square(a, b, c);
        assertEquals(expectedResult,result);
    }

    @DisplayName("Square can't be calculated if the sum of two sides less than third side")
    @ParameterizedTest(name = "{index} => a={0}, b={1}, c={2}")
    @CsvSource({
            "10, 5, 3",
            "3, 6, 15",
            "4.5,22,4.5"
    })
    public void incorrectTriangle(double a, double b, double c) {
        log.info("incorrectTriangle");
        double expectedResult = -1;
        double result = triangleSquare.square(a, b, c);
        assertEquals(expectedResult,result);
    }

}
