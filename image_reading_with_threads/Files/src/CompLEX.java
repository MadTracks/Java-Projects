import java.util.Comparator;

public class CompLEX implements Comparator {
    public int LEXcovert(RGBcolor p){
        String sred = Integer.toString(p.getRed());
        String sgreen = Integer.toString(p.getGreen());
        String sblue = Integer.toString(p.getBlue());
        if(sred.length()<3){
            while(sred.length()<3){
                sred = "0"+sred;
            }
        }
        if(sgreen.length()<3){
            while(sgreen.length()<3){
                sgreen = "0"+sgreen;
            }
        }
        if(sblue.length()<3){
            while(sblue.length()<3){
                sblue = "0"+sblue;
            }
        }
        String lexinteger = "";
        lexinteger+=sred;
        lexinteger+=sgreen;
        lexinteger+=sblue;
        return Integer.parseInt(lexinteger);
    }

    @Override
    public int compare(Object o1, Object o2) {
        pixel1=(RGBcolor)o1;
        pixel2=(RGBcolor)o2;
        int LEXp1 = LEXcovert(pixel1);
        int LEXp2 = LEXcovert(pixel2);
        if(LEXp1>=LEXp2){
            return 0;
        }
        return 1;
    }

    private RGBcolor pixel1;
    private RGBcolor pixel2;
}
