package src.main.java;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class ParenSymmetry {


    public Boolean isBalanced(String s) {
        char openBrace = '(';
        int openBraceCount = 0;
        char closingBrace = ')';
        int closingBraceCount = 0;

        char[] charArray = s.toCharArray();

        for (int i = 0; i < charArray.length; i++) {
            if(charArray[i] == openBrace){
                openBraceCount++;
            }else if(charArray[i] == closingBrace){
                closingBraceCount++;
            }
        }
        if(openBraceCount == closingBraceCount && openBraceCount > 0){
//            System.out.println("Open brace: "+openBraceCount+"\nClosed Brace: "+closingBraceCount);
//            System.out.println("RETURNING TRUE");
            return true;
        }else
//            System.out.println("Open brace: "+openBraceCount+"\nClosed Brace: "+closingBraceCount);
//            System.out.println("RETURNING FALSE");
            return false;

    }

    private static void checkFile(String filename) throws IOException {
        // open file named filename
       BufferedReader br = new BufferedReader(new FileReader(filename));
       String line;// for each line in the file
       while((line = br.readLine()) != null){ // read the line
           System.out.println(line); // print whether the line's parenthesis are balanced
       }
        br.close(); // CLOSE the file
    }


    public static void main(String[] args) {
        ParenSymmetry ps = new ParenSymmetry();

        Boolean b0 = ps.isBalanced("()");
        printResult(b0, true);

        String[] falseStrings = {"(", "((", ")", "", "(()())((())))"};
        Boolean falses = true;
        for (String strToTest : falseStrings) {
            falses = ps.isBalanced(strToTest);
        }
        printResult(falses, false);

        String[] trueStrings = {"()", "(())", "(((())))", "", "(()())((()))", "(   )", "( () ( ) )"};
        Boolean trues = false;
        for (String strToTest : trueStrings) {
            trues = ps.isBalanced(strToTest);
        }
        printResult(trues, true);

    }

    private static void printResult(Boolean b0, boolean b) {
        if (b0 == null) {
            System.out.println("Null Failure");
            return;
        }
        if (b0 == b) {
            System.out.println("Success");
        } else {
            System.out.println("Failure");
        }
    }
}
