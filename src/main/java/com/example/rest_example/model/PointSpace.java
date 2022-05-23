package com.example.rest_example.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PointSpace {
    //Todo change it to a set of points
    private Set<Point> featurePoints;

    public PointSpace() {
        featurePoints = new HashSet<>();
    }

    public Point addPoint(Point point) {
        featurePoints.add(point);
        return point;
    }

    public boolean contains(Point point) {
        return featurePoints.contains(point);
    }

    public void removeAllPoints() {
        featurePoints = new HashSet<>();
    }

    public List<Point> getAllPoints() {
        List<Point> copyPoints = new ArrayList<>();
        copyPoints.addAll(featurePoints);
        return copyPoints;
    }
}
