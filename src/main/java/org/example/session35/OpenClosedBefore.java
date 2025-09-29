package org.example.session35;

public class OpenClosedBefore {
}

class AreaCalculator{
    double calculateArea(Object shape){
        if (shape instanceof Circle){
            Circle circle = (Circle) shape;
            return Math.PI * circle.radius * circle.radius;}
        if(shape instanceof Rectangular){
            Rectangular rectangular = (Rectangular) shape;
            return rectangular.lenght * rectangular.width;
        }
        return 0;
    }
}

class Circle{
    double radius;
}

class Rectangular{
    double lenght, width;
}