public class RGBcolor {
    public RGBcolor(){
        red=0;
        blue=0;
        green=0;
    }
    public RGBcolor(int r, int g, int b){
        red=r;
        blue=b;
        green=g;
    }
    public int getRed(){
        return red;
    }
    public int getBlue(){
        return blue;
    }
    public int getGreen(){
        return green;
    }
    public void setRGB(int r,int g,int b){
        red=r;
        blue=b;
        green=g;
    }
    @Override
    public String toString() {
        return String.format("Red:%d, Green:%d, Blue:%d",red,green,blue);
    }

    private int red;
    private int blue;
    private int green;
}
