import java.awt.Color;
import java.awt.Graphics;
import java.util.*;

public class PolygonVect extends Polygon {
	
	public PolygonVect(){
		px=new ArrayList<Integer>(1);
		py=new ArrayList<Integer>(1);
		psize=1;
	}
	public PolygonVect(int[] x,int[] y,int size){
		px=new ArrayList<Integer>(size);
		py=new ArrayList<Integer>(size);
		for(int i=0; i<size; i++){
			px.add(x[i]);
			py.add(y[i]);
		}
		psize=size;
	}
	public void setPolygonVect(int[] x,int[] y,int size){
		px=new ArrayList<Integer>(size);
		py=new ArrayList<Integer>(size);
		for(int i=0; i<size; i++){
			px.add(x[i]);
			py.add(y[i]);
		}
		psize=size;
	}
	
	@Override
	public double area() {
		double result=0.0;
		int j;
		j=psize-1;
		for(int i=0; i<psize; i++){
			result+=(px.get(j)+px.get(i))*(py.get(j)-py.get(i));
			j=i;
		}
		result=result/2.0;
		return result;
	}

	@Override
	public double perimeter() {
		double result=0.0;
		int j;
		j=psize-1;
		for(int i=0; i<psize; i++){
			result+=Math.sqrt((px.get(j)-px.get(i))*(px.get(j)-px.get(i))+(py.get(j)-py.get(i))*(py.get(j)-py.get(i)));
			j=i;
		}
		return result;
	}

	@Override
	public void increment() {
		for(int i=0; i<psize; i++){
			px.set(i,px.get(i)+1);
			py.set(i,py.get(i)+1);
		}
	}

	@Override
	public void decrement() {
		for(int i=0; i<psize; i++){
			px.set(i,px.get(i)-1);
			py.set(i,py.get(i)-1);
		}

	}

	@Override
	public int compareTo(Shape c1) {
		return Double.compare(this.area(), c1.area());
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(Color.YELLOW);
		int j;
		j=psize-1;
		for(int i=0; i<psize; i++){
			g.drawLine(px.get(j), py.get(j),px.get(i) ,py.get(i));
			j=i;
		}
	}
	
	private ArrayList<Integer> px;
	private ArrayList<Integer> py;
	private int psize;
}