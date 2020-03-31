import java.awt.Graphics;

import javax.swing.JPanel;


public class ShapePanel extends JPanel {

	public void paintComponent(Graphics g){
		int[] polydynx = new int[5];
		int[] polydyny = new int[5];
		int[] polyvectx = new int[6];
		int[] polyvecty = new int[6];
		
		polydynx[0]=50;
		polydyny[0]=50;
		polydynx[1]=75;
		polydyny[1]=75;
		polydynx[2]=60;
		polydyny[2]=125;
		polydynx[3]=30;
		polydyny[3]=125;
		polydynx[4]=10;
		polydyny[4]=75;
		
		for(int i=0;i<5; i++){
			polyvectx[i]=polydynx[i]+400;
			polyvecty[i]=polydyny[i];
		}
		
		polyvectx[5]=425;
		polyvecty[5]=50;
		
		Rectangle rect=new Rectangle();
		Rectangle rect2=new Rectangle(80,120,650,50);
		Circle circ=new Circle(75,250,250);
		Triangle tria=new Triangle(76,300,200);
		PolygonDyn polydyn=new PolygonDyn(polydynx,polydyny,5);
		PolygonVect polyvect=new PolygonVect(polyvectx,polyvecty,6);
		ComposedShape compshp=new ComposedShape();
		
		super.paintComponent(g);
		
		rect.draw(g);
		rect2.draw(g);
		circ.draw(g);
		tria.draw(g);
		polydyn.draw(g);
		polyvect.draw(g);
		compshp.draw(g);
	}
}