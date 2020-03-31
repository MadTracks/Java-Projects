import java.awt.*;
import javax.swing.*;


public class Shapemain{

	/**
	 * @param args
	 */
	
	public static void drawAll(Shape[] all_shapes,int size,Graphics g){
		for(int i=0;i<size;i++){
			all_shapes[i].draw(g);
		}
	}
	public static void sortShapes(Shape[] all_shapes,int size){
		Shape temp;
		for(int i=0; i<size; i++){
			for(int j=i; j<size; j++){
				if(all_shapes[i].area()>all_shapes[j].area()){
					temp=all_shapes[i];
					all_shapes[i]=all_shapes[j];
					all_shapes[j]=temp;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		
		ShapePanel myshapesPanel = new ShapePanel();
		JFrame myframe= new JFrame("HW07");
		myshapesPanel.setBackground(Color.BLACK);
		myframe.setSize(new Dimension(1000,800));
		myframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myframe.add(myshapesPanel);
		myframe.setVisible(true);
		
	}

}
