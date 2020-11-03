import java.util.ArrayList;
import java.util.Objects;
/**
 * this class is created for Polygonal and calculating perimeters and areas
 *
 * @author Mohammadreza Hassanzadeh
 * @version 1.0
 * @since Nov 3 2020
 */
public class Polygon extends Shape {

    //this array list will save the sides of our polygon
    protected ArrayList<Double> sides;

    /**
     * this constructor can get indefinite numbers of sides and make a polygonal with it
     * @param side list of the sides
     */
    public Polygon(double... side){
        this.sides = new ArrayList<>();
        for(Double sd : side){
            this.sides.add(sd);
        }
    }

    /**
     * getting the array list of the sides
     * @return Array list of the sides
     */
    public ArrayList<Double> getSides() {
        return sides;
    }

    /**
     * calculating the perimeter of the polygonal
     * @return the perimeter of the polygonal double type
     */
    @Override
    public double calculatePerimeter() {
        double perimeter = 0;
        for(Double sd : sides){
            perimeter += sd;
        }
        return (this.getClass().getName().equals("Rectangle") ? (perimeter * 2) : perimeter);
    }

    /**
     * this method will calculate the area of the polygonal
     * if it is rectangle this method will use heron's law for calculating the area
     * @return double type of the Area
     */
    @Override
    public double calculateArea() {
        if(this.getClass().getName().equals("Triangle")) {
            double p = calculatePerimeter() / 2;
            return (Math.sqrt(p*(p - sides.get(0))*(p - sides.get(1))*(p - sides.get(2))));
        }
        else {
            return (sides.get(0) * sides.get(1));
        }
    }

    /**
     * overriding the equals method
     * @param obj object that we want to compare to "this"
     * @return true if objects are the same;
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Polygon)) return false;

        Polygon polygon = (Polygon) obj;

        return getSides() != null ? getSides().equals(polygon.getSides()) : polygon.getSides() == null;
    }

    /**
     * overriding the hashcode method
     * @return hash of the objects
     */
    @Override
    public int hashCode() {
        return Objects.hash(sides);
    }

    /**
     * returns a string with their polygonal name and sides
     * @return String
     */
    @Override
    public String toString() {
        return "This is a " + this.getClass().getName() + "\n" +
                "sides = " + sides;
    }
}
