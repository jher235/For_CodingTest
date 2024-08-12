import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] abCount = br.readLine().split(" ");
        String[] a = br.readLine().split(" ");
        String[] b = br.readLine().split(" ");

        int allCount = a.length + b.length;
        Set<String> abSet = new HashSet();
        abSet.addAll(List.of(a));
        abSet.addAll(List.of(b));
        int abSetCount = abSet.size();

        System.out.println(allCount - (allCount - abSetCount)*2);
    }
}