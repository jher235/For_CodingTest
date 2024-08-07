
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;


public class Main {
    private static int tryCount = 1;
    private final static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        while (true){
            int num = Integer.parseInt(bufferedReader.readLine());
            if(num==0) return;
            findLostStudentsNum(num);
        }


    }

    private static void findLostStudentsNum(int num) throws IOException {
        String[] students = new String[num+1];
        Set<String> stdNum = new HashSet<>();
        for (int i=1;i<=num;i++){
            students[i] = bufferedReader.readLine();
        }
        for(int i=0;i<2*num-1;i++){
            String number = String.valueOf(bufferedReader.readLine().split(" ")[0]);
            if(stdNum.contains(number)){
                stdNum.remove(number);
                continue;
            }
            stdNum.add(number);
        }
        stdNum.stream().forEach(i-> {
            System.out.println(tryCount+" "+students[Integer.parseInt(i)]);
        });
        tryCount++;
    }
}