package com.example.rest_example.controller;

import java.util.List;

import com.example.rest_example.model.PointSpace;
import com.example.rest_example.model.LineDetection;
import com.example.rest_example.model.Point;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class FeatureDetectionController {

    private PointSpace space;

    public FeatureDetectionController() {
        space = new PointSpace();
    }

    @PostMapping("/add") 
    public Point addPoint(@RequestBody Point point){
        if(space.contains(point))
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, String.format("Point (%.2f; %.2f) already exists", point.x, point.y));

        return space.addPoint(point);
    }

    @GetMapping("/space")
    public List<Point> getSpace() {
        return space.getAllPoints();
    }

    @GetMapping("/lines/{n}")
    public List<List<Point>> getDetectedLines(@PathVariable Integer n) {
        if(n <= 1)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Threshold of number of points should be at least 2, otherwise there are infinite lines");

        return LineDetection.detectLines(space, n);
    }

    @DeleteMapping("/space")
    public void deleteSpace() {
        space.removeAllPoints();
    }
}
