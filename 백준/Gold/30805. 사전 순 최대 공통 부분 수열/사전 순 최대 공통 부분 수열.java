import java.io.*;
import java.util.*;

public class Main {

    static int a, b;

    static List<Integer> list1 = new LinkedList<>();
    static List<Integer> list2 = new LinkedList<>();
    static List<Integer> ans = new LinkedList<>();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        a = Integer.parseInt(br.readLine());

        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        for (int i=0; i<a;i++){
            list1.add(Integer.parseInt(stringTokenizer.nextToken()));
        }

        b = Integer.parseInt(br.readLine());
        stringTokenizer = new StringTokenizer(br.readLine());
        for (int i=0; i<b;i++){
            list2.add(Integer.parseInt(stringTokenizer.nextToken()));
        }

        while (!list1.isEmpty() && !list2.isEmpty()){
            int maxInList1 = list1.stream()
                    .max(Integer::compareTo)
                    .orElse(0);
            int maxIndexInList1 = list1.indexOf(maxInList1);

            int maxInList2 = list2.stream()
                    .max(Integer::compareTo)
                    .orElse(0);
            int maxIndexInList2 = list2.indexOf(maxInList2);

            if(maxInList1 == maxInList2){
                ans.add(maxInList1);
                list1 = list1.subList(maxIndexInList1+1, list1.size());
                list2 = list2.subList(maxIndexInList2+1, list2.size());
            }else{
                if(maxInList1 > maxInList2){
                    list1.remove(maxIndexInList1);
                }else{
                    list2.remove(maxIndexInList2);
                }
            }

        }

        System.out.println(ans.size());
        StringBuilder stringBuilder = new StringBuilder();
        ans.forEach(i-> stringBuilder.append(i).append(" "));
        System.out.println(stringBuilder);
    }
    
}