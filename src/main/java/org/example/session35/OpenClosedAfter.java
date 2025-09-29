package org.example.session35;

public class OpenClosedAfter {
    public static void main(String[] args) {
        Shape circle = new CircleA(10.2);
        System.out.println("circle: " + circle.calculateArea());
        Shape rectangular = new RectangularA(12, 34);
        System.out.println("rectangular: " + rectangular.calculateArea());
        Shape square = new Square(4);
        System.out.println("square: " + square.calculateArea());
    }
}

interface Shape{
    double calculateArea();
}

class CircleA implements Shape{
    double radius;

    public CircleA(double radius) {
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
}

class RectangularA implements Shape{
    double lenght, width;

    public RectangularA(double lenght, double width) {
        this.lenght = lenght;
        this.width = width;
    }

    @Override
    public double calculateArea() {
        return lenght * width;
    }
}

class Square implements Shape{
    double lenght;

    public Square(double lenght) {
        this.lenght = lenght;
    }

    @Override
    public double calculateArea() {
        return lenght * lenght;
    }
}