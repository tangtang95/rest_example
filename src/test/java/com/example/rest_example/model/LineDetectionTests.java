package com.example.rest_example.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Test on line detection algorithm with integer points
 */
public class LineDetectionTests {

    PointSpace pointSpace;

    @BeforeEach
    void setUp() {
        pointSpace = new PointSpace();
    }

    @Test
    void testVerticalLine() {
        pointSpace.addPoint(new Point(2, 1));
        pointSpace.addPoint(new Point(2, 6));
        pointSpace.addPoint(new Point(2, 10));
        List<List<Point>> expectedLines = new ArrayList<>();
        expectedLines.add(pointSpace.getAllPoints());
        assertEquals(expectedLines, LineDetection.detectLines(pointSpace, 2), "Test on vertical lines with threshold 2");
        assertEquals(expectedLines, LineDetection.detectLines(pointSpace, 3), "Test on vertical lines with threshold 3");
    }

    @Test
    void testHorizontalLine() {
        pointSpace.addPoint(new Point(1, 5));
        pointSpace.addPoint(new Point(3, 5));
        pointSpace.addPoint(new Point(4, 5));
        List<List<Point>> expectedLines = new ArrayList<>();
        expectedLines.add(pointSpace.getAllPoints());
        assertEquals(expectedLines, LineDetection.detectLines(pointSpace, 2), "Test on horizontal lines with threshold 2");
        assertEquals(expectedLines, LineDetection.detectLines(pointSpace, 3), "Test on horizontal lines with threshold 3");
    }

    @Test
    void testLineThreshold() {
        pointSpace.addPoint(new Point(1, 5));
        pointSpace.addPoint(new Point(3, 5));
        pointSpace.addPoint(new Point(4, 5));
        pointSpace.addPoint(new Point(2, 10));
        pointSpace.addPoint(new Point(2, 6));
        pointSpace.addPoint(new Point(3, 15));
        List<List<Point>> expectedLines = new ArrayList<>();
        expectedLines.add(List.of(new Point(1, 5), new Point(3, 5), new Point(4, 5)));
        expectedLines.add(List.of(new Point(1, 5), new Point(2, 10), new Point(3, 15)));
        assertEquals(expectedLines, LineDetection.detectLines(pointSpace, 3), "Test with threshold 3");
        expectedLines = new ArrayList<>();
        assertEquals(expectedLines, LineDetection.detectLines(pointSpace, 4), "Test with threshold 4");
    }
}
