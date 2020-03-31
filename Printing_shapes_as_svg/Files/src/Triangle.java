import java.awt.Color;
import java.awt.Graphics;


public class Triangle implements Shape {
	
	public Triangle(){
		tside=100;
		theight=100;
		tx=new int[3];
		ty=new int[3];
		tx[0]=tside/2;
		ty[0]=0;
		tx[1]=0;
		ty[1]=tside;
		tx[2]=tside;
		ty[3]=tside;
	}
	public Triangle(int side){
		tside=side;
		theight=side;
		tx=new int[3];
		ty=new int[3];
		tx[0]=side/2;
		ty[0]=0;
		tx[1]=0;
		ty[1]=side;
		tx[2]=side;
		ty[3]=side;
	}
	public Triangle(int side,int x,int y){
		tside=side;
		theight=side;
		tx=new int[3];
		ty=new int[3];
		
		tx[0]=x+side/2;
		ty[0]=y+0;
		tx[1]=x+0;
		ty[1]=y+side;
		tx[2]=x+side;
		ty[2]=y+side;
	}
	public void setTriangle(int side,int[] x,int[] y){
		tside=side;
		theight=side;
		for(int i=0; i<3; i++){
			tx[i]=x[i];
			ty[i]=y[i];
		}
	}
	public int getTheight(){
		return theight;
	}
	public int getTside(){
		return tside;
	}
	public int gettx(int index){
		return tx[index];
	}
	public int getty(int index){
		return ty[index];
	}
	
	@Override
	public double area() {
		return (theight*tside)/2.0;
	}

	@Override
	public double perimeter() {
		return tside*3;
	}

	@Override
	public void increment() {
		for(int i=0; i<3; i++){
			tx[i]++;
			ty[i]++;
		}
	}

	@Override
	public void decrement() {
		for(int i=0; i<3; i++){
			tx[i]--;
			ty[i]--;
		}
	}

	@Override
	public int compareTo(Shape c1) {
		return Double.compare(this.area(), c1.area());
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(Color.RED);
		g.fillPolygon(tx, ty, 3);
	}
	private int tside;
	private int theight;
	private int[] tx;
	private int[] ty;
}
