import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    private static int N, K;
    private static int ans = 0;

    private static int[] wordSet;

    private static int a = 'a' - 'a';
    private static int n = 'n' - 'a';
    private static int t = 't' - 'a';
    private static int i = 'i' - 'a';
    private static int c = 'c' - 'a';


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        wordSet = new int[N];

        for (int i=0;i<N;i++){
            char[] input = br.readLine().toCharArray();
            Set<Character> wordChar = new HashSet<>();

            for (char c : input){
                if(!wordChar.contains(c)){
                    wordChar.add(c);
                    wordSet[i] |= 1 << (c - 'a');
                }
            }


        }

        if(K < 5){
            System.out.println(ans);
            return;
        }

        int learnedChar = 0;
        learnedChar |= 1 << a;
        learnedChar |= 1 << n;
        learnedChar |= 1 << t;
        learnedChar |= 1 << i;
        learnedChar |= 1 << c;

        solve(0, learnedChar);

        System.out.println(ans);

    }


    private static void solve(int idx, int learnedChars){
        int charCount = Integer.bitCount(learnedChars);

        if(charCount == K){
            int newCount = 0;
            for (int word : wordSet){
                if(learnedChars == (learnedChars | word)){
                    newCount++;
                }
            }
            ans = Math.max(ans, newCount);
            return;
        }

        if(idx > 26){
            return;
        }


        solve(idx + 1, learnedChars);
        solve(idx + 1, learnedChars | (1 << idx - 'a'));
        
    }


}