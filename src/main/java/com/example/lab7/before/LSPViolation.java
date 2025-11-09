package com.example.lab7.before;

/**
 * Классы с нарушением LSP - квадрат не может быть заменой прямоугольника
 */
public class LSPViolation {

    public static class Rectangle {
        protected double width;
        protected double height;

        public Rectangle(double width, double height) {
            this.width = width;
            this.height = height;
        }

        public void setWidth(double width) {
            this.width = width;
        }

        public void setHeight(double height) {
            this.height = height;
        }

        public double getArea() {
            return width * height;
        }

        public double getPerimeter() {
            return 2 * (width + height);
        }
    }

    /**
     * Квадрат нарушает LSP - он не может быть заменой прямоугольника
     * При изменении ширины также меняется высота
     */
    public static class Square extends Rectangle {
        public Square(double side) {
            super(side, side);
        }

        // Нарушение LSP: установка ширины также меняет высоту
        @Override
        public void setWidth(double width) {
            super.setWidth(width);
            super.setHeight(width); // Неожиданное поведение!
        }

        // Нарушение LSP: установка высоты также меняет ширину
        @Override
        public void setHeight(double height) {
            super.setWidth(height); // Неожиданное поведение!
            super.setHeight(height);
        }
    }

    /**
     * Еще один пример нарушения LSP
     */
    public static class Bird {
        public void fly() {
            System.out.println("Птица летит");
        }

        public void eat() {
            System.out.println("Птица ест");
        }
    }

    public static class Penguin extends Bird {
        // Нарушение LSP: пингвин не может летать, но наследует метод fly
        @Override
        public void fly() {
            throw new UnsupportedOperationException("Пингвины не могут летать!");
        }
    }
}