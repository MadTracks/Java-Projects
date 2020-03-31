import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CalculatorMain {
    public static void main(String[] args){
        Calculator calc = new Calculator();
        File myfile = new File(args[0]);
        try {
            Scanner myscanner = new Scanner(myfile);
            while(myscanner.hasNext()){
                String example = myscanner.nextLine();
                String postfix = calc.infixToPostfix(example);
                System.out.print(postfix);
                System.out.printf("\n");
            }

            double result = calc.postfixCalc();
            System.out.print(result);
        }
        catch(FileNotFoundException e){
            System.out.printf("File not found.Exiting...");
        }
    }
}
