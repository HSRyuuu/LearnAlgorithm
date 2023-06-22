package 자료구조와_객체.객체;


public interface Shape {
    double area();
}

class Circle implements Shape{
    private Point center;
    private double radius;
    public final double PI = 3.141592;
    @Override
    public double area() {
        return PI * radius;
    }
}
class Square implements Shape{
    private Point topLeft;
    private double side;

    @Override
    public double area() {
        return side * side;
    }
}
