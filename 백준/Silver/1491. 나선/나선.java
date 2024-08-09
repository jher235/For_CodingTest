
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;


public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] s =  bufferedReader.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);

        if(n<=m){
            solution(n,m, false);
            return;
        }
        solution(m,n, true);
    }

    private static void solution(int min, int max, boolean change){

        if(!change){//m>n일때
            int ansMin = (min-1)/2;
            if(min%2!=0){//홀수면
                print( ansMin, max - ansMin -1);
                return;
            }
            print(ansMin,  ansMin +1);
        }else{//m<n
            int ansMin = (min)/2;
            if(min%2!=0){//홀수면
                print(max - ansMin -1 , ansMin);
                return;
            }
            print(ansMin-1 , ansMin);
        }

    }

    private static void print(int n, int m){
        System.out.println(n + " " + m);
    }
}