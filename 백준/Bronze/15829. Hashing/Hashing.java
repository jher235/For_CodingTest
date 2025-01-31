import java.io.*;
import java.math.BigInteger;
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

        BigInteger ans = new BigInteger("0");
        for (int i=0;i<L;i++){
            ans = ans.add(hashing((int)input.charAt(i) - (a-1), i));
            ans = ans.remainder(BigInteger.valueOf(DIVISION_PRIME_NUMBER));
        }
        System.out.println(ans);
    }

    private static BigInteger hashing(int number, int degree){
        BigInteger result = new BigInteger("1");
        for (int i=0;i<degree;i++){
            result = result.multiply(BigInteger.valueOf(MULTIPLICATION_PRIME_NUMBER));
            result = result.remainder(BigInteger.valueOf(DIVISION_PRIME_NUMBER));
        }
        return result.multiply(BigInteger.valueOf(number)).remainder(BigInteger.valueOf(DIVISION_PRIME_NUMBER));
    }

}