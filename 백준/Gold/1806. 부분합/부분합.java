import java.io.*;
import java.util.*;

public class Main {

    static int start, end;
    static int[] arr;
    static int n, m;
    static int ans = Integer.MAX_VALUE;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(stringTokenizer.nextToken());
        m = Integer.parseInt(stringTokenizer.nextToken());

        stringTokenizer = new StringTokenizer(br.readLine(), " ");

        arr = new int[n];
        for (int i=0;i<n;i++){
            arr[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        start = 0;
        end = 1;
        int sum = arr[0];
        while (start<n ){
            if(sum >= m){
                ans = Math.min(end-start, ans);
                if(start < end){
                    sum -= arr[start];
                    start++;
                } else{
                    if (end<n){
                        sum += arr[end];
                        end++;
                    }
                }

            } else if(sum < m &&  end<n){
                sum += arr[end];
                end++;
            }else{
                break;
            }
        }


        if(ans == Integer.MAX_VALUE){
            System.out.println(0);
            return;
        }

        System.out.println(ans);

    }


}