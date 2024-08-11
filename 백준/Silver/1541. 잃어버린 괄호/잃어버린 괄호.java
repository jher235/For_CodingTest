import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String formula = bufferedReader.readLine();
        long ans=0;
        String positiveFormula = formula.split("[-]")[0];
        String[] positiveNumbers = positiveFormula.split("[+]");

        String negativeFormula = formula.substring(positiveFormula.length());
        String[] negativeNumbers = negativeFormula.split("[+|-]");

        for (String str: positiveNumbers){
            if (!str.equals("")){
                ans += Long.parseLong(str);
            }
        }

        for (String str: negativeNumbers){
            if(!str.equals("")){
                ans -= Long.parseLong(str);
            }
        }
        System.out.println(ans);
    }
}