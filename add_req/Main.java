package add_req;

public class Main {
    public static void main(String[] args) {
        // ใช้เมธอดรับ abstract class
        Shape circle = new Circle("Blue", 5);
        ShapeProcessor shapeProcessor = new ShapeProcessor();
        shapeProcessor.printArea(circle);

        // ใช้เมธอดรับ interface
        Printable doc = new Document();
        Printer printer = new Printer();
        printer.startPrintJob(doc);
    }
}
