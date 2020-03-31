import java.awt.Color;
import java.awt.Graphics;


public class PolygonDyn extends Polygon {
	
	public PolygonDyn(){
		px=new int[1];
		py=new int[1];
		px[0]=0;
		py[0]=0;
		psize=1;
	}
	
	public PolygonDyn(int[] x,int[] y,int size){
		px=new int[size];
		py=new int[size];
		for(int i=0; i<size; i++){
			px[i]=x[i];
			py[i]=y[i];
		}
		psize=size;
	}
	
	public void setPolygonDyn(int[] x,int[] y,int size){
		px=new int[size];
		py=new int[size];
		for(int i=0; i<size; i++){
			px[i]=x[i];
			py[i]=y[i];
		}
		psize=size;
	}
	
	@Override
	public double area() {
		double result=0.0;
		int j;
		j=psize-1;
		for(int i=0; i<psize; i++){
			result+=(px[j]+px[i])*(py[j]-py[i]);
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
			result+=Math.sqrt((px[j]-px[i])*(px[j]-px[i])+(py[j]-py[i])*(py[j]-py[i]));
			j=i;
		}
		return result;
	}

	@Override
	public void increment() {
		for(int i=0; i<psize; i++){
			px[i]++;
			py[i]++;
		}
	}

	@Override
	public void decrement() {
		for(int i=0; i<psize; i++){
			px[i]--;
			py[i]--;
		}
	}

	@Override
	public int compareTo(Shape c1) {
		return Double.compare(this.area(), c1.area());
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(Color.GREEN);
		g.fillPolygon(px, py, psize);
	}
	
	private int[] px;
	private int[] py;
	private int psize;
}
