package com.example.rest_example.model;

import java.util.Objects;

public final class Line {
    public final float slope;
    public final float intersect;

    public Line(Point p1, Point p2) {
        if(p2.x == p1.x) {
            slope = Float.MAX_VALUE;
            intersect = p1.x;
        }
        else {
            slope = (p2.y - p1.y) / (p2.x - p1.x);
            intersect = p1.y - slope * p1.x;
        }
    }

    public boolean belongs(Point p) {
        if(slope == Float.MAX_VALUE) {
            return p.x == intersect;
        }
        else {
            return p.y == slope * p.x + intersect;
        }
    }

    @Override
    public String toString() {
        return String.format("line(m: %.2f, c: %.2f", slope, intersect);
    }

    @Override
    public boolean equals(Object other) {
        if(this == other)
            return true;
        if(!(other instanceof Line))
            return false;
        Line line = (Line) other;
        return this.slope == line.slope && this.intersect == line.intersect;        
    }

    @Override
    public int hashCode() {
        return Objects.hash(slope, intersect);
    }

}
