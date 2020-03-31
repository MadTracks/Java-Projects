import java.awt.Color;
import java.awt.Graphics;


public class ComposedShape implements Shape {

	
	public ComposedShape(){
		Rectangle rect=new Rectangle(200,300,400,400);
		Circle[] circ=new Circle[150];
		int i,j,verticalsize;
		verticalsize=0;
		j=0;
		
		for(i=0; 20*i<rect.getRwidth(); i++){
			for(j=0; 20*j<rect.getRheight(); j++){
				circ[i*verticalsize+j]= new Circle(20,i*20+400,j*20+400);
			}
			verticalsize=j;
		}
		size=i*verticalsize+1;
		shapes=new Shape[size];
		shapes[0]=rect;
		for(int k=0; k<size-1; k++){
			shapes[k+1]=circ[k];
		}
	}
	
	@Override
	public double area() {
		return shapes[0].area()-((size-1)*shapes[1].area());
	}

	@Override
	public double perimeter() {
		return shapes[0].perimeter()+((size-1)*shapes[1].perimeter());
	}

	@Override
	public void increment() {
		for(int i=0; i<size; i++){
			shapes[i].increment();
		}
	}

	@Override
	public void decrement() {
		for(int i=0; i<size; i++){
			shapes[i].decrement();
		}
	}

	@Override
	public int compareTo(Shape c1) {
		return Double.compare(this.area(), c1.area());
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(Color.MAGENTA);
		shapes[0].draw(g);
		g.setColor(Color.ORANGE);
		for(int i=1; i<size; i++){
			shapes[i].draw(g);
		}
		
	}
	private Shape[] shapes;
	private int size;
}
