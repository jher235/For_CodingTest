import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int start, end;

    static int count = 0;



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine(), " ");

        start = Integer.parseInt(stringTokenizer.nextToken());
        end = Integer.parseInt(stringTokenizer.nextToken());


        while (end > start){
            if(end % 10 == 1){
                end /= 10;
                count++;
                continue;
            }else if (end % 2 == 0){
                end /=2;
                count++;
            }else{
                System.out.println(-1);
                return;
            }
        }

        if( end == start){
            System.out.println(count+1);
        }else {
            System.out.println(-1);
        }

    }

}