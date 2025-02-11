import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();

        int ans = 0;
        int n = Integer.parseInt(bufferedReader.readLine());

        for (int i=0;i<n;i++){
            int input = Integer.parseInt(bufferedReader.readLine());
            if(input != 0){
                ans += input;
                stack.add(input);
            }else {
                ans -= stack.pop();
            }
        }
        System.out.println(ans);

    }

}