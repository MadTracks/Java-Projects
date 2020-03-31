import java.awt.Color;
import java.awt.Graphics;


public class Circle implements Shape {
	
	public Circle(){
		cradius=100;
		cx=0;
		cy=0;
		
	}
	public Circle(int radius){
		cradius=radius;
		cx=0;
		cy=0;
	}
	public Circle(int radius,int x,int y){
		cradius=radius;
		cx=x;
		cy=y;
	}
	public void setCircle(int radius,int x,int y){
		cradius=radius;
		cx=x;
		cy=y;
	}
	public int getCradius(){
		return cradius;
	}
	public int getcx(){
		return cx;
	}
	public int getcy(){
		return cy;
	}
	
	@Override
	public double area() {
		return Math.PI*cradius*cradius;
	}

	@Override
	public double perimeter() {
		return 2*Math.PI*cradius;
	}

	@Override
	public void increment() {
		cx++;
		cy++;
	}

	@Override
	public void decrement() {
		cx--;
		cy--;
	}
	
	@Override
	public int compareTo(Shape c1) {
		return Double.compare(this.area(), c1.area());
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(Color.CYAN);
		g.fillOval(cx, cy, cradius, cradius);

	}
	private int cradius;
	private int cx;
	private int cy;
}
