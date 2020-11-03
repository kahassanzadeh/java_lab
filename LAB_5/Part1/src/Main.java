public class Main {

    public static void main(String[] args) {
        Rectangle rect11 = new Rectangle(2,4);
        Rectangle rect22 = new Rectangle(6,4);
        Rectangle rect33 = new Rectangle(6,6);
        System.out.println("equals: " + rect11.equals(rect22));
        Triangle tr = new Triangle(1,9,3);
        System.out.println("Triangle perimeter: " + tr.calculatePerimeter());
        tr.draw();
        if(rect33.isSquare()) {
            System.out.println("Square");
        }

        Circle circle1 = new Circle(19);
        Circle circle2 = new Circle(3);

        Rectangle rect1 = new Rectangle(1, 4);
        Rectangle rect2 = new Rectangle(8, 5);
        Rectangle rect3 = new Rectangle(6, 6);

        Triangle tri1 = new Triangle(2, 2, 2);
        Triangle tri2 = new Triangle(4, 4, 6);

        Paint paint = new Paint();
        paint.addCircle(circle1);
        paint.addCircle(circle2);
        paint.addRectangle(rect1);
        paint.addRectangle(rect2);
        paint.addRectangle(rect3);
        paint.addTriangle(tri1);
        paint.addTriangle(tri2);
        paint.drawAll();
        paint.printAll();
    }
}
