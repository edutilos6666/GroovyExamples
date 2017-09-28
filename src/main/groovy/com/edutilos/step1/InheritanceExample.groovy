package com.edutilos.step1

import groovy.transform.Canonical


class InheritanceExample {
    static abstract class Shape {
        abstract double perimeter();
        abstract double area();
    }

    @Canonical
    static class Triangle extends Shape {
        double x
        double y
        double z

        @Override
        double perimeter() {
            x + y + z
        }

        @Override
        double area() {
            def p  = perimeter()/2
            def S = Math.sqrt(p*(p-x)*(p-y)*(p-z))
            S
        }

        @Override
        String toString() {
            String.format("Triangle(%.2f, %.2f, %.2f)", x, y, z)
        }
    }


    @Canonical
    static class Rectangle extends Shape {
        double width
        double height

        @Override
        double perimeter() {
            (width+height)*2
        }
        @Override
        double area() {
            width*height
        }
        @Override
        String toString() {
            String.format("Rectangle(%.2f, %.2f)", width , height)
        }
    }

    @Canonical
    static class Circle extends Shape {
        double r

        @Override
        double perimeter() {
            2*Math.PI*r
        }

        @Override
        double area() {
            Math.PI*Math.pow(r, 2)
        }
        @Override
        String toString() {
            String.format("Circle(%.2f)", r)
        }
    }

}
