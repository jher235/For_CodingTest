import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer input =new StringTokenizer(br.readLine());
        int n = Integer.parseInt(input.nextToken());
        int m = Integer.parseInt(input.nextToken());

        int containCount = 0;

        Set<String> setN = new HashSet<>(n); //문제 조건이 단어 집합을 제공하는 것이므로 순서는 고려할 필요 없다. 따라서 HashSet을 사용한다.
        
        for (int i=0;i<n; i++){
            setN.add(br.readLine());
        }
        
        for (int i=0;i<m; i++){
            String inputM = br.readLine();
            if(setN.contains(inputM)){
                containCount++;
            }
        }

        System.out.println(containCount);
    }
}