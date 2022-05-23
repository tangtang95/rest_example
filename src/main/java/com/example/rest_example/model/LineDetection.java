package com.example.rest_example.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LineDetection {
    /**
     * Return a list of lines that pass through at least n points in the given space of points
     * @param pointSpace a point space data structure containing a set of points in a space
     * @param n number of points threshold 
     * @return a list of lines where a line is represented by a list of points 
     */
    public static List<List<Point>> detectLines(PointSpace pointSpace, int n) {
        List<Point> points = pointSpace.getAllPoints();
        Map<Line, List<Point>> lineMap = new HashMap<>();
        for (int i = 0; i < points.size(); i++) {
            for (int j = i + 1; j < points.size(); j++) {
                lineMap.put(new Line(points.get(i), points.get(j)), new ArrayList<>());
            }
        }

        for (Point p: points) {
            for (var lineEntry: lineMap.entrySet()) {
                if(lineEntry.getKey().passThrough(p))
                    lineEntry.getValue().add(p);
            }
        }

        List<List<Point>> filteredLines = new ArrayList<>();
        for(var lineEntry: lineMap.entrySet()) {
            if(lineEntry.getValue().size() >= n)
                filteredLines.add(lineEntry.getValue());
        }

        return filteredLines;
    }
}
