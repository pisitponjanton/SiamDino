package add_req;

public abstract class Shape {
    String color;

    Shape(String color) {
        this.color = color;
    }

    abstract double getArea();
}
