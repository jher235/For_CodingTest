import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.StringTokenizer;

class Main{
    private static int N;

    private static char[] chars = {'A', 'B', 'C', 'D', 'E', 'F'};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(br.readLine());

        for (int i=0; i<N; i++){
            String input = br.readLine();
            if (isInfected(input)) {
                System.out.println("Infected!");
            }else{
                System.out.println("Good");
            }
        }
    }

    private static boolean isInfected(String input){

        int length = input.length();

        char[] c = input.toCharArray();

        boolean first = false;
        boolean A = false;
        boolean F = false;
        boolean C = false;


        int i=0;
        if(Objects.equals(c[i], 'A')){
            A = true;
            first = true;
            while (c[i] == 'A'){
                i++;

                if(i >= length){
                    return false;
                }
            }
        }

        if(!first){
            for (char c2: chars){
                if(Objects.equals(c2, c[i])){
                    first = true;
                }
            }
            i++;
        }

        if(!first){
            return false;
        }

        if(!A){
            if(c[i] != 'A'){
                return false;
            }
            while (c[i] == 'A'){
                i++;

                if(i >= length){
                    return false;
                }
            }
            A = true;
        }

        if(!F){
            if(c[i] != 'F'){
                return false;
            }
            while (c[i] == 'F'){
                i++;

                if(i >= length){
                    return false;
                }
            }
            F = true;
        }

        if(!C){
            if(c[i] != 'C'){
                return false;
            }
            while (c[i] == 'C'){
                i++;

                if(i >= length){
                    return true;
                }
            }
            C = true;
        }

        if(i == length-2){
            for (char c2: chars){
                if(Objects.equals(c2, c[i])){
                    return true;
                }
            }
        }
        return false;

    }

}
