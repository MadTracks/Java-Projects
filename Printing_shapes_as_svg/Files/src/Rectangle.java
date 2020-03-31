import java.awt.Color;
import java.awt.Graphics;


public class Rectangle implements Shape {

	public Rectangle(){
		rheight=100;
		rwidth=100;
		rx=0;
		ry=0;
		
	}
	public Rectangle(int height,int width){
		rheight=height;
		rwidth=width;
		rx=0;
		ry=0;
	}
	public Rectangle(int height,int width,int x,int y){
		rheight=height;
		rwidth=width;
		rx=x;
		ry=y;
	}
	public void setRectangle(int height,int width,int x,int y){
		rheight=height;
		rwidth=width;
		rx=x;
		ry=y;
	}
	public int getRheight(){
		return rheight;
	}
	public int getRwidth(){
		return rwidth;
	}
	public int getrx(){
		return rx;
	}
	public int getry(){
		return ry;
	}
	
	@Override
	public double area() {
		return rheight*rwidth;
	}

	@Override
	public double perimeter() {
		return 2*(rheight+rwidth);
	}

	@Override
	public void increment() {
		rx++;
		ry++;
	}

	@Override
	public void decrement() {
		rx--;
		ry--;
	}

	@Override
	public int compareTo(Shape c1) {
		return Double.compare(this.area(), c1.area());
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(rx, ry, rwidth, rheight);
	}
	private int rheight;
	private int rwidth;
	private int rx,ry;
}
