import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class FirstThread extends Thread {
    @Override
    public void run() {
        try {
            File myfile = new File("src/example.png");
            BufferedImage myimage = ImageIO.read(myfile);
            int width = myimage.getWidth();
            int height = myimage.getHeight();
            RGBcolor[][] myrgb = new RGBcolor[height][width];
            PriorityQ PQLEX = new PriorityQ(new CompLEX());
            PriorityQ PQEUC = new PriorityQ(new CompEUC());
            PriorityQ PQBMX = new PriorityQ(new CompBMX());
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    int pixel = myimage.getRGB(j, i);
                    int red = (pixel >> 16) & 0xff;
                    int green = (pixel >> 8) & 0xff;
                    int blue = pixel & 0xff;
                    RGBcolor rgbpixel = new RGBcolor(red, green, blue);
                    myrgb[i][j] = rgbpixel;
                }
            }
            for(int i=0; i<100; i++) {
                PQLEX.insert(myrgb[0][i]);
                PQEUC.insert(myrgb[0][i]);
                PQBMX.insert(myrgb[0][i]);
                System.out.println("Thread 1: " + myrgb[0][i]);
            }
            int i=0;
            int j=100;
            int size=(height*width)-10;
            ComparatorThread ThreadLEX = new ComparatorThread(PQLEX, "Thread 2-PQLEX ",size);
            ComparatorThread ThreadEUC = new ComparatorThread(PQEUC, "Thread 3-PQEUC ",size);
            ComparatorThread ThreadBMX = new ComparatorThread(PQBMX, "Thread 4-PQBMX ",size);
            ThreadLEX.start();
            ThreadEUC.start();
            ThreadBMX.start();
            while(i<height){
                while(j<width){
                    PQLEX.insert(myrgb[i][j]);
                    PQEUC.insert(myrgb[i][j]);
                    PQBMX.insert(myrgb[i][j]);
                    System.out.println("Thread 1: " + myrgb[i][j]);
                    j++;
                }
                i++;
                j=0;
            }
        }
        catch(IOException e){
            System.out.println("File can not found or read.");
        }
    }
}
