import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;




public class Main {

    private static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        int bitCount = Integer.bitCount(N);

        String binaryString = Integer.toBinaryString(N);

        int len = binaryString.length();

        int minSize = 0;
        if(bitCount == 1){
            System.out.println(N + " " + 0);
            return;
        }else {
            minSize |= (1<< len);
        }

        int lastOne = 0;
        for (int i=1; i<len; i++){
            char c = binaryString.charAt(i);
            if(c == '1'){
                lastOne = i;
            }
        }

        System.out.println(minSize + " " + ++lastOne );

    }


}