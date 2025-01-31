import javax.print.DocFlavor;
import java.io.*;
import java.util.StringTokenizer;


public class Main {

    static int L;
    static String input;
    static int MULTIPLICATION_PRIME_NUMBER = 31;
    static int DIVISION_PRIME_NUMBER = 1234567891;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        L = Integer.parseInt(br.readLine());
        input = br.readLine();
//        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine()," ");        N = Integer.parseInt(stringTokenizer.nextToken());

        int a = 'a';

        long ans = 0L;
        for (int i=0;i<L;i++){
            ans += hashing((int)input.charAt(i) - (a-1), i);
        }
        System.out.println(ans);
    }

    private static Long hashing(int number, int degree){
        long result = 1;
        if (degree != 0){
            result = MULTIPLICATION_PRIME_NUMBER;
        }
        for (int i=1;i<degree;i++){
            result *= MULTIPLICATION_PRIME_NUMBER;
            result %= DIVISION_PRIME_NUMBER;
        }
        return number * result % DIVISION_PRIME_NUMBER;
    }

}