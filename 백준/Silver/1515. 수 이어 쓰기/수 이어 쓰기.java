import java.io.*;
import java.util.PriorityQueue;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split("");

        int idx = 0;
        int n = 0;
        int maxIdx = input.length;
        
        // n 부터 1씩 증가 시키면서 이어지는 수의 숫자가 일치하면 이어지는 수의 인덱스를 1증가 시킴.
        // 이때 n은 앞자리부터 일치하는 이어지는 수와 일치하는 숫자가 있는지 확인해주기
        while (true){
            n++;
            for (String current : String.valueOf(n).split("")){
                if(current.equals(input[idx])){
                    idx++;
                    if(idx >= maxIdx){
                        System.out.println(n);
                        return;
                    }
                }
            }
        }
    }

}