import java.awt.Graphics;


public interface Shape extends Comparable<Shape> {
	public double area();
	public double perimeter();
	public void increment();
	public void decrement();
	public int compareTo(Shape c1);
	public void draw(Graphics g);
}
