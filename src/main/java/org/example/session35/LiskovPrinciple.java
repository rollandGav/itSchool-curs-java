package org.example.session35;

public class LiskovPrinciple {
    public static void main(String[] args) {
        //before
        RectangularBefore rectangularBefore = new RectangularBefore(5, 10);
        rectangularBefore.setHeight(6);
        rectangularBefore.setWidth(12);
        System.out.println(rectangularBefore.getArea());

        SquareBefore squareBefore = new SquareBefore(4);
        squareBefore.setHeight(5);
        squareBefore.setWidth(2);
        System.out.println(squareBefore.getArea());

        // after
        ShapeAfter rectA = new RectangularAfter(6,12);
        System.out.println(rectA.getArea());
        ShapeAfter squareA = new SquareAfter(4);
        System.out.println(squareA.getArea());
    }
}

class RectangularBefore {
    public int width;
    public int height;

    public RectangularBefore(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getArea() {
        return width * height;
    }
}

class SquareBefore extends RectangularBefore {

    public SquareBefore(int lenght) {
        super(lenght, lenght);
    }

    @Override
    public void setWidth(int width) {
        super.setWidth(width);
        super.setHeight(width);
    }

    @Override
    public void setHeight(int height) {
        super.setHeight(height);
        super.setWidth(height);
    }
}

interface ShapeAfter {
    int getArea();
}

class RectangularAfter implements ShapeAfter {
    public int width;
    public int height;

    public RectangularAfter(int width, int height) {
        this.width = width;
        this.height = height;
    }


    @Override
    public int getArea() {
        return height * width;
    }
}

class SquareAfter implements ShapeAfter {
    public int size;

    public SquareAfter(int size) {
        this.size = size;
    }

    @Override
    public int getArea() {
        return size * size;
    }
}