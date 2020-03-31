import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class NLP
{
    public Word_Map wmap;

    /*You should not use File_Map class in this file since only word hash map is aware of it.
    In fact, you can define the File_Map class as a nested class in Word_Map,
     but for easy evaluation we defined it separately.
     If you need to access the File_Map instances, write wrapper methods in Word_Map class.
    * */

    /*Reads the dataset from the given dir and created a word map */
    public void readDataset(String dir)
    {
        try {
            File myfile = new File(dir);
            Scanner myscanner = new Scanner(myfile);
            int position = 0;
            wmap = new Word_Map();
            String key = myscanner.next();
            while(myscanner.hasNext()){
                String value = myscanner.next();
                wmap.put(key,wmap.createFile_Map(value,position));
                position++;
                key = value;
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found. Exiting...");
        }
    }


    /*Finds all the bigrams starting with the given word*/
    public List<String> bigrams(String word){
        if(wmap.containsKey(word)){
            HashSet<String> set = (HashSet<String>) wmap.callFile_Map(word).keySet();
            ArrayList<String> bigram = new ArrayList();
            bigram.addAll(set);
            return bigram;
        }
        return null;
    }


    /*Calculates the tfIDF value of the given word for the given file */
    public float tfIDF(String word, String fileName)
    {
        float TF = (float) wmap.callFile_Map(word).size()/wmap.size();
        float IDF = (float) Math.log(wmap.CURRCAP/wmap.callFile_Map(word).size())*(fileName.charAt(0)+1);
        return TF*IDF;
    }

    /*Print the WordMap by using its iterator*/
    public  void printWordMap()
    {
        System.out.println(wmap);
        /*I did it in Word_Map class (toString method) with using iterator.*/
    }

}
