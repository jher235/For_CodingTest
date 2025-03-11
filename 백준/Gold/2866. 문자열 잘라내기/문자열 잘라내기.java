import java.io.*;
import java.util.*;


public class Main {

    public static int[] dp;


    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int R = Integer.parseInt(stringTokenizer.nextToken());
        int C = Integer.parseInt(stringTokenizer.nextToken());

        String[] texts = new String[C];
        String[] input = new String[R];

        for (int i=0; i<R;i++){
            input[i] = bufferedReader.readLine();
        }

        for (int i=0; i<C;i++){
            StringBuilder stringBuilder = new StringBuilder();
            for (int j=0; j<R;j++){
                stringBuilder.append(input[j].charAt(i));
            }
            texts[i] = stringBuilder.toString();
        }

        int start = 0;
        int end = C-1;

        while (start <= end){
            int mid = (start + end) / 2;

            Set<String> set = new HashSet<>();

            for (String text : texts){
                set.add(text.substring(mid));
            }

            if(set.size() >= C){
                start = mid + 1 ;
            }else{
                end = mid - 1;
            }


//            if(set.size() < C){
//                end = mid - 1;
//            }else{
//                start = mid + 1 ;
//            }
        }

        System.out.println(end);

    }

}