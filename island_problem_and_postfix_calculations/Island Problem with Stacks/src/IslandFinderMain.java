import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class IslandFinderMain {
    public static void main(String[] args){
        IslandFinder island = new IslandFinder();
        int islandsize=0;
        File myfile = new File(args[0]);
        try {
            Scanner myscanner = new Scanner(myfile);
            String temp;
            int row=0;
            while(myscanner.hasNext()){
                temp=myscanner.nextLine();
                island.recreateMap(row+1,temp.length()/2);
                Scanner stringcheck = new Scanner(temp);
                for(int i=0; i<temp.length(); i+=2){
                    island.setMap(row,i/2,stringcheck.nextInt());
                }
                row++;
            }
            island.intToCharConverter();
           // System.out.print(island);
            islandsize = island.findIsland();
           // System.out.print(island);
            System.out.print(islandsize);
        }
        catch(FileNotFoundException e){
            System.out.printf("The file not found. Exiting...\n");
        }
    }
}
