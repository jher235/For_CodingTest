import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static long N;

    // 핵심은 3의 배수만 사용한 N 번째로 작은 수를 찾는 것이므로 이진수로 변경한 뒤 삼진수로 계산하는 것
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long N = Long.parseLong(br.readLine());


        String bitString = Long.toBinaryString(N);
        char[] bits =  bitString.toCharArray();

        // System.out.println(bitString);

        long ans = 0;
        long threeNum = 1;

        for (int i=0; i < bits.length; ++i){

            if(bits[bits.length - 1 - i] == '1'){

                ans += threeNum;
            }
            threeNum *= 3;
        }

        System.out.println(ans);

    }

}