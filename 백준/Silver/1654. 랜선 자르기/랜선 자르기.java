import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine(), " ");

        int K = Integer.parseInt(stringTokenizer.nextToken());
        int N = Integer.parseInt(stringTokenizer.nextToken());

        ArrayList<Long> arr = new ArrayList<>(K);

        for (int i=0;i<K;i++){

            arr.add(Long.parseLong(br.readLine()));
        }

        long start = 1;
        long end = arr.stream().max(Long::compareTo).get()+1;

        while (true){

            if(end <= start+1){
                System.out.println(start);
                break;
            }

            long count =0;
            long mid = (end + start)/2;

            for (Long num : arr){
                count += (num / mid);
            }


            if(count < N){
                end = (end + mid -1 )/2;
            }
            if (count >= N ){
                start = (start + mid +1)/2;
            }
        }
    }

}