public class HW6Main {
    public static void main(String[] args){
        NLP mynlp = new NLP();
        mynlp.readDataset("dataset/0000026");
        System.out.println("tfIDF = " + mynlp.tfIDF("for","0000026"));
        System.out.println(mynlp.bigrams("for"));
        mynlp.printWordMap();
    }
}
