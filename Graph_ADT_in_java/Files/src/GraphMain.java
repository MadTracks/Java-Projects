import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GraphMain {
    public static void main(String[] args) throws FileNotFoundException {
        File myfile = new File("input.txt");
        Scanner myscanner = new Scanner(myfile);
        int size = myscanner.nextInt();
        int relation = myscanner.nextInt();
        PopularityGraph mygraph = new PopularityGraph(size);
        while(myscanner.hasNextInt()){
            int k=myscanner.nextInt();
            int m=myscanner.nextInt();
            mygraph.addEdge(k,m);
        }
        int mppn = mygraph.mostPopularPeopleNumber();
        System.out.println(mygraph);
        System.out.println("Most Popular People Number:" + mppn);
    }
}
