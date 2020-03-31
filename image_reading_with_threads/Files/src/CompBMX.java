import java.lang.Math;
import java.util.Comparator;

public class CompBMX implements Comparator {
    public int BMXcovert(RGBcolor p){
        String redbit = Integer.toBinaryString(p.getRed());
        String greenbit = Integer.toBinaryString(p.getGreen());
        String bluebit = Integer.toBinaryString(p.getBlue());
        if(redbit.length()<8){
            while(redbit.length()<8){
                redbit = "0"+redbit;
            }
        }
        if(greenbit.length()<8){
            while(greenbit.length()<8){
                greenbit = "0"+greenbit;
            }
        }
        if(bluebit.length()<8){
            while(bluebit.length()<8){
                bluebit = "0"+bluebit;
            }
        }
        String bmxinteger = "";
        for(int i=0; i<8; i++){
            bmxinteger+=redbit.charAt(i);
            bmxinteger+=greenbit.charAt(i);
            bmxinteger+=bluebit.charAt(i);
        }
        return Integer.parseInt(bmxinteger,2);
    }

    @Override
    public int compare(Object o1, Object o2) {
        pixel1=(RGBcolor)o1;
        pixel2=(RGBcolor)o2;
        int BMXp1 = BMXcovert(pixel1);
        int BMXp2 = BMXcovert(pixel2);
        if(BMXp1>=BMXp2){
            return 0;
        }
        return 1;
    }

    private RGBcolor pixel1;
    private RGBcolor pixel2;
}
