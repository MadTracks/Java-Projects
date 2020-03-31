import java.util.Comparator;

public class CompEUC implements Comparator {
    public double EUCcovert(RGBcolor p){
        return Math.sqrt(p.getRed()*p.getRed()+p.getGreen()*p.getGreen()+p.getBlue()*p.getBlue());
    }

    @Override
    public int compare(Object o1, Object o2) {
        pixel1=(RGBcolor)o1;
        pixel2=(RGBcolor)o2;
        double BMXp1 = EUCcovert(pixel1);
        double BMXp2 = EUCcovert(pixel2);
        if(BMXp1>=BMXp2){
            return 0;
        }
        return 1;
    }
    private RGBcolor pixel1;
    private RGBcolor pixel2;
}
