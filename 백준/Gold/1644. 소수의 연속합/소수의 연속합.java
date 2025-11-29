import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.StringTokenizer;


public class Main {

    final static int maxN = 4_000_000;
    static int N;
    static boolean[] isPrime = new boolean[maxN + 1];

    static int startIdx = 0;
    static int endIdx = 0;

    static long sum = 2;
    static int ans = 0;

    static List<Integer> primeNumbers = new ArrayList<>(300_000);

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        Arrays.fill(isPrime, true);

        isPrime[0] = false;
        isPrime[1] = false;

        for (int i = 2; i <= maxN; i++) {
            if(isPrime[i]) {
                primeNumbers.add(i);
                if(i + i <= maxN) {
                    for (int j = i + i; j <= maxN; j += i) {
                        isPrime[j] = false;
                    }
                }
            }
        }

        while (startIdx < primeNumbers.size() && endIdx < primeNumbers.size()) {
            if(sum == N) {
                ans++;
                endIdx++;
                if(endIdx < primeNumbers.size()) {
                    sum += primeNumbers.get(endIdx);
                }
            }else if(sum > N) {
                sum -= primeNumbers.get(startIdx);
                startIdx++;
            }else if (sum < N){
                endIdx++;
                if(endIdx < primeNumbers.size()) {
                    sum += primeNumbers.get(endIdx);
                }
            }
        }

        System.out.println(ans);
    }

}